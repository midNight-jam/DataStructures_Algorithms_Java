package darkRealm;

import java.util.Arrays;

public class TrapRainWater {

//  #42. Trapping Rain Water ::: Complexity - Time : O(n), Space : O(1) for first method, O(2n) for second method
//  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//  For example,
//  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//  The above elevation map is represented by array [0,1,0,2,1,0,1,

  public static int trap(int[] height) {
    if (height == null || height.length < 3) return 0;
    int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
    int left = 0, right = height.length - 1;
    int vol = 0;

    // Intuition is we scan array using two pointers left and right and keep getting the max at both pointers
    // At any point choose the smaller one among the max because beyond that water would flow out and substract the
    // height of the current block because above this water will be captured
    while (left < right) {
      lmax = Math.max(lmax, height[left]);
      rmax = Math.max(rmax, height[right]);
      if (lmax < rmax) {
        vol += lmax - height[left]; // lmax - height[left] wil give 0, if the current block is the max block
        left++;
      } else {
        vol += rmax - height[right]; // rmax - height[right] wil give 0, if the current block is the max block
        right--;
      }
    }
    return vol;
  }

  public static int trap_OLD(int[] height) {
    if (height == null || height.length < 3) return 0;
    int vol = 0;
    int[] lh = new int[height.length];
    int[] rh = new int[height.length];
    int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
    // Intuition is for all points calculate the left and right max
    for (int i = 0; i < height.length; i++) {
      lmax = Math.max(lmax, height[i]);
      rmax = Math.max(rmax, height[height.length - i - 1]);
      lh[i] = lmax;
      rh[height.length - i - 1] = rmax;
    }
    // now for each point get the smaller one among the left & right max and subtract the current height from it to get
    // the volume of water that can be captured on this block.
    for (int i = 0; i < height.length; i++)
      vol += Math.min(lh[i], rh[i]) - height[i];

    return vol;
  }

  public static void main(String[] args) {
    int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int vol = trap(height);
    System.out.println(Arrays.toString(height));
    System.out.println("V : " + vol);
  }
}
