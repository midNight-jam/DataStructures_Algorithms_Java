package darkRealm;

public class MedianTwoSortedArrays {


  /*  #4. Median of Two Sorted Arrays
  There are two sorted arrays nums1 and nums2 of size m and n respectively.
  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  Example 1:
  nums1 = [1, 3]
  nums2 = [2]

  The median is 2.0
  Example 2:
  nums1 = [1, 2]
  nums2 = [3, 4]
  The median is (2 + 3)/2 = 2.5*/


  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    if (len % 2 == 0) { //even thus avg of 2 mid elements
      return (getKth(len / 2 + 1, nums1, nums2, 0, 0)
          + getKth(len / 2, nums1, nums2, 0, 0)) / 2.0;
    } else {  //odd thus only mid element
      return getKth(len / 2 + 1, nums1, nums2, 0, 0);
    }
  }

  public static int getKth(int k, int[] na, int[] nb, int sa, int sb) {
    if (sa >= na.length)
      return nb[sb + k - 1];

    if (sb >= nb.length)
      return na[sa + k - 1];

    if (k == 1)
      return Math.min(na[sa], nb[sb]);

    int m1 = sa + k / 2 - 1;
    int m2 = sb + k / 2 - 1;

    int mid1 = m1 < na.length ? na[m1] : Integer.MAX_VALUE;
    int mid2 = m2 < nb.length ? nb[m2] : Integer.MAX_VALUE;

    if (mid1 < mid2) {
      return getKth(k - k / 2, na, nb, m1 + 1, sb);
    } else {
      return getKth(k - k / 2, na, nb, sa, m2 + 1);
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2};
    int[] nums2 = new int[]{3, 4};
    double res = findMedianSortedArrays(nums1, nums2);
    System.out.println(res);
  }
}
