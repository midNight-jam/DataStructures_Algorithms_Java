package darkRealm;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

  public static int findUnsortedSubarray(int[] nums) {
    int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    while (l < r && nums[l] <= nums[l + 1]) l++;
    if(l>=r) return 0;
    while (nums[r] >= nums[r-1]) r--;
    for (int i = l; i <= r; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }
    while (l >= 0 && nums[l] > min) l--;
    while (r < nums.length && nums[r] < max) r++;
    return (r - l - 1);
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
//    int[] nums = new int[]{1,2,3,4};
//    int[] nums = new int[]{1, 3, 5, 4, 2};
//    int[] nums = new int[]{2, 1};
    int len = findUnsortedSubarray(nums);
    System.out.println("A : " + Arrays.toString(nums) + "\nN : " + len);
  }
}
