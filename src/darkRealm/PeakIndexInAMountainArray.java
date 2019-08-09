package darkRealm;

import java.util.Arrays;

public class PeakIndexInAMountainArray {

//852. Peak Index in a Mountain Array
//  Let's call an array A a mountain if the following properties hold:
//  A.length >= 3
//  There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//  Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
//
//  Example 1:
//  Input: [0,1,0]
//  Output: 1
//  Example 2:
//  Input: [0,2,1,0]
//  Output: 1
//  Note:
//      3 <= A.length <= 10000
//      0 <= A[i] <= 10^6
//  A is a mountain, as defined above.

  public static int peakIndexInMountainArrayOLD(int[] A) {
    if (A == null || A.length < 3) return -1;

    int low = 0, high = A.length - 1;
    int mid = 0;

    while (low <= high) {
      mid = low + (high - low) / 2;

      if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1])
        return mid;

      if (mid < A.length - 1 && A[mid] > A[mid + 1]) {
        high = mid - 1;
      }

      if (mid > 0 && A[mid - 1] < A[mid]) {
        low = mid + 1;
      }
    }

    return mid;
  }

  public static int peakIndexInMountainArray(int[] A) {
    if (A == null || A.length < 2) return 0;
    int left = 0, right = A.length - 1;
    int mid;

    while (left <= right) {
      mid = left + (right - left) / 2;
      int lmid = mid > 0 ? A[mid - 1] : Integer.MIN_VALUE;
      int rmid = mid + 1 < A.length ? A[mid + 1] : Integer.MIN_VALUE;
      if (lmid < A[mid] && A[mid] > rmid) return mid;
      else if (lmid < A[mid]) left = mid + 1;
      else right = mid - 1;
    }

    return -1;
  }

  public static void test(int[] arr, int expected, int actual) {
    String p = expected == actual ? "Pass" : "Fail";
    String str = "[%s] expected : %d, actual : %d";
    System.out.println(String.format(str, p, expected, actual));
    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int res;
    int[] arr;
    arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
    res = peakIndexInMountainArray(arr);
    test(arr, res, 2);

    arr = new int[]{2, 4, 2};
    res = peakIndexInMountainArray(arr);
    test(arr, res, 1);

    arr = new int[]{2, 4};
    res = peakIndexInMountainArray(arr);
    test(arr, res, 1);

    arr = new int[]{2, 2, 2};
    res = peakIndexInMountainArray(arr);
    test(arr, res, -1);

    arr = new int[]{2, 1};
    res = peakIndexInMountainArray(arr);
    test(arr, res, 0);

    arr = new int[]{2};
    res = peakIndexInMountainArray(arr);
    test(arr, res, 0);

    arr = new int[0];
    res = peakIndexInMountainArray(arr);
    test(arr, res, 0);

    arr = new int[]{0, 2, 1, 0};
    res = peakIndexInMountainArray(arr);
    test(arr, res, 1);
  }
}
