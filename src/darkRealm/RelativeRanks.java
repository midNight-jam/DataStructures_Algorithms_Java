package darkRealm;

import java.util.*;

public class RelativeRanks {

//  506. Relative Ranks
//  Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be
//  awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
//  Example 1:
//  Input: [5, 4, 3, 2, 1]
//  Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//  Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal"
//  and "Bronze Medal".
//  For the left two athletes, you just need to output their relative ranks according to their scores.


  public static String[] findRelativeRanks(int[] nums) {
    if (nums == null || nums.length < 1) return new String[0];
    Map<Integer, Integer> map = new HashMap<>();
    int high = Integer.MIN_VALUE;
    int low = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
      high = Math.max(high, nums[i]);
      low = Math.min(low, nums[i]);
    }

    String[] res = new String[nums.length];
    int pos = 0;
    for (int i = high; i >= low; i--) {
      if (!map.containsKey(i)) continue;
      pos++;
      switch (pos) {
        case 1:
          res[map.get(i)] = "Gold Medal";
          break;
        case 2:
          res[map.get(i)] = "Silver Medal";
          break;
        case 3:
          res[map.get(i)] = "Bronze Medal";
          break;
        default:
          res[map.get(i)] = pos + "";
      }
    }
    return res;
  }

  public static String[] findRelativeRanksSorting(int[] nums) {
    if (null == nums || 0 == nums.length) return new String[0];
    Map<Integer, String> map = new HashMap<>();
    List<Integer> orignalOrder = new ArrayList<>();
    for (int n : nums) {
      map.put(n, "");
      orignalOrder.add(n);
    }

    Arrays.sort(nums);
    if (nums.length > 0)
      map.put(nums[nums.length - 1], "Gold Medal");
    if (nums.length > 1)
      map.put(nums[nums.length - 2], "Silver Medal");
    if (nums.length > 2)
      map.put(nums[nums.length - 3], "Bronze Medal");

    for (int i = nums.length - 4, j = 4; i > -1; i--, j++)
      map.put(nums[i], j + "");

    List<String> values = new ArrayList<>(map.values());
    String[] res = new String[values.size()];
    for (int i = 0; i < orignalOrder.size(); i++)
      res[i] = map.get(orignalOrder.get(i));
    return res;
  }

  public static void main(String[] args) {
//    int[] scores = new int[]{5, 4, 3, 2, 1};
    int[] scores = new int[]{10, 3, 8, 9, 4};
//    int[] scores = new int[]{5,1};
    String[] res = findRelativeRanksSorting(scores);
    System.out.println("Scores : " + Arrays.toString(scores));
    System.out.println("Ranks  : " + Arrays.toString(res));
    res = findRelativeRanks(scores);
    System.out.println("Scores : " + Arrays.toString(scores));
    System.out.println("Ranks  : " + Arrays.toString(res));
  }
}