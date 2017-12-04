package darkRealm.Hyper;

import ADT.LinkedList;
import ADT.LLNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jayam on 1/27/2017.
 */
public class LC_Prob_Med {

  /*  [Prob 2] : Add Two Numbers
  * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
  * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  * Output: 7 -> 0 -> 8
  * */
  public static LLNode AddTwoNumbers(LinkedList n1, LinkedList n2) {
    int sum = addTwoNodes(n1.head, n2.head, 1);
    LinkedList resList = new LinkedList();
//    while (sum != 0) {
//      resList.add(sum % 10);
//      sum = sum / 10;
//    }

    LLNode trav = null;
    LLNode head = null;
    while (sum != 0) {

      if (head == null) {
        head = new LLNode(sum % 10);
        trav = head;
      } else {
        trav.next = new LLNode(sum % 10);
        trav = trav.next;
      }

      sum = sum / 10;
    }
//    return resList;
    return head;
  }

  private static int addTwoNodes(LLNode a, LLNode b, int powerTen) {
    if (a == null && b == null) {
      return 0;
    }

    int first = a == null ? 0 : a.data;
    int second = b == null ? 0 : b.data;

    int prev = addTwoNodes(a.next, b.next, powerTen * 10);
    first *= powerTen;
    second *= powerTen;
    int sum = prev + first + second;
    return sum;
  }

