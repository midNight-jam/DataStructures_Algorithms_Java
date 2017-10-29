package darkRealm;

import java.util.Arrays;

public class SortColors {

//  #75. Sort Colors
//  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//  Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//  Note:
//  You are not suppose to use the library's sort function for this problem.
//  Follow up:
//  A rather straight forward solution is a two-pass algorithm using counting sort.
//  First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//  Could you come up with an one-pass algorithm using only constant space?

  public static void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) return;
    int z = 0, s = nums.length - 1;
    for (int i = z; i <= s; i++) {
      // First we are checking for 2, and if found swap, because sorting from back
      while (nums[i] == 2 && i < s) {
        int temp = nums[i];
        nums[i] = nums[s];
        nums[s] = temp;
        s--;
      }
      // Next we are checking for 1, and if found swap
      while (nums[i] == 0 && i > z) {
        int temp = nums[i];
        nums[i] = nums[z];
        nums[z] = temp;
        z++;
      }
    }
  }

  public static void main(String[] args) {
//    int[] colors = new int[]{0};
//    int[] colors = new int[]{1, 1};
    int[] colors = new int[]{1, 2, 0};
    sortColors(colors);
    System.out.println(Arrays.toString(colors));
  }
}