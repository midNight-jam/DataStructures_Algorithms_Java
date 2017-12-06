package darkRealm.Hyper;

import java.util.*;

/**
 * Created by Jayam on 2/4/2017.
 */
public class LC_Prob_Med2 {


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
    if (s == null || t == null || s.length() != t.length()) return false;
    int[] map = new int[256];
    int len = s.length();

    for (int i = 0; i < len; i++)
      map[s.charAt(i)]++;

    char c;
    for (int i = 0; i < len; i++) {
      c = t.charAt(i);
      if (map[c] > 0)
        map[c]--;
      else
        return false;
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
    Integer[] res = new Integer[n + 1];
    res[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      for (int j = i; j >= 1; j--) {
        res[j] = res[j] + res[j - 1];
      }
    }
    return Arrays.asList(res);
  }

  public static List<List<Integer>> pascalsTriangle(int n) {
    if (n < 1) return new ArrayList<>();
    List<List<Integer>> all = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(0, 1);
      for (int j = 0; j < list.size(); j++) {
        list.set(j - 1, list.get(j - 1 + list.get(j)));
      }

      all.add(new ArrayList<>(list));
    }
    return all;
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
  *   Given a set of distinct integers, numbers, return all possible subsets.
  *   Note: The solution set must not contain duplicate subsets.
  *   For example,
  *   If numbers = [1,2,3], a solution is:
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

  /* [Prob] Given a collection of integers that might contain duplicates, numbers, return all possible subsets
Note: The solution set must not contain duplicate subsets.
For example,
If numbers = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
  * */
  public static List<List<Integer>> subSetII(int[] arr) {
    if (arr == null || arr.length == 0) return new ArrayList<>();
    Arrays.sort(arr);
    List<List<Integer>> all = new ArrayList<>();
    genSets(arr, 0, arr.length, all, new ArrayList<>());
    return all;
  }

  private static void genSets(int[] arr, int pos, int len, List<List<Integer>> all, List<Integer> list) {
    if (pos <= len) all.add(new ArrayList<>(list));
    for (int i = pos; i < len; i++) {
      if (i > pos && arr[i] == arr[i - 1]) continue;
      list.add(arr[i]);
      genSets(arr, i + 1, len, all, list);
      list.remove(list.size() - 1);
    }
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
    int sum = 0, prevRotationSum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      prevRotationSum += i * arr[i];
    }
    int max = prevRotationSum;
    for (int i = arr.length - 1; i > 0; i--) {
      prevRotationSum += sum - arr.length * arr[i]; //sum - no of passes into arr[i]
      max = Math.max(prevRotationSum, max);
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
  *   A) Would use Bidirectinal BFS while keeping the nodes of the most recent levels from both the ends will terminate
  *   when we find any one word os found in most recent dist from other side.
  *   Complexity N/2 * maxBreadth(the nodes on the dist) wordLength * 26
  * */
  public static int wordLadder(String start, String end, List<String> dictionary) {
    if (!dictionary.contains(end)) return 0;
    Set<String> words = new HashSet<>(dictionary);
    Set<String> startSet = new HashSet<>(), endSet = new HashSet<>(), next = null;
    int pathLen = 1;
    // add start & end words to their sets
    startSet.add(start);
    endSet.add(end);
    words.remove(start);
    words.remove(end);
    while (!startSet.isEmpty()) {
      next = new HashSet<>();
      for (String word : startSet) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
          char old = wordArr[i];
          for (char c = 'a'; c <= 'z'; c++) {
            wordArr[i] = c;
            String formed = new String(wordArr);
            if (endSet.contains(formed))
              return pathLen + 1;
            if (words.contains(formed)) {
              next.add(formed);
              words.remove(formed);
            }
          }
          wordArr[i] = old;
        }
      }
      startSet = next.size() < endSet.size() ? next : endSet;
      endSet = startSet.size() < endSet.size() ? endSet : next;
      pathLen++;
    }
    return 0;
  }


  /* [Prob 126] WordLadderII
  * */
  static class WNode { // a helper node for Djikstrars
    String word;
    int dist;
    WNode prev;

    public WNode(String word, int dist, WNode prev) {
      this.word = word;
      this.dist = dist;
      this.prev = prev;
    }
  }

  public static List<List<String>> wordLadderII(String start, String end, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    List<List<String>> paths = new ArrayList<>();
    if (!dict.contains(end)) return paths; // if end not in dict then return

    LinkedList<WNode> queue = new LinkedList<>();
    queue.add(new WNode(start, 1, null));// start que with start word & dist as 1

    HashSet<String> visited = new HashSet<>();
    HashSet<String> unvisited = new HashSet<>();
    unvisited.addAll(dict);
    int preDist = 0;

    while (!queue.isEmpty()) {
      WNode trav = queue.remove();
      String word = trav.word;
      int currDist = trav.dist;

      // type this after you have typed the word forming logic
      if (word.equals(end)) { // we ahve found
        ArrayList<String> list = new ArrayList<String>();
        list.add(trav.word);
        while (trav.prev != null) {
          list.add(0, trav.prev.word);
          trav = trav.prev;
        }
        paths.add(list);
        continue;
      }

      if (preDist < currDist) { // means we have reached here with the min dist thus there is no point in processsing these words again
        unvisited.removeAll(visited);
      }
      preDist = currDist;

      // new word forming logic
      char[] arr = word.toCharArray();
      for (int i = 0; i < arr.length; i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          char temp = arr[i];
          if (arr[i] != c) {
            arr[i] = c;
          }
          String formed = new String(arr);
          if (unvisited.contains(formed)) {
            queue.add(new WNode(formed, trav.dist + 1, trav));
            visited.add(formed);
          }
          arr[i] = temp;
        }
      }
    }
    return paths;
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
  * */

  public static int[] twoSum(int[] nums, int sum) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }
