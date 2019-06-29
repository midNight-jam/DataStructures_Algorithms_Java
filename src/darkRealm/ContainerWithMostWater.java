package darkRealm;

import java.util.Arrays;

public class ContainerWithMostWater {

//  # 11. Container With most Water :: Complexity O(n)
//  Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
//  lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
//  x-axis forms a container, such that the container contains the most water.
//  Note: You may not slant the container and n is at least 2.

  public static int maxArea(int[] nums) {
    if (nums == null || nums.length < 2) return 0;
    int max = Integer.MIN_VALUE;
    int left = 0, right = nums.length - 1;
    int breadth = 0, height = 0;
    while (left < right) {
      breadth = right - left;
      height = Math.min(nums[left], nums[right]);
      max = Math.max(max, height * breadth);
      if (height == arr[left])
        left++; // because we have already considered the largest possible rectangle with this height, thus move on
      else
        right--;  // same as above, we have already considered largest possible rectangle with this height.
    }
    return max;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{0, 2};
//    int[] nums = new int[]{1, 3, 0, 2, 4, 0};
//    int[] nums = new int[]{1, 2, 1};
//    int[] nums = new int[]{2, 1};
//    int[] nums = new int[]{1, 2};
    int[] nums = new int[]{1};
    int maxArea = maxArea(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("M : " + maxArea);
  }
}
