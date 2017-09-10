package darkRealm;

import java.util.*;

public class IntersectionArrays {

//  Given two arrays, write a function to compute their intersection.
//  Example:
//  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//  Note:
//  Each element in the result should appear as many times as it shows in both arrays.
//  The result can be in any order.
//  Follow up:
//  What if the given array is already sorted? How would you optimize your algorithm?
//  What if nums1's size is small compared to nums2's size? Which algorithm is better?
//  What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into
//  the memory at once?

  public static int[] intersectionArrays(int[] arr, int[] brr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : arr)
      map.put(n, map.getOrDefault(n, 0) + 1);
    Map<Integer, Integer> map2 = new HashMap<>();
    Map<Integer, Integer> res = new HashMap<>();
    for (int n : brr) {
      map2.put(n, map2.getOrDefault(n, 0) + 1);
      if (map.containsKey(n))
        res.put(n, Math.min(map.get(n), map2.get(n)));
    }
    List<Integer> resList = new ArrayList<>();
    for (int k : res.keySet()) {
      int val = res.get(k);
      while (val-- != 0)
        resList.add(k);
    }
    int[] resArr = new int[resList.size()];
    int i = 0;
    for (int n : resList)
      resArr[i++] = n;
    return resArr;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 2, 1};
    int[] brr = new int[]{2, 2};
    int[] res = intersectionArrays(arr, brr);
    System.out.println("arr : " + Arrays.toString(arr));
    System.out.println("brr : " + Arrays.toString(brr));
    System.out.println("res : " + Arrays.toString(res));
  }
}