package com.darkRealm.Recursion_and_DynamicProg;

import com.darkRealm.BigO.MathUtil;

import java.math.BigInteger;
import java.util.*;

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
    HashMap<String, Integer> cache = new HashMap<>();
//    String path = getRobotgridPath(matrix, rows, cols);
    String path = getRobotgridPathMemoized(matrix, rows, cols, cache);
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

  private static String getRobotgridPathMemoized(int[][] matrix, int row, int col, HashMap<String, Integer> cache) {
    String path1, path2, finalResult, key;
    path1 = path2 = finalResult = "";
    key = "" + row + "," + col;
    cache.put(key, matrix[row][col]);

    if (matrix[row][col] == 1) {
      return " invalid ";
    }

    if (row == 0 && col == 0) {
      return " --> [0][0] - Home";
    }

    if (row > 0) {
      path1 = " --> [" + row + "] [" + col + "]";
      key = "" + (row - 1) + "," + col;
      if (cache.containsKey(key)) {
        path1 += cache.get(key);
      } else {
        path1 += getRobotgridPathMemoized(matrix, row - 1, col, cache);
      }
    }
    if (col > 0) {
      path2 = " --> [" + row + "] [" + col + "]";
      key = "" + row + "," + (col - 1);
      if (cache.containsKey(key)) {
        path2 += cache.get(key);
      } else {
        path2 += getRobotgridPathMemoized(matrix, row, col - 1, cache);
      }
    }
    if (path1.contains("Home")) {
      finalResult += "\n" + path1;
    }
    if (path2.contains("Home")) {
      finalResult += "\n" + path2;
    }
    return finalResult;
  }

  /*  [Prob 8.4]
 *   Q) Write a method to print power set.
 *   A) this is the optimal logic present, which is to print the ith number when the ith bit is true.
 *      lets say set is [1,2,3] so the size of power set would be 2^3 (size of given set)
 *     for i =0 to power set size,  for each ith bit of i which is 1, add the ith number to the set
 *   Set  = [a,b,c]
 *   power_set_size = pow(2, 3) = 8
 *   Run for binary counter = 000 to 111
 *   Value of Counter            Subset
 *   000                    -> Empty set
 *   001                    -> a
 *   011                    -> ab
 *  100                     -> c
 *  101                     -> ac
 *  110                     -> bc
 *  111                     -> abc
 *   @params : matrix, a matrix with 0/1 0 for valid cell, 1 for invalid cell
 *   @return : String, a path for robot form start to begining
 * */
  public static String printPowerSet(char[] set) {
    String result = "";
    int powerSetSize = (1 << set.length); // 2^ set.len  as shifting 1 right by set length will result in getting multiplied by 2
    int temp; // temp var to hold current value from power set size
    int bi;  // to and & with the ith bit with 1 in order to see if its 1 or 0
    int count = -1;
    String powerSet = "";
    String tempSet = "";
    powerSet += "[";
    for (int i = 0; i < powerSetSize; i++) {
      temp = i;
      // the idea is to print the ith no from set, if the ith bit is set to 1, why because of above logic
      tempSet = "";
      tempSet += "{";
      count = -1;
      while (temp > 0) {
        bi = 1 & temp;
        count++;
        if (bi == 1) {
          tempSet += set[count] + ", ";
        }
        temp = temp >> 1;
      }
      tempSet += "} ";
      powerSet += " " + tempSet + " ,";
    }
    powerSet += " ]";
    return powerSet;
  }

  /*
  * Prob [8.7]
  * Q) Permutaiton wohtout Duplicates, to compute all permutations of string of unique characters
  * A)  use the permutation algo, take a char out as prefix and the rest as remainder & recursively loop
  * @params   str: string whose permutation has to be calculated
  * @returns  void
  * */

  public static void printtAllPermuationsWithOutDups(String str) {
    calculatePermuation(str, "");
  }

  private static void calculatePermuation(String str, String prefix) {
    if (str.length() == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < str.length(); i++) {
        String rem = str.substring(0, i) + str.substring(i + 1);
        calculatePermuation(rem, prefix + str.charAt(i));
      }
    }
  }

  /*
 * Prob [8.8]
 * Q) Permutaiton with Duplicates, to compute all permutations of string of unique characters
 * A)  use the permutation algo, take a char out as prefix and the rest as remainder & recursively loop
 * @params   str: string whose permutation has to be calculated
 * @returns  set of all unique permutations of the string
 * */
  public static Set printtAllPermuationsWithDups(String str) {
    HashSet<String> set = new HashSet<>();
    calculatePermuationwithDups(str, "", set);
    return set;
  }

  private static void calculatePermuationwithDups(String str, String prefix, HashSet<String> set) {
    if (str.length() == 0 && !set.contains(prefix)) {
      set.add(prefix);
    } else {
      for (int i = 0; i < str.length(); i++) {
        String rem = str.substring(0, i) + str.substring(i + 1);
        calculatePermuationwithDups(rem, prefix + str.charAt(i), set);
      }
    }
  }

  /*
  * [Prob 8.9]
  * Q) Parens, print all vlaid proper combinations of pairs of parenthesis
  * A) use left & right paren count to see if its a valid expresssion to add left or right paren
  * */
  public static ArrayList<String> printAllParensCombo(int n) {
    int leftRem, rightRem, index = 0;
    leftRem = rightRem = n;
    char[] output = new char[n * 2];
    ArrayList<String> permutations = new ArrayList<>();
    getAllParensPermute(leftRem, rightRem, output, index, permutations);
    return permutations;
  }

  private static void getAllParensPermute(int leftRem, int rightRem, char[] output, int index, ArrayList<String> permutations) {
    if ((leftRem == 0) && (rightRem == 0)) {
      String paran = String.copyValueOf(output);
      permutations.add(paran);
    } else {
      if (leftRem > 0) {
        output[index] = '(';
        getAllParensPermute(leftRem - 1, rightRem, output, index + 1, permutations);
      }
      if (rightRem > leftRem) {
        output[index] = ')';
        getAllParensPermute(leftRem, rightRem - 1, output, index + 1, permutations);
      }
    }
  }

  /*  [Prob 8.3]
  *   Q) Magic Index in an Array A[0 1 ... n-1 ]is defined to be an index such that A[i] == i. Givne a sorted array of
  *   distinct integers find if there exists a magic index
  *   A)  Fisrt - Brute force check sequntially - O(n)
  *       Second - used Binary search by index, if arr[mid] < mid then search in lower half, else in upper half,
  *                 but this fails when there are duplicates in an array
  *       Third - we use the second approach but a bit modified, instead of creating range by low to mid-1 OR mid+1 to high
  *               we will take the min among arr[mid] & mid-1 for lower half & for higher half we will take max of arr[mid] & mid+1
  *       Complexity - O(logn)
  *   @params : arr, an arrray of integers
  *   @return : a magic index if present else -1
  * */

  public static int magicIndex(int[] arr, int low, int high) {
    if (high < low) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (mid == arr[mid]) {  // if index == mid magic index found
      return mid;
    }

    int smallHigh = Math.min(mid - 1, arr[mid]);  // we will be looking in the lower half recursively, but by the min of mid -1 & arr[mid]
    int found = magicIndex(arr, low, smallHigh);
    if (found >= 0) {
      return found;
    }

    int bigLow = Math.max(mid + 1, arr[mid]); // we will be looking in the upper half recursively, but by the max of mid +1 & arr[mid]
    return magicIndex(arr, bigLow, high);
  }

  /*  [Prob 8.5]
  *   Q) write a recursive function to multply two nos without using * opertor, should be most optimal
  *   A)  use Karatsuba Multiplication algorithm, assuming both nos are of same length
  *   Complexity :
  *  @params : x-  first number
  *  @params : y - second number
  *  @returns : the product of two nos
  * */

  public static long mulitply(int x, int y) {
    long result = doKaratsubaMuliplication(x, y);
    return result;
  }

  private static long doKaratsubaMuliplication(long x, long y) {
    if (x < 10 || y < 10) {
      return x * y;
    }

    long len = (long) Math.log10(x) + 1;


    long powerOfTen = (long) Math.pow(10, len / 2);

    long a = (long) (x / powerOfTen);
    long b = (long) (x % powerOfTen);

    long c = (long) (y / powerOfTen);
    long d = (long) (y % powerOfTen);

    long ac = doKaratsubaMuliplication(a, c);
    long bd = doKaratsubaMuliplication(b, d);
    long abcd = doKaratsubaMuliplication(a + b, c + d);
    long first = ac;
    long mid = abcd - ac - bd;
    long last = bd;
    long result = (long) ((first * Math.pow(10, len)) + (mid * Math.pow(10, len / 2)) + last);
    return result;
  }

  /*This method is not useful, will remove it*/
