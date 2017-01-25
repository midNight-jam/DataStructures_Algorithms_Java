package com.darkRealm.Moderate;

import com.darkRealm.Stacks_and_queues.MyQueue;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jayam on 1/23/2017.
 */
public class Moderate {
  /*  [Prob 16.1]
  *   Q) Number Swapper : swap 2 nos without using extra variable & by using  XOR
  *   */
  public static void numberSwapper(int a, int b) {
    System.out.println("Before  a : " + a + " b : " + b);
    a = a ^ b;
    b = b ^ a;
    a = a ^ b;
    System.out.println("After a : " + a + " b : " + b);
  }

  /*  [Prob 16.2]
  *   Q) Word Frequncies : deisgn a method to find the frequency of occurencses of any given word in a book. What if we
  *   were running this algorithm multiple times.
  *   A)
  * */

  public static int wordFrequency(String[] book, String word) {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < book.length; i++) {
      if (map.containsKey(book[i])) {
        map.put(book[i], map.get(book[i]) + 1);
      } else {
        map.put(book[i], 1);
      }
    }
    return map.containsKey(word) ? map.get(word) : 0;
  }

  /* [Prob 16.4]
  Q) An algo to check for a given game of N*N size, has any one won it
  A) Would first check if any one column is completely filled, then for row. and finally for two diagonals
  * */

  public static boolean ticTacWin(char[][] game, int n) {
    //from top left
    char c = 'z';

    //check for whole row
    for (int r = 0; r < n; r++) {
      c = game[r][0];
      boolean rowComplete = true;
      for (int i = 0; i < n; i++) {
        rowComplete = rowComplete & (c == game[r][i]);
        if (!rowComplete) {
          break;
        }
      }
      if (rowComplete) {
        System.out.println("Winner " + c + " row complete");
        return true;
      }
    }

    //check for all 3 columns
    for (int j = 0; j < n; j++) {
      c = game[0][j];
      boolean colComplete = true;
      for (int i = 0; i < n; i++) {
        colComplete = colComplete & (c == game[i][j]);
        if (!colComplete) {
          break;
        }
      }
      if (colComplete) {
        System.out.println("Winner " + c + " col complete ");
        return true;
      }
    }

    // check for topleft to bottomright diagonal
    boolean diagComplete = true;
    c = game[0][0];
    for (int i = 0; i < n; i++) {
      diagComplete = diagComplete & (c == game[i][i]);
      if (!diagComplete) {
        break;
      }
    }
    if (diagComplete) {
      System.out.println("Winner " + c + " daig complete");
      return true;
    }

    // check for bottom left to top right  diagonal
    c = game[n - 1][0];
    diagComplete = true;
    for (int i = n - 1; i >= 0; i--) {
      diagComplete = diagComplete & (c == game[i][i]);
      if (!diagComplete) {
        break;
      }
    }
    if (diagComplete) {
      System.out.println("Winner " + c + " daig complete");
      return true;
    }
    return false;
  }

  /* [Prob 16.5]
  *   Q) Write an lgo that calculates the no of trailing zeros in a factorial
  *   A) there are 2 , the first one is my algo
  *     The no of zeros is equal to the power of 5 as a prime factor of that number
  *     for each n decremetn it till 0, & check if the no is divisible by 5, if yes get the powers of 5 in that number
  * */
  public static int factorialZeros(int n) {
    int total5 = 0;
    while (n != 0) {
      if (n % 5 == 0) {
        //check if a power of 5
        int temp = n;
        while (temp % 5 == 0 && temp >= 5) {
          total5++;
          temp = temp / 5;
        }
      }
      n--;
    }
    return total5;
  }

  /* [Prob 16.5]*/
  public static int factorialZerosLeaner(int n) {
    int total5 = 0;
    for (int i = 5; n / i > 0; i = i * 5) {
      if (n % i == 0) {
        total5 += n / i;
      }
    }
    return total5;
  }

  /*  [Prob 16.6]
  * Q) Given 2 arrays, compute the pair of values (one from each array) with the smallest nonnegative difference.
  *   EG: [1,3,15,11,2] & [23,127,235,19,8] . Output should be (11,8)
  * A) My approach : will sort both the arrays & will do a merge traverse and while merging would do a diff & keep track of
   * min diff in this way. when found min diff will update the elements from both arrays in result.
  * */
  public static int[] smallestDifference(int[] arr, int[] brr) {
    Arrays.sort(arr);
    Arrays.sort(brr);
    int ai, bi;
    ai = bi = 0;
    int minDiff = Integer.MAX_VALUE;
    int diff = 0;
    int[] res = new int[2];
    while (ai < arr.length && bi < brr.length) {
      diff = Math.abs(brr[bi] - arr[ai]);
      if (diff < minDiff) {
        minDiff = diff;
        res[0] = arr[ai];
        res[1] = brr[bi];
      }
      if (arr[ai] <= brr[bi]) {
        ai++;
      } else {
        bi++;
      }
    }
    return res;
  }

  /* [Prob 16.7]
  *   Q) Given two nos find the maximum among them, constraint is you cannot use ANY comparision operator
  *   A) Sign Bit will be useful in this case. We take diff = a - b, if the sign bit of diff is 0 means a is bigger (beacuse)
  *   the result was +ve),  if sign bit if diff is 1 means b is bigger (beause the result was negative)
  *   TODO : have to handle "overflow case"
  * */
  public static int numberMax(int a, int b) {
    int diff = a - b;
    int signBit = (diff >>> 31) & 1;
    int flipSignBit = ~(signBit) & 1;
    int max = a * flipSignBit + b * signBit;
    return max;
  }

  /*  [Prob 16.8]
  *   Q) Eglish Int : Given any integer, print an English phase that describes the integer.
  *     1234  = One Thousand Two Hundred Thirty Four
  *   A) Will read the numbers in a group of three, convert this group to english & now add thosand, million, billion to it.
  * */
  public static String englishInt(int n) {
    if (n == 0) {
      return "Zero";
    }
    String[] oneSeries = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[][] dict = new String[][]{
        {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"},
        {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"},
        {"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred",
            "Eight Hundred", "Nine Hundred"}
    };

    String[] more3 = new String[]{"Thousand", "Million", "Billion"};

    String res = "";

    int number = Math.abs(n);
    int last3Digits;
    int i = -1;
    int colIndex;
    int rowIndex;
    while (number > 0) {
      last3Digits = number % 1000;
      colIndex = 0;
      rowIndex = -1;
      if (last3Digits % 100 <= 19 && last3Digits % 100 >= 11) {
        res = oneSeries[last3Digits % 10] + res;
        rowIndex = 1;
        last3Digits = last3Digits / 100;
      }
      while (last3Digits > 0) {
        colIndex = last3Digits % 10;
        rowIndex++;
        res = dict[rowIndex][colIndex] + " " + res;
        last3Digits = last3Digits / 10;
      }
      i++;
      number = number / 1000;
      if (number > 0) {
        res = more3[i] + " " + res;
      }
    }
    return n < 0 ? "Minus " + res : res;
  }


    /*[Prob 16.9]
   * Q) write methods to implement multiply, substract & divide operations for integers. Using only add operator
   */

  /*  [prob 16.9] Substract
  * */
  public static int substractNumbers(int a, int b) {
    int diff = 0;
    int big = Math.max(a, b);
    int small = Math.min(a, b);

    for (int i = small; i < big; i++) {
      diff++;
    }
    return getSignedResult(a, b, diff);
  }

  /*  [prob 16.9] Multiply
  * */
  public static int multiplyNumbers(int a, int b) {
    int no = Math.abs(a);
    int iterations = Math.abs(b);
    int product = 0;
    for (int i = 0; i < iterations; i++) {
      product += no;
    }
    return getSignedResult(a, b, product);
  }

  private static int getSignedResult(int a, int b, int result) {
    int signA = ((a >>> 31) & 1);
    int signB = ((b >>> 31) & 1);
    int resultSign = (signA ^ signB);
    return resultSign == 0 ? result : result * -1;
  }

  /*[Prob 16.9] Divide*/
  public static int divideNumbers(int a, int b) {
    int divRes = 0;
    int dividend = 0;
    int ta = Math.abs(a);
    int tb = Math.abs(b);
    while (dividend < ta) {
      dividend += tb;
      divRes++;
    }
    return getSignedResult(a, b, divRes - 1);
  }

  /*  [prob 16.19]
  *   Q) Pond Sizes :
  * */

  public static Integer[] pondSizes(int[][] world, int water) {
    boolean[][] visited = new boolean[world.length][world[0].length];
    MyQueue<AbstractMap.SimpleEntry<Integer, Integer>> que = new MyQueue<>();
    int rows = world.length - 1;
    int cols = world[0].length - 1;
    ArrayList<Integer> pondSizes = new ArrayList<>();
    for (int r = 0; r <= rows; r++) {
      for (int c = 0; c <= cols; c++) {
        if (world[r][c] == 0 && visited[r][c] == false) {
          AbstractMap.SimpleEntry cords = new AbstractMap.SimpleEntry(r, c);
          que.enqueue(cords);
          int pondSize = 0;
          int i, j;
          while (!que.isEmpty()) {
            AbstractMap.SimpleEntry pop = que.deque();
            if (!visited[(int) pop.getKey()][(int) pop.getValue()]) {
              pondSize++;
              i = (int) pop.getKey();
              j = (int) pop.getValue();
              visited[i][j] = true;

              //top
              if (i - 1 >= 0 && world[i - 1][j] == water && visited[i - 1][j] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
              }
              //top right
              if (i - 1 >= 0 && j + 1 <= cols && world[i - 1][j + 1] == water && visited[i - 1][j + 1] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i - 1, j + 1));
              }
              //right
              if (j + 1 <= cols && world[i][j + 1] == water && visited[i][j + 1] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i, j + 1));
              }
              //bottom right
              if (i + 1 <= rows && j + 1 <= cols && world[i + 1][j + 1] == water && visited[i + 1][j + 1] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
              }
              //bottom
              if (i + 1 <= rows && world[i + 1][j] == water && visited[i + 1][j] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i + 1, j));
              }
              //bottom left
              if (i + 1 <= rows && j - 1 >= 0 && world[i + 1][j - 1] == water && visited[i + 1][j - 1] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i + 1, j - 1));
              }
              //left
              if (j - 1 >= 0 && world[i][j - 1] == water && visited[i][j - 1] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i, j - 1));
              }
              //top left
              if (i - 1 >= 0 && j - 1 >= 0 && world[i - 1][j - 1] == water && visited[i - 1][j - 1] == false) {
                que.enqueue(new AbstractMap.SimpleEntry<Integer, Integer>(i - 1, j - 1));
              }
            }
          }
          pondSizes.add(pondSize);
        }
      }
    }
    Integer[] allPonds = new Integer[pondSizes.size()];
    pondSizes.toArray(allPonds);
    return allPonds;
  }
}