//    HashMap<Integer, Integer> nos = new HashMap<>();
    Set<Integer> nos = new HashSet<>();
    int[] res = new int[2];
    // while putting in hash map/hash set(if ids are not required) check if the diff is already present in the hashset/hashmap
    for (int i = 0; i < nums.length; i++) {
      int find = sum - nums[i];
      if (nos.contains(find)) {
        res[1] = i;
        res[0] = find;
        return res;
      }
      nos.add(nums[i]);
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

  /*  [Prob 89] Gray Code
  * The gray code is a binary numeral system where two successive values differ in only one bit.
  * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
   * A gray code sequence must begin with 0.
   * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
   * 00 - 0
   * 01 - 1
   *11 - 3
   *10 - 2
   *Note:
   * For a given n, a gray code sequence is not uniquely defined.
   *
   *For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
  * */
  public static List<Integer> grayCode(int n) {
    int end = (int) Math.pow(2, n);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < end; i++) {
      res.add(binaryToGray(i));
    }
    return res;
  }

  private static int binaryToGray(int k) {
    // divide by 2 & XOR with self
    return (k >> 1) ^ k;
  }

  /* [Prob] Sort by frequency
  * Given a string, sort it in decreasing order based on the frequency of characters.
  * Input:
  * "tree"
  * Output:
  * "eert"
  * Explanation:
  * 'e' appears twice while 'r' and 't' both appear once.
  * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
  *
  * Solution : Use Bucket Sort
  * */
  public static String sortByFrequency(String str) {
    if (str == null || str.length() < 1) return str;
    int[] map = new int[256];
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      map[str.charAt(i)]++;
      max = Math.max(map[str.charAt(i)], max);
    }
    String[] buckets = new String[max + 1]; // creating the merge list
    for (int i = 0; i < map.length; i++) {
      String s = buckets[map[i]];
      if (map[i] > 0) {
        buckets[map[i]] = s == null ? "" + (char) i : s + (char) i; // merging te same frequency chars
      }
    }
    StringBuilder helper = new StringBuilder();
    for (int i = max; i >= 0; i--) {  // reading from behind as we had to put higher frequnecy chars first
      String s2 = buckets[i];
      if (s2 != null && !s2.equals("")) {
        for (int j = 0; j < s2.length(); j++) {
          for (int k = 0; k < i; k++) {
            helper.append(s2.charAt(j));  // adding each char as many times as they have appeared in the oriiganl string
          }
        }
      }
    }
    return helper.toString();
  }

  /* [Prob 139] Word Break
  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
  * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
  * contain duplicate words.
  * For example, given
  * s = "leetcode",
  * dict = ["leet", "code"].
  * Return true because "leetcode" can be segmented as "leet code".
  * A) we slide a window and try to see if the current chars in a window for a string that is in dictionary.
  * We also keep this intermediate result saved in a boolean array to propogate the result forward when we increase the
  * sliding window size. if (Iam) "I" and "am" can be formed using dictionary while breaking the string we satore the
  * result that string of length 3 can be formed using dictionary, similarly if the result for the length of the string
  * is also true mean the whole string can be formed using the dictionary while doing some partitions at places.
  * */
  public static boolean wordBreak(String str, List<String> wordDict) {
    if (str == null || str.length() == 0) return true;
    int n = str.length();
    boolean[] partition = new boolean[n + 1];
    partition[0] = true;
    String part = null;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        part = str.substring(j, i);
        if (wordDict.contains(part) && partition[j]) {
          partition[i] = true;
          break;
        }
      }
    }
    return partition[n];
  }

  /*  [Prob 140]
  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
  * construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain
  * duplicate words.
  * Return all such possible sentences.
  * For example, given
  * s = "catsanddog",
  * dict = ["cat", "cats", "and", "sand", "dog"].
  * solution is ["cats and dog", "cat sand dog"].
  * A) we use a hashMap to store the list of words that can be formed via dictionary by using some portion of the original
  * string. For this purpose we break the string from behind & check if the backPortion cab be formed using dictinary,
  * if yes then we send the front remainder for same process if at the end the frontRem can be broken down in to valid word
  * formed via dictionary then those words are returned, this is the portion to pay attention we verify this by checking
  * the returned sub list length, while this subresult is returned & stored in map, we add these
  * results to the previously borken down backPortion and add this sub portion in map. hence while returning from recursion
  * we will fianlly have the results of valid borken words  against the same key from where we can return.
  * */
  public static List<String> wordBreakII(String str, List<String> wordDict) {
    Map<String, List<String>> subResMap = new HashMap<>();
    return wordBreakAll(str, wordDict, subResMap);
  }

  private static List<String> wordBreakAll(String str, List<String> dict, Map<String, List<String>> subResMap) {
    if (subResMap.containsKey(str)) return subResMap.get(str);
    List<String> subList = new ArrayList<>();
    if (dict.contains(str)) subList.add(str);
    String backPart;
    for (int i = 1; i < str.length(); i++) {
      backPart = str.substring(i);
      if (dict.contains(backPart)) {
        String frontRem = str.substring(0, i);
        List<String> backRes = wordBreakAll(frontRem, dict, subResMap);
        if (backRes.size() > 0)
          for (int j = 0; j < backRes.size(); j++)
            subList.add(backRes.get(j) + " " + backPart);
      }
    }
    subResMap.put(str, subList);
    return subResMap.get(str);
  }

  /* [Prob 516] Longest Palindromic Subsequence
	* Given a string s, find the longest palindromic subsequence's length in s.
	* You may assume that the maximum length of s is 1000.
	* Example 1:
	* Input:
	* "bbbab"
	* Output:
	* 4
	* One possible longest palindromic subsequence is "bbbb".
	* Example 2:
	* Input:
	* "cbbd"
	* Output:
	* 2
	* One possible longest palindromic subsequence is "bb".
	*  A) USE DP  In this solution we solve while moving towards top right, rather than usual bottom right. So Effectively
	*  lower half of matrix is useless, only top half of matrix is utilized
	*  Two Rules :
	*   if char at head == char at tail pick vlaue from lower diagonal & add 2
	*   if chats are diff then take max of one col behind & one row below
	*/
  public static int longestPalidromicSubsequence(String str) {
    int len = str.length();
    int[][] DP = new int[len][len];
    // red strings fromlast
    for (int i = len - 1; i >= 0; i--) {
      DP[i][i] = 1;
      for (int j = i + 1; j < len; j++) {
        if (str.charAt(i) == str.charAt(j)) {
          DP[i][j] = DP[i + 1][j - 1] + 2;
        } else {
          DP[i][j] = Math.max(DP[i + 1][j], DP[i][j - 1]);
        }
        System.out.println(str.substring(i, j));
      }
    }
    return DP[0][len - 1];
  }

  public static String shortestPath(char[][] matrix, char a, char b) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return "";
    int startR, startC;
    startR = startC = 0;
    boolean found = false;
    char toSearch = '\u0000';
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == a || matrix[i][j] == b) {
          startR = i;
          startC = j;
          found = true;
          toSearch = matrix[i][j] == a ? b : a;
          break;
        }
      }
      if (found) break;
    }
    return found ? bfsShortestPath(matrix, startR, startC, toSearch) : "";
  }

  private static String bfsShortestPath(char[][] matrix, int startR, int startC, char toSearch) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int[] rowNeighbours = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] colNeighbours = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    Queue<QueNode> queue = new LinkedList<>();
    queue.add(new QueNode(0, startR, startC, matrix[startR][startC] + ""));
    QueNode trav;
    while (!queue.isEmpty()) {
      trav = queue.remove();
      visited[trav.row][trav.col] = true;
      if (toSearch == matrix[trav.row][trav.col]) {
        return trav.path;
      }
      int eRow, eCol;
      for (int i = 0; i < rowNeighbours.length; i++) {
        eRow = trav.row + rowNeighbours[i];
        eCol = trav.col + colNeighbours[i];
        if (isSafe(matrix, eRow, eCol, visited))
          queue.add(new QueNode(trav.dist + 1, eRow, eCol, trav.path + " " + matrix[eRow][eCol]));
      }
    }
    return "";
  }

  private static boolean isSafe(char[][] matrix, int r, int c, boolean[][] visited) {
    return (r > -1 && r < matrix.length && c > -1 && c < matrix[0].length && !visited[r][c]);
  }

  private static class QueNode {
    int dist;
    int row;
    int col;
    String path;

    QueNode(int l, int r, int c, String p) {
      dist = l;
      row = r;
      col = c;
      path = p;
    }
  }

  /*  [Prob 159] Longest Substring with At Most Two Distinct Characters
  *   Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
  *   For example, Given s = “eceba”,
  *   T is "ece" which its length is 3.
  * */
  public static int lengthOfLongestSubstringTwoDistinct(String str) {
    if (str == null || str.length() == 0) return 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int k = 2;
    int left = 0, maxLen = 0;
    char leftCh = str.charAt(0);
    char ch;
    for (int i = 0; i < str.length(); i++) {
      ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while (map.size() > k) {
        leftCh = str.charAt(left);
        map.put(leftCh, map.get(leftCh) - 1);
        if (map.get(leftCh) == 0) map.remove(leftCh);
        left++;
      }
      maxLen = Math.max(maxLen, i - left + 1);
    }
    return maxLen;
  }

  /* [Prob 340] Longest Substring with At Most K Distinct Characters
  * Given a string, find the length of the longest substring T that contains at most k distinct characters.
  * For example, Given s = “eceba” and k = 2,
  * T is "ece" which its length is 3.
  * */
  public static int lengthOfLongestSubstringKDistinct(String str, int k) {
    if (str == null || str.length() == 0 || k < 1) return 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0, maxLen = 0;
    char leftCh, ch;
    for (int i = 0; i < str.length(); i++) {
      ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while (map.size() > k) {
        leftCh = str.charAt(left);
        map.put(leftCh, map.get(leftCh) - 1);
        if (map.get(leftCh) == 0) map.remove(leftCh);
        left++;
      }
      maxLen = Math.max(maxLen, i - left + 1);
    }
    return maxLen;
  }

  /* 3. Longest Substring Without Repeating Characters
  * */
  public static int longestSubStringWithoutRepeatingCharacters(String str) {
    if (str == null || str.length() == 0) return 0;
    Set<Character> set = new HashSet<>();
    int left = 0, right = 0, len = str.length(), max = Integer.MIN_VALUE;
    char ch;
    while (right < len) {
      ch = str.charAt(right);
      if (!set.contains(ch)) {
        set.add(ch);
        max = Math.max(set.size(), max);
        right++;
      } else {
        set.remove(str.charAt(left));
        left++;
      }
    }
    return max;
  }

  /*  [Prob 395 ] Longest Substring with At Least K Repeating Characters
  *
  * */
  public static int longestSubstring(String s, int k) {
    HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    HashSet<Character> missSet = new HashSet<>();
    for (char c : countMap.keySet())
      if (countMap.get(c) < k)
        missSet.add(c);

    if (missSet.isEmpty()) {
      return s.length();
    }

    int max = 0;
    int left = 0, right = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      if (missSet.contains(c)) {
        if (right != left) {
          max = Math.max(max, longestSubstring(s.substring(left, right), k));
        }
        left = right + 1;
      }
      right++;
    }

    if (left != right)
      max = Math.max(max, longestSubstring(s.substring(left, right), k));

    return max;
  }
}