  /*  [Prob 3] : Longest Substring wihtout repeating chars
  * Given a string, find the length of the longest substring without repeating characters.
  * Examples:
  * Given "abcabcbb", the answer is "abc", which the length is 3.
  * Given "bbbbb", the answer is "b", with the length of 1.
  * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
  * "pwke" is a subsequence and not a substring.
  * */
  public static int lengthOfLongestSubstring(String s) {
    int len;
    int maxLen;
    len = maxLen = 0;
    StringBuilder part = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      String ch = s.charAt(i) + "";
      int lastFound = part.lastIndexOf(s.charAt(i) + "");
      if (lastFound > -1) {
        String newPart = part.substring(lastFound + 1);
        part = new StringBuilder(newPart);
        len = part.length();
      }
      part.append(ch);
      len++;
      if (len > maxLen) {
        maxLen = len;
      }
    }
    return maxLen;
  }

  /*  [Prob 5] Longest Palindromic Substring
  *   Q) Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
  *   Example:
  *   Input: "babad"
  *   Output: "bab"
  *   Note: "aba" is also a valid answer.
  *   Example:
  *   Input: "cbbd"
  *   Output: "bb"
  *
  * */
  static int start, maxLen;

  public static String longestPalindromicSubString(String s) {
    if (s == null || s.length() < 2) return s;
    for (int i = 0; i < s.length() - 1; i++) {
      expand(s, i, i);  // odd len palidrome
      expand(s, i, i + 1); // even len palidrome
    }
    return s.substring(start, start + maxLen);
  }

  private static void expand(String str, int left, int right) {
    while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
      left--;
      right++;
    }
    if (maxLen < right - left - 1) {
      maxLen = right - left - 1;
      start = left;
    }
  }


  /*  [Prob 7]
  * Reverse digits of an integer.
  * Example1: x = 123, return 321
  * Example2: x = -123, return -321
  * */
  public static int reverseInteger(int x) {
    int result = 0;
    int t = Math.abs(x);
    while (t != 0) {
      if ((result * 10) / 10 != result) {
        return 0;
      }
      result *= 10;
      if ((result + t % 10) < 0) {
        return 0;
      }
      result += t % 10;
      t /= 10;
    }

    return x < 0 ? result * -1 : result;
  }

  /*  [Prob 8]   String to Integer
  * Implement stringToInteger to convert a string to an integer.
  * */
  public static int stringToInteger(String str) {
    if (str == null || str.length() == 0) return 0;
    int sign = 1;
    int index = 0;
    int result = 0;
    while (str.charAt(index) == ' ' && index < str.length())
      index++;
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index) == '-' ? -1 : 1;
      index++;
    }

    int digit = 0;
    while (index < str.length()) {
      digit = str.charAt(index) - '0';
      if (digit < 0 || digit > 9) break;

      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit))
        return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      result = result * 10 + digit;
      index++;
    }
    return result * sign;
  }

  /*  [Prob 151]   Reverse Words in a String
  * Given an input string, reverse the string word by word.
  * For example,
  * Given s = "the sky is blue",
  * return "blue is sky the".
  * */
  public static String reverseWords(String str) {
    StringBuilder res = new StringBuilder();
    for (int start = str.length() - 1; start >= 0; start--) {
      if (str.charAt(start) == ' ') continue;
      int end = start;
      while (start >= 0 && str.charAt(start) != ' ') start--;
      res.append(str.substring(start + 1, end + 1)).append(" ");
    }
    return res.toString().trim();
  }

  /*  130. Surrounded Regions
  * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
  * A region is captured by flipping all 'O's into 'X's in that surrounded region.
  * For example,
  * X X X X
  * X O O X
  * X X O X
  * X O X X
  * After running your function, the board should be:
  * X X X X
  * X X X X
  * X X X X
  * X O X X
  * */
  public static void surroundedRegions(char[][] board) {
    if (board.length > 0) {
      Status[][] statuses = new Status[board.length][board[0].length];
      for (int i = 0; i < statuses.length; i++) {
        for (int j = 0; j < statuses[0].length; j++) {
          statuses[i][j] = Status.NotProcessed;
        }
      }
      java.util.LinkedList<Pair> queue = new java.util.LinkedList();
      java.util.LinkedList<Pair> processed = new java.util.LinkedList();
      // we will begin from 1,1 cell because the ones which are on the boundary even of they are O, but they cannot be
      // completely surrounded by X thats why.

      boolean discard = false;
      for (int row = 1; row < board.length; row++) {
        for (int col = 1; col < board[0].length; col++) {
          if (board[row][col] == 'O' && statuses[row][col] == Status.NotProcessed) {
            queue.push(new Pair(row, col));
            statuses[row][col] = Status.UnderProcessing;
            discard = false;
          }
          while (!queue.isEmpty()) {
            Pair poped = queue.poll();
            int popR = poped.a;
            int popC = poped.b;
            //Top
            if (popR - 1 > -1 && board[popR - 1][popC] == 'O' && statuses[popR - 1][popC] == Status.NotProcessed) {
              queue.push(new Pair(popR - 1, popC));
              statuses[popR - 1][popC] = Status.UnderProcessing;
            }
            //Left
            if (popC - 1 > -1 && board[popR][popC - 1] == 'O' && statuses[popR][popC - 1] == Status.NotProcessed) {
              queue.push(new Pair(popR, popC - 1));
              statuses[popR][popC - 1] = Status.UnderProcessing;
            }
            //Bottom
            if (popR + 1 < board.length && board[popR + 1][popC] == 'O' && statuses[popR + 1][popC] == Status.NotProcessed) {
              queue.push(new Pair(popR + 1, popC));
              statuses[popR + 1][popC] = Status.UnderProcessing;
            }
            //Right
            if (popC + 1 < board[0].length && board[popR][popC + 1] == 'O' && statuses[popR][popC + 1] == Status.NotProcessed) {
              queue.push(new Pair(popR, popC + 1));
              statuses[popR][popC + 1] = Status.UnderProcessing;
            }

            processed.push(poped);
            if ((poped.a == 0 || poped.a == board.length - 1) ||
                (poped.b == 0 || poped.b == board[0].length - 1)) {
              discard = true;
            }
          }
          // mark all processed by X as they are not ending on boundary & can be captured as a region
          while (!processed.isEmpty() && !discard) {
            Pair poped = processed.poll();
            board[poped.a][poped.b] = 'X';
            statuses[poped.a][poped.b] = Status.Processed;
          }
          while (!processed.isEmpty() && discard) {
            Pair prevOnes = processed.poll();
            statuses[prevOnes.a][prevOnes.b] = Status.DontProcessAgain;
          }
        }
      }

      for (int i = 0; i < board.length; i++) {
        System.out.println(Arrays.toString(board[i]));
      }
    }
  }

  enum Status {
    NotProcessed,
    UnderProcessing,
    Processed,
    DontProcessAgain
  }

  static class Pair {
    int a;
    int b;

    Pair(int x, int y) {
      a = x;
      b = y;
    }
  }


  /*  [Prob 15] 3Sum
   *  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
   *  in the array which gives the sum of zero.
   *  Note: The solution set must not contain duplicate triplets.
   *  For example, given array S = [-1, 0, 1, 2, -1, -4],
   *  A solution set is:
   *  [
   *  [-1, 0, 1],
   *  [-1, -1, 2]
   *  ]
   *  */
  public static List<List<Integer>> threeSum(int[] arr) {
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(arr); // we go till -2 beacuse those triplets will be counted in inside loop

    // we also dont want to run loop for duplicate elements as duplicates are not allowed in result
    // as we have to atleast begin from array we have to pass for index =0 thats why first part of condition
    for (int i = 0; i < arr.length - 2; i++) {
      if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
        int low = i + 1;
        int high = arr.length - 1;
        while (low < high) {
          int a = arr[low];
          int b = arr[high];
          int sum = 0 - (arr[i]);
          if (a + b < sum) {
            low++;
          }
          if (a + b > sum) {
            high--;
          }
          if (a + b == sum) {
            //  a + b + c == 0
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(arr[i]);
            results.add(list);
            // skipping all the equal numbers in order to get rid of duplicate results
            while (low < high && arr[low] == arr[low + 1]) low++;
            while (low < high && arr[high - 1] == arr[high]) high--;
            low++;
            high--;
          }
        }
      }
    }
    return results;
  }

  /*  [Prob 338] Counting Bits
  * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
  * in their binary representation and return them as an array.
  * Example:For num = 5 you should return [0,1,1,2,1,2].
  * Sol : There is a recurence relation of adding the previously counted 1 bits
  * res[i] = res[i / 2] + i % 2;
  * */
  public static int[] countingBits(int n) {
    if (n >= 0) {
      int[] res = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        res[i] = res[i / 2] + i % 2;
      }
      return res;
    }
    return new int[]{0};
  }

  /*  [Prob 457] Circular Array Loop
  * */
  public static boolean isCircularArrayLoopZZ(int[] arr) {
    int i = 0;
    boolean[] visited = new boolean[arr.length];
    int size = arr.length;
    List<Integer> nos = new ArrayList<>();
    for (int j = 0; j < arr.length; j++) {
      nos.add(j);
    }
    while (nos.size() > 0) {
      if (visited[i] == true) {
        return true;
      }
      visited[i] = true;
      nos.remove(new Integer(i));
      if (arr[i] > 0) {
        i = (i + arr[i]) % size;
      } else {
        i = i + arr[i];
        if (i < 0) {
          i = arr.length + i;
        }
      }
    }
    return false;
  }

  public static boolean isCircularArrayLoop(int[] arr) {
    if (arr.length > 1) {
      int val = 0;
      int i = 0;
      int size = arr.length;
      while (true) {
        if (i >= size) {
          break;
        }
        if (arr[i] == 0) {
          return true;
        }
        val = arr[i];
        arr[i] = 0;
        if (arr[i] > 0) {
          i = (i + val) % size;
        } else {
          i = i + val;
          if (i < 0) {
            i = arr.length + i;
          }
        }
      }
    }
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] != 0) {
        return true;
      }
    }
    return false;
  }

  /* [442] Find All Duplicates in an Array
  * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
  * Find all the elements that appear twice in this array.
  * Could you do it without extra space and in O(n) runtime?
  * Reuse the same array to mark that a number has appeared once by mulitplying it with -1. And when we encounter a -ve
  * no we know that its index is duplicate.
  * */
  public static List<Integer> findDuplicates(int[] arr) {
    List<Integer> dups = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[Math.abs(arr[i]) - 1] < 0) {
        dups.add(Math.abs(arr[i]));
        continue;
      }
      arr[Math.abs(arr[i]) - 1] = -1 * arr[Math.abs(arr[i]) - 1];
    }
    return dups;
  }

  /* [448] Find All Numbers Disappeared in an Array
  * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
  * Find all the elements of [1, n] inclusive that do not appear in this array.
  * */
  public static List<Integer> disappearedNumbers(int[] arr) {
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      index = Math.abs(arr[i]) - 1;
      if (arr[index] > 0) {
        arr[index] = -1 * arr[index];
      }
    }
    List<Integer> missingNos = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        missingNos.add(i + 1);
      }
    }
    return missingNos;
  }

  /* [41] First Missing Positive
  * Given an unsorted integer array, find the first missing positive integer.
  * For example,
  * Given [1,2,0] return 3,
  * and [3,4,-1,1] return 2.
  * Your algorithm should run in O(n) time and uses constant space*/
  public static int firstMissingPositive(int[] arr) {
    if (arr.length == 0) {
      return 1;
    }
    int i = 0;
    while (i < arr.length) {
      if (arr[i] == i + 1 || arr[i] <= 0 || arr[i] > arr.length) {
        i++;
      } else if (arr[arr[i] - 1] != arr[i]) {
        int temp = arr[i];
        arr[i] = arr[arr[i] - 1];
        arr[temp - 1] = temp;
      } else i++;
    }
    for (i = 1; i <= arr.length; i++) {
      if (arr[i - 1] != i) {
        return i;
      }
    }
    return i;
  }

  /*  [287] Find the Duplicate Number
  * Given an array numbers containing n + 1 integers where each integer is between 1 and n (inclusive),
  * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
  * find the duplicate one.
  * Note:
  * You must not modify the array (assume the array is read only).
  * You must use only constant, O(1) extra space.
  * Your runtime complexity should be less than O(n2).
  * There is only one duplicate number in the array, but it could be repeated more than once.
  * */
  public static int duplicateNumber(int[] arr) {
    int slowPtr = 0;
    int fastPtr = 0;
    while (true) {
      if (fastPtr >= arr.length || slowPtr >= arr.length) {
        return 0;
      }
      slowPtr = arr[slowPtr];
      fastPtr = arr[arr[fastPtr]];
      if (slowPtr == fastPtr) {
        break;
      }
    }
    // calculate the length of the loop
    int trav = arr[slowPtr];
    int loopSize = 1;
    while (arr[trav] != arr[fastPtr]) {
      trav = arr[trav];
      loopSize++;
    }

    int aheadPtr = arr[0];
    for (int i = 1; i < loopSize; i++) {
      aheadPtr = arr[aheadPtr];
    }
    int behindPtr = 0;
    while (aheadPtr != behindPtr) {
      aheadPtr = arr[aheadPtr];
      behindPtr = arr[behindPtr];
    }
    return behindPtr;
  }

  /*
  * */
  public static int singleNumber(int[] arr) {
    int xorResult = 0;
    if (arr.length > 0) {
      xorResult = arr[0];
      for (int i = 1; i < arr.length; i++) {
        xorResult ^= arr[i];
      }
    }
    return xorResult;
  }

  /*  [20] Valid Parentheses
  * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
  * */
  public static boolean isValidParanthesis(String str) {
    Stack<Character> stack = new Stack<>();
    char c;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else {
        if (stack.isEmpty() || stack.pop() != c)
          return false;
      }
    }
    return stack.isEmpty();
  }

  /*  [238] Product of Array Except Self
  *Given an array of n integers where n > 1, numbers, return an array output such that output[i] is equal to the product
  * of all the elements of numbers except numbers[i].
  * Solve it without division and in O(n).
  * For example, given [1,2,3,4], return [24,12,8,6].
  * */
  public static int[] productExceptSelf(int[] arr) {
    int[] res = new int[arr.length];
    int temp = 1;
    // we have to create a shifted aray of products thats why we initialize with 1 and not arr[0], this will give us all
    // the nos product except the last number, now we traverse this product the array but from right, and multiply with
    // the number at same pos in res array.
    for (int i = 0; i < arr.length; i++) {
      res[i] = temp;
      temp *= arr[i];
    }
    int right = 1;
    for (int j = arr.length - 1; j >= 0; j--) {
      res[j] = res[j] * right;
      right = right * arr[j];
    }
    return res;
  }


  public static int threeSumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    int minSum = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int low = i + 1;
      int high = arr.length - 1;
      int a = arr[i];

      while (low < high) {
        int b = arr[low];
        int c = arr[high];
        int sum = a + b + c;
        int diff = Math.abs(target - (sum));
        if (diff < minDiff) {
          minDiff = diff;
          minSum = sum;
          System.out.println("~DL~ a: " + a + " b: " + b + " c: " + c + " mindiff : " + minDiff);
          if (minDiff == 0) {
            return minSum;
          }
        }
        if (sum < target) {
          low++;
        }
        if (sum > target) {
          high--;
        }
      }
    }
    return minSum;
  }


  /*  [Prob 121] Best Time to Buy and Sell Stock
    * Say you have an array for which the ith element is the price of a given stock on day i.
    *  You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
    *  However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    *  -2, 2, 4, 1, 2, 3, 5, 6  MaxP = 11 -2 to 4 + 1 to 6
    *  */
  public static int maxProfitII(int[] prices) {
    if (prices == null || prices.length < 2) return 0;
    int maxP = 0;
    // this is the explanation
    // a<= b <= c <= d;
    // d - a = (b - a) + (c - b) + (d - c)
    // d - a = b -a + c -b + d -c
    // d - a = d - a
    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1])
        maxP += prices[i] - prices[i - 1];
    return maxP;
  }



  public static int maxProfitIII(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int buy1, sell1, buy2, sell2;
    buy1 = buy2 = Integer.MIN_VALUE;
    sell1 = sell2 = 0;
    for (int i = 0; i < prices.length; i++) {
      sell2 = Math.max(sell2, buy2 + prices[i]);
      buy2 = Math.max(buy2, sell1 - prices[i]);
      sell1 = Math.max(sell1, buy1 + prices[i]);
      buy1 = Math.max(buy1, -prices[i]);
    }
    return sell2;
  }

  public static int maxProfitFinal(int[] prices, int k) {
    if (prices == null || prices.length == 0) return 0;
    int[][] DP = new int[k + 1][prices.length];
    if (k >= prices.length / 2) return quickProfit(prices);
    int maxDiff = 0;
    /*  DP Rule is
    *   T[i,j] = Max of{ T[i, j-1] --> not transacting
    *                   OR
    *                   Price[j] + maxDiff
    *                 maxDiff = max(maxDiff, T[i-1][j] - price[j])
    * */
    for (int i = 1; i < DP.length; i++) {
      maxDiff = -prices[0];
      for (int j = 1; j < DP[0].length; j++) {
        DP[i][j] = Math.max(DP[i][j - 1], prices[j] + maxDiff);
        maxDiff = Math.max(maxDiff, DP[i - 1][j] - prices[j]);
      }
    }
    return DP[k][prices.length - 1];
  }

  private static int quickProfit(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1])
        max += prices[i] - prices[i - 1];
    return max;
  }
}