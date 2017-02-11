package darkRealm.LeetCode;

import java.util.*;

/**
 * Created by Jayam on 2/4/2017.
 */
public class LC_Prob_Med2 {
  /*  [Prob 17]  Letter Combinations of a Phone Number
  * Given a digit string, return all possible letter combinations that the number could represent.
  * A mapping of digit to letters (just like on the telephone buttons) is given below.
  * Input:Digit string "23"
  * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
  * */
  public static List<String> letterCombinations(int num) {
    if (num < 1) {
      return new ArrayList<>();
    }
    results = new ArrayList<>();
    HashMap<Integer, char[]> keyBoard = new HashMap<>();
    keyBoard.put(2, new char[]{'a', 'b', 'c'});
    keyBoard.put(3, new char[]{'d', 'e', 'f'});
    keyBoard.put(4, new char[]{'g', 'h', 'i'});
    keyBoard.put(5, new char[]{'j', 'k', 'l'});
    keyBoard.put(6, new char[]{'m', 'n', 'o'});
    keyBoard.put(7, new char[]{'p', 'q', 'r', 's'});
    keyBoard.put(8, new char[]{'t', 'u', 'v'});
    keyBoard.put(9, new char[]{'w', 'x', 'y', 'z'});
    int len = (int) Math.log10(num) + 1;

    keyBoardString(keyBoard, num, len, "");
    return results;
  }

  private static List<String> results = new ArrayList<>();

  private static void keyBoardString(HashMap<Integer, char[]> keyboard, int num, int len, String str) {
    if (len == 0) {
      results.add(str);
      return;
    }
    int powerTen = (int) Math.pow(10, len);
    int key = num % powerTen;
    key = key / (powerTen / 10);
    if (keyboard.containsKey(key)) {
      char[] chars = keyboard.get(key);
      for (int i = 0; i < chars.length; i++) {
        keyBoardString(keyboard, num, len - 1, str + chars[i]);
      }
    }
  }

  public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    HashMap<Integer, char[]> keyBoard = new HashMap<>();
    keyBoard.put(2, new char[]{'a', 'b', 'c'});
    keyBoard.put(3, new char[]{'d', 'e', 'f'});
    keyBoard.put(4, new char[]{'g', 'h', 'i'});
    keyBoard.put(5, new char[]{'j', 'k', 'l'});
    keyBoard.put(6, new char[]{'m', 'n', 'o'});
    keyBoard.put(7, new char[]{'p', 'q', 'r', 's'});
    keyBoard.put(8, new char[]{'t', 'u', 'v'});
    keyBoard.put(9, new char[]{'w', 'x', 'y', 'z'});

