package darkRealm;

import java.util.Arrays;

public class QuickSort {

  /*
  * Pick the partition, call quicksort for each partition
  * */
  public static void quickSort(int[] arr, int start, int end) {
    if (start >= end) return;
    int partition = partition(arr, start, end);
    quickSort(arr, start, partition - 1);
    quickSort(arr, partition + 1, end);
  }


  /*
   * Pick the pivot as the last element, swap all elements that are smaller than the pivot from the head of
   * the list. i.e by increasing the start. At the end move the element at start to last
   * & swap the pivot & start, return the start as the correct parition index.
   * */
  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    for (int i = start; i <= end; i++) {
      if (arr[i] < pivot) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        start++;
      }
    }

    int t = arr[start];
    arr[start] = pivot;
    arr[end] = t;
    return start;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 1, 2, 3, 3};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
