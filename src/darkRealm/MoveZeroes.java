package darkRealm;

import java.util.Arrays;

public class MoveZeroes {


/*
  #283. Move Zeroes
  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
  For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
  Note:
  You must do this in-place without making a copy of the array.
  Minimize the total number of operations.
*/

  public static void moveZeroes(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int zi = 0;
    while (zi < arr.length && arr[zi] != 0) zi++;
    for (int i = zi + 1; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[zi] = arr[i];
        arr[i] = 0;
        zi++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 0, 3, 12};
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
