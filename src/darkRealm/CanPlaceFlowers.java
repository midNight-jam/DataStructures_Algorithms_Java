package darkRealm;

import java.util.Arrays;

public class CanPlaceFlowers {

//  Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot
//  be planted in adjacent plots - they would compete for water and both would die.
//  Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a
//  number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
//  Example 1:
//  Input: flowerbed = [1,0,0,0,1], n = 1
//  Output: True
//  Example 2:
//  Input: flowerbed = [1,0,0,0,1], n = 2
//  Output: False
//  Note:
//  The input array won't violate no-adjacent-flowers rule.
//  The input array size is in the range of [1, 20000].
//  n is a non-negative integer which won't exceed the input array size.

  public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    int left, right;
    for (int i = 0; i < flowerbed.length; i++) {
      left = i - 1 < 0 ? 0 : flowerbed[i - 1];
      right = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;
      if (left == 0 && right == 0 && flowerbed[i] == 0) {
        count++;
        flowerbed[i] = 1;
      }
    }
    return count >= n;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 0, 0, 0, 0, 0, 1};
//    int[] nums = new int[]{1, 0};
//    int[] nums = new int[]{0, 0};
//    int[] nums = new int[]{0};
//    int[] nums = new int[]{1, 0, 0, 0, 0, 1};
//    int[] nums = new int[]{1, 0, 1, 0, 1, 0, 1};
    int[] nums = new int[]{0, 0, 0, 0, 0, 1, 0, 0};
    int n = 0;
    boolean res = canPlaceFlowers(nums, n);
    System.out.println(" Arr : " + Arrays.toString(nums) + "\nN : " + n + "\nR : " + res);
  }
}