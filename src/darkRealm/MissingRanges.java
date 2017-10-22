package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {

//  #163. Missing Ranges
//  Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its
//  missing ranges.
//  For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

  public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    int n = lower;
    String s;
    List<String> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (n > nums[i]) continue; // if n is greater then continue
      if (n == nums[i]) {
        // if n equals the range then increment n & continue, incrementing will cause it to be handled in next iteration
        if (n + 1 < n)
          return res;
        n++;
        continue;
      }
      s = (n == nums[i] - 1) ? n +"" : n +"->" + (nums[i] - 1);
      res.add(s);
      if (nums[i] + 1 < nums[i])
        return res;
      n = nums[i] + 1; // set the next from current number + 1
    }
    if (n <= upper) {
      s = (n == upper) ? n +"" : n +"->" + upper;
      res.add(s);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 3, 50, 75};
//    int[] nums = new int[]{2147483647};
//    int[] nums = new int[]{0, 1, 3, 50, 75};
//    int[] nums = new int[]{0, 1, 2, 3, 75};
//    int[] nums = new int[]{0, 1};
//    int[] nums = new int[0];
//    int lower = 1, upper = 1;
//    int lower = 2147483647, upper = 2147483647;
    int lower = 0, upper = 99;
    List<String> res = findMissingRanges(nums, lower, upper);
    System.out.println(Arrays.toString(nums));
    System.out.println(lower + " <-> " + upper);
    System.out.println("----------------");
    for (String s : res)
      System.out.println(s);
  }
}