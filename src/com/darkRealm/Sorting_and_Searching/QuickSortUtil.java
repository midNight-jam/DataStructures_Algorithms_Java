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
    // but as we move right we have skipped the elements to the left thus recude the count of k
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

  public static int findKthSmallestElementInLinearTime(int[] arr, int low, int high, int k) {
    //Divide arr[] into ⌈n/5rceil; groups where size of each group is 5
    //except possibly the last group which may have less  than 5 elements

//    2) Sort the above created ⌈n/5⌉ groups and find median
//    of all groups. Create an auxiliary array 'median[]' and store medians
//    of all ⌈n/5⌉ groups in this median array.

    int[] median = new int[(int) Math.ceil(arr.length / 5)];
    int prev = 0;
    int i = 1;
    for (; i * 5 < arr.length; i++) {
      prev = 5 * (i - 1);
      median[i] = median(arr, prev, i * 5);
    }
    median[i] = median(arr, prev, arr.length - 1);

    // Find median of all medians using recursive call.
    // If median[] has only one element, then no need
    // of recursive call
    int medOfMedian = (i == 1) ? median[i - 1] : kthSmallestElement(median, 0, i - 1, i / 2);
    int pos = partition(arr, low, high, medOfMedian);
    if (pos - 1 == k - 1) {
      return arr[pos];
    }
    if (pos - low > k - low) {
      return kthSmallestElement(arr, low, pos - 1, k);
    }
    return kthSmallestElement(arr, pos + 1, high, k - pos + low - 1);
  }

  // it searches the array for x and partition the array around that
  private static int partition(int[] arr, int low, int high, int x) {
    int i = low;
    for (; low <= high; low++) {
      if (arr[i] == x) {
        break;
      }
    }
    // swap high & low
    int temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;

    for (int j = low; j <= high - 1; j++) {
      if (arr[j] <= x) {
        int temp2 = arr[low];
        arr[low] = arr[high];
        arr[high] = temp2;
        i++;
      }
    }
    int temp2 = arr[low];
    arr[low] = arr[high];
    arr[high] = temp2;
    return low;
  }

  private static int median(int[] arr, int start, int end) {
    arr = quicksort(arr,start,end);
    int size = end-start +1;
    if((size& 1) !=0){
      return arr[start + (size/2)];
    }
    else{
      return (arr[size/2] + arr[(size/2)+1])/2;
    }
  }
}