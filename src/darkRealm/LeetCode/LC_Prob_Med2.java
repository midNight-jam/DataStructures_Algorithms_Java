package darkRealm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
      Integer j =arr[i];
     if(j.equals(first) ||j.equals(second)||j.equals(third)){
       continue;
     }
      if (first == null || arr[i] > first) {
        third = second;
        second = first;
        first = arr[i];
      } else if (second == null || arr[i] > second) {
        third = second;
        second = arr[i];
      } else if (third == null ||  arr[i] > third) {
        third = arr[i];
      }
    }
    return third == null ? first : third;
  }

  /*
  * */
}