//  private static BigInteger doKaratsubaMuliplication(BigInteger x, BigInteger y) {
//
//    int N = Math.max(x.bitLength(), y.bitLength());  // getting the longer number's bits
//    if (N <= 2) {
//      return x.multiply(y);
//    }
//    // Number of bits divided by 2 & rounded
//    N = (N / 2) + (N % 2);
////    BigInteger b = x.shiftRight(N);
////    BigInteger a = x.subtract(b.shiftLeft(N));
////
////    BigInteger d = y.shiftRight(N);
////    BigInteger c = y.subtract(d.shiftLeft(N));
//
//    BigInteger a = x.shiftRight(N);
//    BigInteger b = x.subtract(a.shiftLeft(N));
//
//    BigInteger c = y.shiftRight(N);
//    BigInteger d = y.subtract(c.shiftLeft(N));
//
//
//
//    BigInteger ac, bd, abcd, ad_plus_bc;
//
//    ac = doKaratsubaMuliplication(a, c);
//    bd = doKaratsubaMuliplication(b, d);
//    abcd = doKaratsubaMuliplication(a.add(b), c.add(d));
//    // Gauss trick = (a+b)(c+d) - ad - bc = ad + bc
//    ad_plus_bc = abcd.subtract(ac).subtract(bd);
//    // Main formula
//    // 10^N * ac + 10^(N/2) *( ad+bc) + bd
//    BigInteger X_into_Y = ac.add(ad_plus_bc).add(bd.shiftRight(2 * N));
//    return X_into_Y;
//  }
}