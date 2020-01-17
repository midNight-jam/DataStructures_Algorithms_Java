package darkRealm;

import java.util.*;

public class NextGreaterElement1 {
//  496. Next Greater Element I
//  You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
//  Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
//  The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
//  exist, output -1 for this number.
//
//      Example 1:
//  Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
//  Output: [-1,3,-1]
//  Explanation:
//  For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//  For number 1 in the first array, the next greater number for it in the second array is 3.
//  For number 2 in the first array, there is no next greater number for it in the second array, so output -1.


  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) return new int[0];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums1.length; i++)
      map.put(nums1[i], -1);

    Stack<Integer> stack = new Stack<>();

    for (int i = nums2.length - 1; i > -1; i--) {
      while (!stack.isEmpty() && nums2[i] >= stack.peek())
        stack.pop();
      if (map.containsKey(nums2[i]))
        map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
      stack.push(nums2[i]);
    }

    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++)
      res[i] = map.get(nums1[i]);

    return res;
  }

  public static int[] nextGreaterElementBASIC(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length > nums2.length)
      return new int[0];
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = new int[nums1.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && stack.peek() < nums2[i])
        map.put(stack.pop(), nums2[i]); // against all the small elements store this one as the next Big ELement
      stack.push(nums2[i]);
    }
    for (int i = 0; i < nums1.length; i++)
      res[i] = map.getOrDefault(nums1[i], -1);

    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{4, 1, 2};
    int[] nums2 = new int[]{1, 3, 4, 2};
//    int[] nums1 = new int[]{2, 4};
//    int[] nums2 = new int[]{1, 2, 3, 4};

    int[] res = nextGreaterElement(nums1, nums2);
    System.out.println("Res : " + Arrays.toString(res));
  }
}
