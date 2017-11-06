package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

// #228. Summary Ranges
//  Given a sorted integer array without duplicates, return the summary of its ranges.
//      Example 1:
//  Input: [0,1,2,4,5,7]
//  Output: ["0->2","4->5","7"]
//  Example 2:
//  Input: [0,2,3,4,6,8,9]
//  Output: ["0","2->4","6","8->9"]

  public static List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<>();
    if(nums == null || nums.length == 0) return res;
    int start = nums[0];
    for(int i = 1; i < nums.length; i++){
      while(i < nums.length && nums[i] == nums[i - 1] + 1) i++;// continue till range is valid

      if(i == nums.length) break; // if we reached the end of list then break

      res.add(getRange(nums[i-1], start)); // get range string for i-1 prev number & start
      start = nums[i];
    }
    res.add(getRange(nums[nums.length - 1], start)); // if the last number gives a remainder range or self
    return res;
  }

  private static String getRange(int num, int start) {
    String r;
    if (num != start)
      r = start + "->" + num;
    else
      r = num + "";
    return r;
  }

  public static void main(String[] args) {
    int [] nums = new int[]{0,2,3,4,6,8,9};
    System.out.println(Arrays.toString(nums));
    List<String> res= summaryRanges(nums);
    for(String s : res)
      System.out.println(s);
  }
}
