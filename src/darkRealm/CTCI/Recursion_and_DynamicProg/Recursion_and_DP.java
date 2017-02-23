package darkRealm.CTCI.Recursion_and_DynamicProg;

import darkRealm.CTCI.Stacks_and_queues.MyStack;

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
//    long result = doKaratsubaMuliplication(x, y);
    int len = (int) (Math.log(x) / Math.log(2));
    HashMap<Long, Long> map = new HashMap<>();
    return doMulitply(x, y, map);
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

  private static long doMulitply(long x, long y, HashMap<Long, Long> map) {
    if (x == 1) {
      return y;
    }
    long result = -1;
    int index = (int) Math.log10(x) + 1;

    if ((x & 1) == 1) {
      if (!map.containsKey(x)) {
        result = doMulitply((x - 1) >> 1, y, map);
      } else {
        result = map.get(x);
      }
      result += result;
      result += y;
      map.put(Long.valueOf(x), result);
    } else {

      if (!map.containsKey(x)) {
        result = doMulitply(x >> 1, y, map);
      } else {
        result = map.get(x);
      }
      result += result;
      map.put(Long.valueOf(x), result);
    }
    return map.get(Long.valueOf(x));
  }

  /*  [Prob 8.6]
  *   Q) Towers of hanoi
  *   A) use recursion,
  *     First : move (plateNo -1) from source tower to buffer, using buffer as place holder
  *     Second : move (plateNo-1) from source to destination
  *     Third : move from buffer to destination, using source as placeholder
  *     Base Case : if Plate is last (plateNo == 1) move from
  * @params : takes in integer giving the size of tower
  * @returns : nothing
  * */
  public static void towerOfHanoi(int n) {

    MyStack<Integer> tower1 = new MyStack<>();
    int maxplate = n;
    // prepare stack with plates
    while (n > 0) {
      tower1.push(n);
      n--;
    }
    MyStack<Integer> tower2 = new MyStack<>();
    MyStack<Integer> tower3 = new MyStack<>();
    System.out.println("Before ");
    System.out.println("Tower 1 " + tower1.toString());
    System.out.println("Tower 2 " + tower2.toString());
    System.out.println("Tower 3 " + tower3.toString());
    long before = System.currentTimeMillis();
    movePlateToTower(maxplate, tower1, tower3, tower2);
    long after = System.currentTimeMillis();
    System.out.println("See the towers now time ms - " + (after - before));
    System.out.println("Tower 1 " + tower1.toString());
    System.out.println("Tower 2 " + tower2.toString());
    System.out.println("Tower 3 " + tower3.toString());
  }

  private static void movePlateToTower(int plateNo, MyStack<Integer> towerSource,
                                       MyStack<Integer> towerDestination, MyStack<Integer> towerBuffer) {
    if (plateNo == 1) {
      int plate = towerSource.pop();
      towerDestination.push(plate);
      return;
    } else {
      // move from source to buffer, use destination as place holder
      movePlateToTower(plateNo - 1, towerSource, towerBuffer, towerDestination);
      // now, move from source to destination
      int plate = towerSource.pop();
      towerDestination.push(plate);
      // move from buffer to dest, use source as place holder
      movePlateToTower(plateNo - 1, towerBuffer, towerDestination, towerSource);
    }
  }

  /*  [Prob 8.10]
  *   Q) Paint Fill : Implement a paint fill funcitonality, if image is represented by a 2 array of colors,
  *     select a color & fill untill all the colors are replaced.
  *   A) paint the given pixel with the new color, then burst in every direction to fill all the matching pixel with same color
  *   to replace with new color
  *   @params : a 2d array to fill by paint
  *   @return : nothing
  * */
  public static void painFill(COLOR[][] picture, int row, int col, COLOR newColor) {
    COLOR oldColor = picture[row][col];
    fillRepeatedly(picture, row, col, newColor, oldColor);
  }

  private static void fillRepeatedly(COLOR[][] picture, int row, int col, COLOR newColor, COLOR oldColor) {
    if ((row >= 0 && row < picture.length) && (col >= 0 && col < picture[0].length)) {
      if (picture[row][col] == oldColor) {
        //burst out in all directions for filling
        picture[row][col] = newColor;
        fillRepeatedly(picture, row - 1, col, newColor, oldColor);  //up
        fillRepeatedly(picture, row + 1, col, newColor, oldColor);  // down
        fillRepeatedly(picture, row, col - 1, newColor, oldColor);   // left
        fillRepeatedly(picture, row, col + 1, newColor, oldColor);    // right
      }
    }

  }

  public enum COLOR {
    BLACK,
    RED,
    GREEN,
    BLUE
  }

  public static boolean balancedParanthesis(String pattern) {
    if (pattern.length() == 0 || ((pattern.length() & 1) == 1)) {
      return false;
    }
    MyStack<Character> stack = new MyStack<>();
    String allowedChars = "(){}[]";
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (allowedChars.indexOf(c) == -1) {
        return false;
      }
      if (c == '{' || c == '(' || c == '[') {
        stack.push(c);
      } else if (!stack.isEmpty()) {
        char c2 = stack.peek();
        if (c2 == '{' && c == '}')
          stack.pop();
        else if (c2 == '[' && c == ']')
          stack.pop();
        else if (c2 == '(' && c == ')')
          stack.pop();
      }
    }
    return stack.getSize() == 0 ? true : false;
  }

  /*
  * Prob [8.11]
  * Q)  Given an infinite nos of quarters(25 cents), dimes (10 cents), nickels (5 cents) & pennies(1 cent)
  *     Calculate the no of ways to represent n cents
  * A) Will use recursion again, as I used for steps problem
  * @params :  a double, the target amount to reach
  * @returns  : the total no of ways to reach the amount using the cents
  * */

  public static long waysToReachN(double n) {
    n = n * 100;
    return calculateWaysToReachN((int) n);
  }

  public static long calculateWaysToReachN(int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    int quarters = 0;
    while (n > 25) {
      n -= 25;
      quarters++;
    }
    int dimes = 0;
    while (n > 10) {
      n -= 10;
      dimes++;
    }
    n -= 5;
    int nickles = 1;
    int pennies = 0;
    while (n > 0) {
      n -= 1;
      pennies++;
    }
    return quarters + dimes + nickles + pennies;
  }

  /*  [Prob - 8.12]
  *   Q) Placing Eight queens, write an algo to get all the ways to place eight queens on a 8*8 chess board.
  *       So that no two queens are on same row, col, or diagonal
  *   A) loop through cloumns & try place a queen on each row, but before placing check if the queen that is going to be
  *   place on the position is it safe on that postion, ie. the safety is calculated on 3 points
  *   a: On SAME ROW [ we check this with positions of previous queen from the position array]
  *   b: On DIAGONALLY UP [we check this using a formula : rowForQueen == prevRow +- (QueenNo - i) , where i is loop variant]
  *   c: On DIAGONALLY DOWN [same formula as above]
  *   if above 3 criterias are false for the queen on the new postion, then it is safe to be placed.
  * */
  public static void placeNQueens(int totalQueens) {
    int[] positions = new int[totalQueens];
    solve(0, totalQueens, positions);
  }

  private static long QueenSolutionsCount = 0;

  private static void solve(int queenNo, int N, int[] positions) {
    if (queenNo == N) {
      QueenSolutionsCount++;
      for (int i :
          positions) {
        System.out.print(" " + i);
      }
      System.out.println("\n----------Soln----------" + QueenSolutionsCount);
    } else {
      // have to try place a queen on each row
      for (int i = 0; i < N; i++) {
        // check if this position is safe
        if (isSafe(i, queenNo, positions)) {
          positions[queenNo] = i; // if safe then place the queen on this position
          solve(queenNo + 1, N, positions); // solve for next queen
        }
      }
    }
  }

  private static boolean isSafe(int rowToPutQueen, int queenNo, int[] positions) {
    // have to check safety with previous queens
    for (int i = 0; i < queenNo; i++) {
      int prevRow = positions[i];
      boolean sameRow = (rowToPutQueen == prevRow); //check safety on same row
      boolean diagoanllyUp = rowToPutQueen == prevRow - (queenNo - i); // check safety daigonally
      boolean diagoanllyDown = rowToPutQueen == prevRow + (queenNo - i); // check safety daigonally
      if (sameRow || diagoanllyUp || diagoanllyDown) {
        return false;
      }
    }
    return true;
  }

  /*  [Prob 8.14]
  * Q) Given a boolean expression of 0(false), 1 (true), & (and), | (OR) and ^ (XOR) and a desired a boolean result,
  * give a function to count no of ways of acheiving this result
  * A) The algo is given in as per the CTCI, i couldnt get close so learning from their solution
  * First we ahve to get the total number of possible evaluations for the expression. To break down down this problem
  * we first need to calculate the no of ways in which left can evalaute true & false (leftFalse & leftTrue). Similarly
  * we have to calculate the no of ways in which right can evaluate true & false (rightFalse & rightTrue).
  * With these breakdowns calculated we can get the total no of evaluation possible. Now if the desired result from this
  * expression was false, then we can subtract the evaluations that resulted in true from the total to get the no of false
  * evaluations. and, if the dexsired result was true then we can return the total true evaluations depeneding on the o
  * opretaor.
  * The reason we re multying the result is beacuse each result from the 2 sides can be paired up with each oter to
  * True Evaluations based on operator
  * ^ -- leftFalse*rightTrue + leftTrue*rightFalse (one true other false)
  * | -- leftFalse*rightTrue + leftTrue*rightFalse + leftTrue* RightTrue (one true other false, one fasle other true , both true )
  * & -- leftTrue * roghtTrue (both true)
  * Base case is the anding of 0 or 1 with the expected result
  * exp 0 , result false then return 1 & so on
  * */
  public static int countEval(String exp, boolean result) {
    char c;
    String left, right;
    int totalEval = 0;
    if (exp.length() == 1) {
      if (exp.equals("0") && result == false) {
        return 1;
      } else if (exp.equals("0") && result == true) {
        return 0;
      } else if (exp.equals("1") && result == true) {
        return 1;
      } else if (exp.equals("1") && result == false) {
        return 0;
      }
    }
    for (int i = 1; i < exp.length(); i = i + 2) {
      c = exp.charAt(i);
      left = exp.substring(0, i);
      right = exp.substring(i + 1, exp.length());
      int leftTrue = countEval(left, true);
      int leftFalse = countEval(left, false);
      int rightTrue = countEval(right, true);
      int rightFalse = countEval(right, false);
      int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
      int totalTrue = 0;
      if (c == '^') {
        // one false & one true
        totalTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
      } else if (c == '&') {
        // both true
        totalTrue = leftTrue * rightTrue;
      } else if (c == '|') {
        // both true or any one true
        totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
      }

      totalEval += result == true ? totalTrue : total - totalTrue;
    }
    return totalEval;
  }

  /* [Prob 8.14]
  * Q) Given a boolean expression of 0(false), 1 (true), & (and), | (OR) and ^ (XOR) and a desired a boolean result,
  * give a function to count no of ways of acheiving this result
  *  A)
   *  */
  public static int countEvalOptimized(String exp, boolean result, HashMap<String, Integer> cache) {
    if (exp.length() == 1) {
      if (exp.equals("0") && result == false) {
        return 1;
      } else if (exp.equals("0") && result == true) {
        return 0;
      } else if (exp.equals("1") && result == false) {
        return 0;
      } else if (exp.equals("1") && result == true) {
        return 1;
      }
    }
    if (cache.containsKey(exp)) {
      return cache.get(exp);
    }

    char c;
    String left, right;
    int leftTrue, leftFalse, rightTrue, rightFalse, total, totalTrue;
    leftTrue = leftFalse = rightTrue = rightFalse = total = totalTrue = 0;

    for (int i = 1; i < exp.length(); i = i + 2) {
      c = exp.charAt(i);
      if (c == '|' || c == '^' || c == '&') {
        left = exp.substring(0, i);
        right = exp.substring(i + 1, exp.length());
        leftTrue = countEvalOptimized(left, true, cache);
        leftFalse = countEvalOptimized(left, false, cache);
        rightTrue = countEvalOptimized(right, true, cache);
        rightFalse = countEvalOptimized(right, false, cache);
        total = (leftTrue + leftFalse) * (rightFalse + rightFalse);

        if (c == '|') {
          totalTrue = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
        }
        if (c == '&') {
          totalTrue = leftTrue * rightTrue;
        }
        if (c == '^') {
          totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
        }
      }
      if (result) {
        cache.put(exp, totalTrue);
      } else {
        cache.put(exp, total - totalTrue);
      }
    }
    return cache.get(exp);
  }


  /* [Prob Printing all combinaions of combined parathesis]
  * */
  public static int combinedParathesieCombinaiton(String exp, boolean result) {
    char c;
    int count = 1;
    String left, right, total;
    ArrayList<String> leftList, rightList;
    for (int i = 1; i < exp.length(); i = i + 2) {
      c = exp.charAt(i);
      left = exp.substring(0, i);
      right = exp.substring(i + 1, exp.length());
      leftList = evalCombination(left);
      rightList = evalCombination(right);
      for (int p = 0; p < leftList.size(); p++) {
        for (int q = 0; q < rightList.size(); q++) {
          total = "(" + leftList.get(p) + ")" + c + "(" + rightList.get(q) + ")";
          System.out.println("#" + count + " Expression : " + total);
          count++;
        }
      }
    }

    return 0;
  }

  private static ArrayList<String> evalCombination(String exp) {
    if (exp.length() == 1) {
      ArrayList<String> last = new ArrayList<>();
      last.add(exp);
      return last;
    }
    char c;
    String left, right, total;
    left = right = total = "";
    ArrayList<String> leftList, rightList, all;
    all = new ArrayList<>();
    for (int i = 1; i < exp.length(); i = i + 2) {
      c = exp.charAt(i);
      if (c == '|' || c == '^' || c == '&') {
        left = exp.substring(0, i);
        leftList = evalCombination(left);

        right = exp.substring(i + 1, exp.length());
        rightList = evalCombination(right);

        for (int p = 0; p < leftList.size(); p++) {
          for (int q = 0; q < rightList.size(); q++) {
            total = "(" + leftList.get(p) + ")" + c + "(" + rightList.get(q) + ")";
            all.add(total);
          }
        }
      }
    }
    return all;
  }

  /*  [Prob] : Finally the haunting LongestCommonSubSequence (length)
  *
  * */
  public static int LongestCommonSubsequence(String a, String b) {
    a = " " + a;
    b = " " + b;
    // create a matrix of row * col as a.lenght * b.length :: a is rows, b is columns
    int[][] matrix = new int[a.length()][b.length()];

    char ac, bc;
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {

        if (i == 0 || j == 0) {
          matrix[i][j] = 0;
          continue;
        }

        ac = a.charAt(i);
        bc = b.charAt(j);

        if (ac == bc) {
          // if both the chars are equal we take the value from diagonal and add 1
          matrix[i][j] = matrix[i - 1][j - 1] + 1;
        } else if (ac != bc) {
          // if chars are not equal, we try to create a longer sequence by choosing one from prev char of any string
          matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
        }
      }
    }

    System.out.print("Longest SubSequence Length : " + matrix[a.length() - 1][b.length() - 1]);
    return matrix[a.length() - 1][b.length() - 1];
  }

  /* [Prob Longest Increasing Subsequence]
  *  The formula is
  *  assign DP[0...n] = 1 for all , each element can result in at least 1 length of long subsequence thats why
  *  if(arr[j] < arr[i])
  *     DP[i] =  MAX of { DP[i], DP[j] + 1}
  * */

  public static int LongestIncreasingSubsequenceLength(int [] arr) {
    if (arr == null || arr.length == 0) return 0;
    int[] DP = new int[arr.length];
    for(int i=0; i<DP.length;i++) DP[i] = 1;
    int longest = 1;
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (arr[j] < arr[i]) {
          DP[i] = Math.max(DP[j] + 1, DP[i]);
          longest = Math.max(longest, DP[i]);
        }
      }
    }
    return longest;
  }

  /*  [Prob]
  *   Q) A robot can take steps of 1 meter 2 meter or 3 meter, Calculate the no of ways the robot can walk n meters
  *   with taking orders in to account.
  * */
  public static int robotNoOfWays(int n) {
    int w1 = 1;
    int w2 = 2;
    int w3 = 4;
    int w = 0;
    if (n == 1) {
      return w1;
    } else if (n == 2) {
      return w2;
    } else if (n == 3) {
      return w3;
    } else if (n > 3) {
      for (int i = 4; i <= n; i++) {
        w = w3 + w2 + w1;
        w1 = w2;
        w2 = w3;
        w3 = w;
      }
    }
    return w;
  }
}