package darkRealm.LeetCode;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Node;
import darkRealm.CTCI.Stacks_and_queues.MyQueue;

import java.util.AbstractMap;
import java.util.Arrays;

/**
 * Created by Jayam on 1/27/2017.
 */
public class LC_Prob_1_50 {

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
    if(board.length > 0 ) {
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
}