package darkRealm;

public class MergeSortedArray {

//  #88. Merge Sorted Array
//  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//  Note:
//  You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
//  from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, ptr = m + n - 1;
    // push from the end
    while (i > -1 && j > -1)
      if (nums1[i] > nums2[j]) nums1[ptr--] = nums1[i--];
      else nums1[ptr--] = nums2[j--];
    // push the left over
    while (i > -1) nums1[ptr--] = nums1[i--];
    while (j > -1) nums1[ptr--] = nums2[j--];
    for (int e : nums1)
      System.out.print(e + " ");
  }

  public static void main(String[] args) {
    int[] nums1 = new int[6];
    nums1[0] = 1;
    nums1[1] = 3;
    nums1[2] = 6;
    int[] nums2 = new int[]{2, 4, 5};
    merge(nums1, 3, nums2, nums2.length);
  }
}