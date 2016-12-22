package com.darkRealm.Recursion_and_DynamicProg;

import java.util.Arrays;

/**
 * Created by Jayam on 12/20/2016.
 */
public class Recursion_and_DP {

  /* [Example - Ch 8 - FibonacciNos]
  *  Top down approach - memoization
  * @params   takes a number n to calcluate the Nth fibonacci number
  * @return   returns a long which is the Nth fibonacci number
  * */
  public static long NthFibonacciMemoized(int n) {
    long[] arr = new long[n + 1];
    long res = getNthFibonacciNumber(n, arr);
    return res;
  }

  private static long getNthFibonacciNumber(int n, long[] fiboArray) {
    if (n == 0 || n == 1) {
      return 1;
    }
    if (fiboArray[n] == 0) {
      fiboArray[n] = getNthFibonacciNumber(n - 1, fiboArray) + getNthFibonacciNumber(n - 2, fiboArray);
    }
    return fiboArray[n];
  }

  /*  [Example - Ch 8 - FibonacciNos]
  *   Bottom Up approach - iteration
  *   @params   takes a number n to calculate the Nth fibonacci number
  *   @return   returns a long which is the Nth fibonacci number
  * */
  public static long NthFibonacciIterative(int n) {
    int temp, a, b, c;
    a = 0;
    b = 1;
    c = a + b;
    if (n == 0) {
      return 0;
    }

    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return (long) c;
  }

  /*  [Prob - 8.1]
  *   Q) Triple Step: A child is running up a stair case with n steps & can hop either 1,2 or 3 stpes at a time.
  *     Implement a method to count how many ways the child can tun up the stairs
  *   A) will be using Top Down approach & calculate ways by recursing in the subtree.
  *     tip - using int willbe overflowing after n = 37, thus we can use long but that will not solve the problem,
  *     but remember to state this issue if required.
  *   @params   n: takes the staircase steps count
  *   @params   K: takes the no of hops kid can make, assuming incremented by 1
  *   @returns  returns the No of ways for reaching the top
  * */

  public static long TripleSteps(int n, int k) {
    long noOfWays = 0;
    long[] stepsArr = new long[n + 1];
    Arrays.fill(stepsArr, -1);
//    noOfWays = getNoOfWaysSteps(n);
    noOfWays = getNoOfWaysStepsMemoized(n, stepsArr);
    return noOfWays;
  }

  /*Memoized version*/
  private static long getNoOfWaysStepsMemoized(int n, long[] stepsArr) {
    long w1, w2, w3;
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (stepsArr[n] == -1) {
      w1 = getNoOfWaysStepsMemoized(n - 1, stepsArr);
      w2 = getNoOfWaysStepsMemoized(n - 2, stepsArr);
      w3 = getNoOfWaysStepsMemoized(n - 3, stepsArr);
      stepsArr[n] = w1 + w2 + w3;
    }
    return stepsArr[n];
  }

  private static int getNoOfWaysSteps(int n) {
    int w1, w2, w3;
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    w1 = getNoOfWaysSteps(n - 1);
    w2 = getNoOfWaysSteps(n - 2);
    w3 = getNoOfWaysSteps(n - 3);
    return w1 + w2 + w3;
  }

  /*  [Prob 8.2]
  *   Q) Robot in a grid : starting from top left, can only move in two directions down & right.
  *   But certain cells are marked as invalid so robot cannot step on them. find a path for robot top left to bottom right.
  *   A) will use top DOwn apporoach & invalidate a path if it encounters a invalid cell or doesnt ends on begining
  *   @params : matrix, a matrix with 0/1 0 for valid cell, 1 for invalid cell
  *   @return : String, a path for robot form start to begining
  * */

  public static String RobotGridPath(int[][] matrix) {
    int rows = matrix.length - 1;
    int cols = matrix[0].length - 1;
    String path = getRobotgridPath(matrix, rows, cols);
    return path;
  }

  private static String getRobotgridPath(int[][] matrix, int row, int col) {
    String path1, path2, finalResult;
    path1 = path2 = finalResult = "";
    if (matrix[row][col] == 1) {
      return " invalid ";
    }

    if (row == 0 && col == 0) {
      return " --> [0][0] - Home";
    }

    if (row >= 1) {
      path1 = " --> [" + row + "] [" + col + "]" + getRobotgridPath(matrix, row - 1, col);
    }
    if (col >= 1) {
      path2 = " --> [" + row + "] [" + col + "]" + getRobotgridPath(matrix, row, col - 1);

    }
    if (path1.contains("Home")) {
      finalResult += "\n" + path1;
    }
    if (path2.contains("Home")) {
      finalResult += "\n" + path2;
    }
    return finalResult;
  }
}