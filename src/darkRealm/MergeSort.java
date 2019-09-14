package darkRealm;

import java.util.Arrays;

public class MergeSort {

  public static int[] mergesort(int[] arr) {
    if (arr == null || arr.length < 2) return arr;
    return mergesortHelper(arr);
  }

  private static int[] mergesortHelper(int[] arr) {
    if (arr.length <= 1) return arr;
    int N = arr.length;
    int[] first = new int[N / 2];
    int[] second = new int[N - (N / 2)];
    for (int i = 0; i < first.length; i++)
      first[i] = arr[i];
    for (int i = 0; i < second.length; i++)
      second[i] = arr[N / 2 + i];

    return merge(mergesortHelper(first), mergesortHelper(second));
  }

  private static int[] merge(int[] arr, int[] brr) {
    int[] res = new int[arr.length + brr.length];
    int index = 0;
    int ai = 0, bi = 0;

    while (index < res.length) {
      int a = ai < arr.length ? arr[ai] : Integer.MAX_VALUE;
      int b = bi < brr.length ? brr[bi] : Integer.MAX_VALUE;
      if (a < b) {
        res[index++] = a;
        ai++;
      } else {
        res[index++] = b;
        bi++;
      }
    }

    return res;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{2, 7, 1};
//    int[] arr = new int[]{2};
//    int[] arr = new int[]{};
//    int[] arr = new int[]{5,5,0,0,1,1};
//    int[] arr = new int[]{5,0,0,1,1};
//    int[] arr = new int[]{5,0,1,1};
//    int[] arr = new int[]{5,0,1};
//    int[] arr = new int[]{5,0,-1};
    int[] arr = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
//    int[] arr = new int[]{Integer.MIN_VALUE,0,-1};
    System.out.println(Arrays.toString(arr));
    arr = mergesort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