    keyBoardString(keyBoard, digits, 0, "");
    return results;
  }

  private static void keyBoardString(HashMap<Integer, char[]> keyboard, String digits, int index, String str) {
    if (index == digits.length()) {
      results.add(str);
      return;
    }
    int key = Integer.parseInt(digits.charAt(index) + "");
    if (keyboard.containsKey(key)) {
      char[] chars = keyboard.get(key);
      for (int i = 0; i < chars.length; i++) {
        keyBoardString(keyboard, digits, index + 1, str + chars[i]);
      }
    }
  }

  /*  [Prob 49]  Group Anagrams
  * Given an array of strings, group anagrams together.
  * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
  * Return:
  * [ ["ate", "eat","tea"],  ["nat","tan"],  ["bat"] ]
  * Note: All inputs will be in lower-case.
  * */
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      char[] sar = s.toCharArray();
      Arrays.sort(sar);
      String s2 = new String(sar);
      if (map.containsKey(s2)) {
        map.get(s2).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(s2, list);
      }
    }
    List<List<String>> results = new ArrayList<>();
    for (String k :
        map.keySet()) {
      results.add(map.get(k));
    }
    return results;
  }

  /*  [Prob 242] Valid Anagram
  *Given two strings s and t, write a function to determine if t is an anagram of s.
  * For example,
  * s = "anagram", t = "nagaram", return true.
  * s = "rat", t = "car", return false.
  * Note: You may assume the string contains only lowercase alphabets.
  * Follow up:  What if the inputs contain unicode characters? How would you adapt your solution to such case?
  * */
  public static boolean validAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int[] charCount = new int[256];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      charCount[c]++;
    }

    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (charCount[c] >= 1) {
        charCount[c]--;
      } else {
        return false;
      }
    }

    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] != 0) {
        return false;
      }
    }
    return true;
  }

  /*  [42] Trapping Rain Water
  *   Q) Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
   *   water it is able to trap after raining.
   *   For example,
   *   Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
  * */
  public static int trappingRainWater(int[] arr) {
    if (arr == null || arr.length < 3) {
      return 0;
    }
    int water = 0;
    int[] left = new int[arr.length];
    int[] right = new int[arr.length];
    int max = arr[0];
    left[0] = max;
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(arr[i], max);
      left[i] = max;
    }
    max = arr[arr.length - 1];
    right[arr.length - 1] = max;
    for (int j = arr.length - 2; j >= 0; j--) {
      max = Math.max(arr[j], max);
      right[j] = max;
    }

    int small = 0;
    int diff = 0;
    for (int i = 0; i < arr.length; i++) {
      small = Math.min(left[i], right[i]);
      diff = small - arr[i];
      if (diff > 0) {
        water += diff;
      }
    }
    return water;
  }

  /*  [Prob 119] ith Row of Pascals Triangle
   Pascal's Triangle II
  * */
  public static List<Integer> pascalsTriangleRow(int n) {
    if (n < 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> rows = new ArrayList<>();
    List<Integer> first = new ArrayList<>();
    first.add(1);
    rows.add(first);
    for (int i = 1; i <= n; i++) {
      if (rows.size() < i + 1) {
        List<Integer> ithRow = new ArrayList<>();
        ithRow.add(1);
        rows.add(ithRow);
      }
      List<Integer> prevRow = rows.get(i - 1);
      List<Integer> thisRow = rows.get(i);
      for (int j = 1; j <= i; j++) {
        int a = prevRow.get(j - 1);
        int b = j >= prevRow.size() ? 0 : prevRow.get(j);
        int sum = a + b;
        thisRow.add(sum);
      }
    }
    return rows.get(n);
  }

  /*  [Prob 414] Third Maximum Number
  *   Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return
  *   the maximum number. The time complexity must be in O(n).
  *   Example 1:
  *   Input: [3, 2, 1]
  *   Output: 1
  *   Explanation: The third maximum is 1.
  * */
  public static int thirdMaximumNumber(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    Integer first = null;
    Integer second = null;
    Integer third = null;

    for (int i = 0; i < arr.length; i++) {
      Integer j = arr[i];
      if (j.equals(first) || j.equals(second) || j.equals(third)) {
        continue;
      }
      if (first == null || arr[i] > first) {
        third = second;
        second = first;
        first = arr[i];
      } else if (second == null || arr[i] > second) {
        third = second;
        second = arr[i];
      } else if (third == null || arr[i] > third) {
        third = arr[i];
      }
    }
    return third == null ? first : third;
  }

  /*  [Prob 78] Subsets
  *   Given a set of distinct integers, nums, return all possible subsets.
  *   Note: The solution set must not contain duplicate subsets.
  *   For example,
  *   If nums = [1,2,3], a solution is:
  *   [
  *   [3],
  *   [1],
  *   [2],
  *   [1,2,3],
  *   [1,3],
  *   [2,3],
  *   [1,2],
  *   []
  *   ]
  * */
  public static List<List<Integer>> subSet(int[] arr) {
    if (arr == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> subsets = new ArrayList<>();
    int setSize = (int) Math.pow(2, arr.length);
    for (int i = 0; i < setSize; i++) {
      int index = 0;
      int j = i;
      List<Integer> set = new ArrayList<>();
      while (j != 0) {
        if ((j & 1) == 1) {
          set.add(arr[index]);
        }
        index++;
        j = j >> 1;
      }
      subsets.add(set);
    }
    return subsets;
  }

  /*  [Prob 396] Rotate Function
   * Given an array of integers A and let n to be its length. Assume Bk to be an array obtained by rotating the array
   * A k positions clock-wise, we define a "rotation function" F on A as follow:
   * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
   * Calculate the maximum value of F(0), F(1), ..., F(n-1).
   * Note:
   * n is guaranteed to be less than 105.
   * Example:
   * A = [4, 3, 2, 6]
   * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
   * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
   * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
   * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
   * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
  * */
  public static int rotate(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int pass = 0;
    int max = Integer.MIN_VALUE;
    int i, val, j, m;
    while (pass < arr.length) {
      val = 0;
      i = pass;
      for (; i < arr.length; i++) {
        m = i - pass;
        val += arr[i] * m;
      }
      for (j = 0; j < pass; j++) {
        m = arr.length - pass + j;
        val += arr[j] * m;
      }
      System.out.println(val);
      if (val > max) {
        max = val;
      }
      pass++;
    }
    return max;
  }

  /*  [Prob 200] Number of Islands
   *   Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
   *   and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
   *   are all surrounded by water.
   *   Example 1:
   *   11110
   *   11010
   *   11000
   *   00000
   *   Answer: 1
   *
   *   Example 2:
   *   11000
   *   11000
   *   00100
   *   00011
   *   Answer: 3
   * */

  public static int numberOfIslands(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int islands = 0;
    _ROW = matrix.length;
    _COL = matrix[0].length;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1 && !visited[i][j]) {
          DFS(matrix, i, j, visited);
          ++islands;
        }
      }
    }
    return islands;
  }

  static int _ROW, _COL;

  private static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited) {
    boolean isSafe = (row > -1 && row < _ROW) && (col > -1 && col < _COL) && matrix[row][col] == 1 && !visited[row][col];
    return isSafe;
  }

  private static void DFS(int[][] matrix, int row, int col, boolean[][] visited) {
    // neighbours : top left, top, top right, right, bottom right, bottom, bottom left, left
    int[] rowNeighbours = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] colNeighbours = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    visited[row][col] = true;
    int eRow, eCol;

    for (int i = 0; i < rowNeighbours.length; i++) {
      eRow = row + rowNeighbours[i];
      eCol = col + colNeighbours[i];
      if (isSafe(matrix, eRow, eCol, visited)) {
        DFS(matrix, row + rowNeighbours[i], col + colNeighbours[i], visited);
      }
    }
  }

  /*  [Prob 127] Word Ladder
  *   Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
  *   sequence from beginWord to endWord, such that:
  *   Only one letter can be changed at a time.
  *   Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
  *   For example,
  *   Given:
  *   beginWord = "hit"
  *   endWord = "cog"
  *   wordList = ["hot","dot","dog","lot","log","cog"]
  *   As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
  *   return its length 5.
  *
  *   A) Would use Bidirectinal BFS while keeoing the nodes of the most recent levels from both the ends will terminate
  *   when we find any one word os found in most recent level from other side.
  *   Complexity N/2 * maxBreadth(the nodes on the level) wordLength * 26
  * */
  public static int wordLadder(String start, String end, List<String> dictionary) {
    if (start == null || end == null || start.equals(end) || !dictionary.contains(end)) {
      return 0;
    }
    HashSet<String> headSet = new HashSet<>();
    HashSet<String> endSet = new HashSet<>();
    HashSet<String> set;
    HashSet<String> visited = new HashSet<>();

    int pathLen = 1;
    headSet.add(start);
    endSet.add(end);
    set = headSet;
    while (!headSet.isEmpty() && !endSet.isEmpty()) {
      if (headSet.size() > endSet.size()) { // swap both as weh to traverse from the opposoite direction now
        set = headSet;
        headSet = endSet;
        endSet = set;
      }
      HashSet<String> temp = new HashSet<String>(); /// this is required to store nodes of only this level, we dont need to
      // carry nodes of other levels as we only need them for checking is visited or not, and for that purpose they are already in
      //visited set
      for (String word : headSet) {
        char c;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
          c = word.charAt(i);
          for (char cj = 'a'; cj <= 'z'; cj++) {
            wordArr[i] = cj;
            String formed = String.valueOf(wordArr);
            if (endSet.contains(formed)) {
              return pathLen + 1;
            }
            if (!visited.contains(formed) && dictionary.contains(formed)) {
              temp.add(formed);
              visited.add(formed);
            }
          }
          wordArr[i] = c;
        }
        headSet = temp;
        pathLen++;
      }
    }
    return 0;
  }

  /*  [Prob 10] Regular Expression Matching
  *   Explaination : https://www.youtube.com/watch?v=l3hda49XcDE
  *
  *   Two Rules :
  *   1: if pattern char is * (star) assign value from two left (0 occurence ) OR
  *    OR 1 occurrence for this check if previous char in pattern matches the current char in string or is prev char a dot
   *    (dot : it always matches)
  *   2: If both chars match or pattern char is .(dot) then assign value from diagonal
  * */
  public static boolean regularExpressionMatching(String str, String pattern) {
    boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
    dp[0][0] = true;
    //Deals with patterns like a* or a*b* or a*b*c*
    for (int i = 1; i < dp[0].length; i++) {
      if (pattern.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 2];
      }
    }

    char pchar, schar;
    for (int i = 1; i < dp.length; i++) {
      schar = str.charAt(i - 1);
      for (int j = 1; j < dp[0].length; j++) {
        pchar = pattern.charAt(j - 1);
        //1: if pattern char is * (star) assign value from two left (ignoring pattern) OR one above (one char removed)
        if (pchar == '*') {
          dp[i][j] = dp[i][j - 2]; //twoLeft (0 occurences)
          char prev = pattern.charAt(j - 2);
          if (prev == '.' || prev == schar) {
            dp[i][j] = dp[i][j] || dp[i - 1][j];
          }
        }
        //2: If both chars match or pattern char is .(dot) then assign value from diagonal
        else if ((pchar == schar) || pchar == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[str.length()][pattern.length()];
  }


  /*  [Prob 5] Longest Palindromic Substring
  *   Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
  *   Example:
  *   Input: "babad"
  *   Output: "bab"
  *   Note: "aba" is also a valid answer.
  *   Example:
  *   Input: "cbbd"
  *   Output: "bb"
  * */
  static int maxLen = Integer.MIN_VALUE;
  static int maxStart;

  public static String longestPalindrome(String str) {
    if (str == null || str.length() < 2) {
      return str;
    }
    for (int i = 0; i < str.length(); i++) {
      expandPalindrome(str, i, i);  // odd len palindrome
      expandPalindrome(str, i, i + 1);  // even len palindrome
    }
    return str.substring(maxStart, maxStart + maxLen);
  }

  private static void expandPalindrome(String str, int left, int right) {
    while ((left >= 0 && right < str.length()) && (str.charAt(left) == str.charAt(right))) {
      left--;
      right++;
    }
    int hereLen = right - left - 1;
    if (hereLen > maxLen) {
      maxLen = hereLen;
      maxStart = left + 1;
    }
  }

  /* 1 : Two sum
  *
  * */

  public static int[] twoSum(int[] nums, int sum) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }
    HashMap<Integer, Integer> nos = new HashMap<>();
    int[] res = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int find = sum - nums[i];
      if (nos.containsKey(find)) {
        res[1] = i;
        res[0] = nos.get(find);
        return res;
      }
      nos.put(nums[i], i);
    }
    return res;
  }

  /*  [Prob 459] Repeated SubString
  * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies
  * of the substring together. You may assume the given string consists of lowercase English letters only and its length
  * will not exceed 10000.
  * Example 1:
  * Input: "abab"
  * Output: True
  * Explanation: It's the substring "ab" twice.
  * Example 2:
  * Input: "aba"
  * Output: False
  * Example 3:
  * Input: "abcabcabcabc"
  * Output: True
  * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
  * */

  public static boolean repeatedSubStringPattern(String str) {
    if (str == null || str.length() < 2) {
      return true;
    }
    StringBuilder pattern = new StringBuilder();
    int len = str.length();
    char c = '\u0000';
    for (int i = 0; i < len / 2; i++) {
      c = str.charAt(i);
      pattern.append(c);
      if (len % pattern.length() == 0) {
        int times = len / pattern.length();
        StringBuilder match = new StringBuilder();
        while (times != 0) {
          match.append(pattern);
          times--;
        }
        if (match.toString().equals(str)) {
          return true;
        }
      }
    }
    return false;
  }
}