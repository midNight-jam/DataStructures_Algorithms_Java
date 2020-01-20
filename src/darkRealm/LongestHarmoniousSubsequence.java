package darkRealm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

//  594. Longest Harmonious Subsequence
//  We define a harmonious array is an array where the difference between its maximum value and its minimum value is
//  exactly 1.
//
//  Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its
//  possible subsequences.
//
//  Example 1:
//  Input: [1,3,2,2,5,2,3,7]
//  Output: 5
//  Explanation: The longest harmonious subsequence is [3,2,2,2,3].

  public static int longestHarmonicSubsequenceLength(int[] arr) {
    if (null == arr || 0 == arr.length) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : arr)
      map.put(n, map.getOrDefault(n, 0) + 1);
    int maxSubsequenceLength = 0;
    for (int n : arr)
      if (map.containsKey(n + 1))
        maxSubsequenceLength = Math.max(maxSubsequenceLength, map.get(n) + map.get(n + 1));
    return maxSubsequenceLength;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
    int res = longestHarmonicSubsequenceLength(arr);
    System.out.println("Arr : " + Arrays.toString(arr));
    System.out.println("Res : " + res);
  }
}
