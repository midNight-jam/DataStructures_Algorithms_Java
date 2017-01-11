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
}