package com.darkRealm.Sorting_and_Searching;

/**
 * Created by Jayam on 1/10/2017.
 */
public class QuickSortUtil {
  public static int[] quicksort(int[] arr, int low, int high) {

    int partition = findPivot(arr, low, high);
    if (low < partition - 1)
      quicksort(arr, low, partition - 1);
    if (partition < high)
      quicksort(arr, partition, high);
    return arr;
  }

  private static int findPivot(int[] arr, int low, int high) {
    int pivot = arr[(low + high) / 2];
    while (low <= high) {
      while (arr[low] < pivot) {
        low++;
      }
      while (pivot < arr[high]) {
        high--;
      }
      if (low <= high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        low++;
        high--;
      }
    }
    return low;
  }

  public static int kthSmallestElement(int[] arr, int low, int high, int k) {
    int pos = findModifiedPivot(arr, low, high, k);
    if (pos - 1 == k - 1) {
      return arr[pos];
    }
    // if postion is more we will find the kt samllest on further left, thus recur in left
    if (pos - 1 > k - 1) {
      return kthSmallestElement(arr, low, pos - 1, k);
    }
    // if postion is less we will find the kt samllest on further right , thus recur in right
    else {
      return kthSmallestElement(arr, pos, high, k);
    }
  }

  private static int findModifiedPivot(int[] arr, int low, int high, int k) {
    int pivot = arr[(low + high) / 2];
    while (low <= high) {
      while (arr[low] < pivot) {
        low++;
      }
      while (pivot < arr[high]) {
        high--;
      }
      if (low <= high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        low++;
        high--;
      }
    }
    return low;
  }
}