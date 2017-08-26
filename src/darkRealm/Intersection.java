package darkRealm;

import java.util.*;

public class Intersection {

//  Given two arrays, write a function to compute their intersection.
//
//      Example:
//  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//  Note:
//  Each element in the result must be unique.
//  The result can be in any order.

  public static int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();
    for (int n : nums1)
      set.add(n);

    for (int n : nums2)
      if (set.contains(n))
        intersection.add(n);

    int[] res = new int[intersection.size()];
    int i = 0;
    for (int k : intersection)
      res[i++] = k;
    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 2, 1};
    int[] nums2 = new int[]{2, 2};
    int[] res = intersection(nums1, nums2);
    System.out.println("Intersection : " + Arrays.toString(res));
  }
}
