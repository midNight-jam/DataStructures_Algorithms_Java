package darkRealm.LeetCode;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Node;

import java.util.*;

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
  public static Node AddTwoNumbers(LinkedList n1, LinkedList n2) {
    int sum = addTwoNodes(n1.head, n2.head, 1);
    LinkedList resList = new LinkedList();
//    while (sum != 0) {
//      resList.add(sum % 10);
//      sum = sum / 10;
//    }

    Node trav = null;
    Node head = null;
    while (sum != 0) {

      if (head == null) {
        head = new Node(sum % 10);
        trav = head;
      } else {
        trav.next = new Node(sum % 10);
        trav = trav.next;
      }

      sum = sum / 10;
    }
//    return resList;
    return head;
  }

  private static int addTwoNodes(Node a, Node b, int powerTen) {
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
  * *********NOT A GOOD SOLUTION, DONOT PAY ATTENTION, ITS A WORK IN PROGRESS*********
  * */
  public static String longestPalindrome(String s) {
    int beg = 0;
    int end = s.length() - 1;
    while (beg < end) {
      if (s.charAt(beg) != s.charAt(end)) {
        break;
      }
      beg++;
      end--;
    }
    if (beg >= end) {
      return s;
    }

    String maxPalindromeString = "";
    int maxPalindromeLength = 0;
    int palinStart, palinEnd;
    palinStart = palinEnd = 0;
    int len = 0;
    char leftChar, rightChar;
    char[] arr = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      // considering for odd length palindrome
      int left = i == 0 ? i : i - 1;
      int right = arr[i] == arr[left] ? i : Integer.MAX_VALUE;
      len = 0;
      while (left >= 0 && right < s.length()) {
        leftChar = arr[left];
        rightChar = arr[right];

        if (leftChar == rightChar) {
          len = right - left;
          if (len > maxPalindromeLength) {
            maxPalindromeLength = len;
            palinStart = left;
            palinEnd = right;
          }
        } else {
          break;
        }
        left--;
        right++;
      }

      left = i == 0 ? i : i - 1;
      right = i < arr.length - 1 ? arr[i + 1] == arr[left] ? i + 1 : Integer.MAX_VALUE : i;
      len = 0;
      while (left >= 0 && right < s.length()) {
        leftChar = arr[left];
        rightChar = arr[right];

        if (leftChar == rightChar) {
          len = right - left;
          if (len > maxPalindromeLength) {
            maxPalindromeLength = len;
            palinStart = left;
            palinEnd = right;
          }
        } else {
          break;
        }
        left--;
        right++;
      }
    }
    maxPalindromeString = s.substring(palinStart, palinEnd + 1);
    return maxPalindromeString;
  }

  /*  [Prob 6] ZigZag Conversion
  * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
  * (you may want to display this pattern in a fixed font for better legibility)
  * P   A   H   N
  * A P L S I I G
  * Y   I   R
  * And then read line by line: "PAHNAPLSIIGYIR"
  * Write the code that will take a string and make this conversion given a number of rows:
  * string convert(string text, int nRows);
  * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
  * */
  public static String zigZagConversion(String str, int numRows) {
    StringBuilder[] zigZag = new StringBuilder[numRows];
    for (int i = 0; i < zigZag.length; i++) {
      zigZag[i] = new StringBuilder();
    }
    char c;
    int up = 0;
    int down = -1;
    boolean upwards = true;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (upwards && up < zigZag.length) {
        zigZag[up].append(c);
        up++;
      } else if (down > 0 && !upwards) {
        zigZag[down].append(c);
        down--;
      }
      if (up == numRows && upwards) {
        upwards = !upwards;
        down = zigZag.length - 2;
        if (down <= 0) {
          down = 0;
          upwards = !upwards;
          up = 0;
        }
      } else if (down == 0 && !upwards) {
        upwards = !upwards;
        up = 0;
      }
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < zigZag.length; i++) {
      res.append(zigZag[i]);
    }

    return res.toString();
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
  * Implement atoi to convert a string to an integer.
  * */
  public static int stringToInteger(String str) {
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    int minus = 1;
    int endIndex = 0;
    if (str.charAt(0) == '-') {
      minus = -1;
      endIndex = 1;
    } else if (str.charAt(0) == '+') {
      minus = 1;
      endIndex = 1;
    }
    int number = 0;
    int last;
    int powTen = 1;
    for (int i = str.length() - 1; i >= endIndex; i--) {
      last = getInt(str.charAt(i));
      if (last == Integer.MIN_VALUE) {
        number = 0;
        powTen = 1;
        continue;
      }
      if ((last * 10) / 10 != last) {
        return 0;
      }
      last = last * powTen;
      if (number + last < 0) {
        int res = number + last;
        return res == Integer.MIN_VALUE ? Integer.MIN_VALUE : 0;
      }
      number += last;
      powTen = powTen * 10;
    }
    return number * minus;
  }

  private static int getInt(char c) {
    switch (c) {
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
    }
    return Integer.MIN_VALUE;
  }

  /*  [Prob 151]   Reverse Words in a String
  * Given an input string, reverse the string word by word.
  * For example,
  * Given s = "the sky is blue",
  * return "blue is sky the".
  * */
  public static String reverseWords(String sentence) {
    sentence = sentence.trim();
    StringBuilder reverse = new StringBuilder();
    int wordBeg, wordEnd;
    wordBeg = wordEnd = 0;
    for (int i = sentence.length() - 1; i > -1; i--) {
      while (sentence.charAt(i) == ' ') {
        i--;
      }
      if (sentence.charAt(i) != ' ') {
        wordBeg = i;
      }
      while (i >= 0 && sentence.charAt(i) != ' ') {
        i--;
        wordEnd = i;
      }
      if (wordEnd < wordBeg) {
        reverse.append(sentence.substring(wordEnd + 1, wordBeg + 1));
        if (i != -1) {
          reverse.append(" ");
        }
      }
    }
    return reverse.toString();
  }

  /*  [Prob 165]  Compare Version Numbers
  * Compare two version numbers version1 and version2.
  * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
  * You may assume that the version strings are non-empty and contain only digits and the . character.
  * The . character does not represent a decimal point and is used to separate number sequences.
  * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
  * revision of the second first-level revision.
  * Here is an example of version numbers ordering:
  * 0.1 < 1.1 < 1.2 < 13.37
  *  * *********NOT A GOOD SOLUTION, DONOT PAY ATTENTION, ITS A WORK IN PROGRESS*********
  * */
  public static int compareVersion(String version1, String version2) {
    version1 = version1.trim();
    version2 = version2.trim();

    int maxLen = Math.max(version1.length(), version2.length());
    char v1, v2;
    v1 = v2 = '\u0000';
    int diff = 0;
    for (int i = 0; i < maxLen; i++) {
      if (i < version1.length()) {
        v1 = version1.charAt(i);
        if (v1 == ' ') {
          return diff;
        }
      }
      if (i >= version1.length()) {
        return -1;
      }
      if (i < version2.length()) {
        v2 = version2.charAt(i);
        if (v2 == ' ') {
          return diff;
        }
      }
      if (i >= version2.length()) {
        return 1;
      }
      if (v1 > v2) {
        return 1;
      } else if (v1 < v2) {
        return -1;
      } else {
        diff = 0;
      }
      if ((v1 == '.' || v2 == '.') & v1 != v2) {
        return diff;
      }
    }
    return diff;
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
  * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
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

  /* [438] Find All Anagrams in a String
  * Q) Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
  * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger
  * than 20,100.
  * */
  public static List<Integer> findAnagrams(String str, String anagram) {
    List<Integer> matchIndexes = new ArrayList<>();
    if (str == null || str.length() == 0 || anagram == null || anagram.length() == 0) {
      return matchIndexes;
    }
    // create a hashmap from anagram to keep the count of chars
    int[] hash = new int[256];
    int window = anagram.length();
    for (int i = 0; i < window; i++) {
      hash[anagram.charAt(i)]++;
    }
    // now we will slide the window & decrement the frequency of the chars in hash. The point is when we slide the window
    // we just to increase the frequency of the character going out of the window, hence we will increase its frequency
    // when sliding. and only increase the windowCount by 1 if the outgoing char was in hash.
    int head = 0;
    int tail = 0;
    int len = str.length();
    int windowCount = window;
    char c;
    char outGoing;
    while (tail < len) {
      c = str.charAt(tail);
      if (hash[c] >= 1) {
        windowCount--;
      }
      hash[c]--;
      tail++;
      if (windowCount == 0) {
        matchIndexes.add(head);
      }
      if (tail - head == window) {
        outGoing = str.charAt(head);
        if (hash[outGoing] >= 0) {
          windowCount++;
        }
        hash[outGoing]++;
        head++;
      }
    }
    return matchIndexes;
  }

  /*  [20] Valid Parentheses
  * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
  * */
  public static boolean isValid(String str) {
    Stack<Character> stack = new Stack<>();
    char c;
    char top;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        top = stack.peek();
        if (c == getClosing(top)) {
          stack.pop();
        } else break;
      }
    }
    return stack.isEmpty();
  }

  private static char getClosing(char c) {
    char closing = 'X';
    switch (c) {
      case '{':
        closing = '}';
        break;
      case '[':
        closing = ']';
        break;
      case '(':
        closing = ')';
        break;
    }
    return closing;
  }

  /*  [48] Rotate Image
  *
  * */
  public static void rotate(int[][] matrix) {
    int levels = matrix.length;
    int i = 0;
    int temp;
    while (i < levels / 2) {
      int swapLevel = i;
      for (int j = swapLevel; j < levels - swapLevel - 1; j++) {
        temp = matrix[swapLevel][j];

        // bring left col to top row
        matrix[swapLevel][j] = matrix[levels - j - 1][swapLevel];

        //bring bottom row to left col
        matrix[levels - j - 1][swapLevel] = matrix[levels - swapLevel - 1][levels - j - 1];

        //bring right col to bottom row
        matrix[levels - swapLevel - 1][levels - j - 1] = matrix[j][levels - swapLevel - 1];

        // put temp to right col
        matrix[j][levels - swapLevel - 1] = temp;
      }
      i++;
    }

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix.length; col++) {
        System.out.print(" " + matrix[row][col]);
      }
      System.out.println("");
    }
  }

  /*  [238] Product of Array Except Self
  *Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
  * of all the elements of nums except nums[i].
  * Solve it without division and in O(n).
  * For example, given [1,2,3,4], return [24,12,8,6].
  * */
  public static int[] productExceptSelf(int[] arr) {
    int[] res = new int[arr.length];
    int temp = 1;
    // we have to create a shifted aray of products thats why we initialize with 1 and not arr[0], this will give us all
    // the nos product except the last number, now we traverse this product the array but from right, and multiply with
    // the number ar same pos in res array.
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

  /*  [16] 3SumClosest
  * */
  public static int threeSumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int low = i + 1;
      int high = arr.length - 1;
      int a = arr[i];

      while (low < high) {
        int b = arr[low];
        int c = arr[high];
        int sum = a + b + c;
        int diff = target - (sum);
        if (diff > -1 && diff < minDiff) {
          minDiff = diff;
          System.out.println("~DL~ a: " + a + " b: " + b + " c: " + c + " mindiff : " + minDiff);
          if (minDiff == 0) {
            return minDiff;
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
    return minDiff;
  }

  /*  [239] Sliding Window Maximum
   *   Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
   *   very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
   *   For example,
   *   Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
   * */
  public static int[] slidingWindowMaximum(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    int head = 0;
    int tail = 0;
    while (tail < k - 1) {
      maxHeap.add(arr[tail]);
      tail++;
    }
    List<Integer> nos = new ArrayList<>();
    while (tail < arr.length) {
      maxHeap.add(arr[tail]);
      int max = maxHeap.peek();
      nos.add(max);
      int outGoing = arr[head];
      maxHeap.remove(outGoing);
      head++;
      tail++;
    }

    int[] res = new int[nos.size()];
    for (int i = 0; i < nos.size(); i++) {
      res[i] = nos.get(i);
    }
    return res;
  }

  /*  [Prob 387] First Unique Character in a String
  *   Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
  *   Examples:
  *   s = "leetcode"
  *   return 0.
  *   s = "loveleetcode",
  *   return 2.
  * */
  public static int firstUniqueCharacter(String str) {
    int firstCharIndex = -1;
    if (str == null || str.length() == 0) {
      return firstCharIndex;
    }
    int[] allChars = new int[256];

    for (int i = 0; i < str.length(); i++) {
      allChars[str.charAt(i)]++;
    }
    for (int i = 0; i < str.length(); i++) {
      if (allChars[str.charAt(i)] == 1) {
        firstCharIndex = i;
        break;
      }
    }
    return firstCharIndex;
  }
}