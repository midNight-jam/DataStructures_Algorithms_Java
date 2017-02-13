package darkRealm.CTCI.Sorting_and_Searching;

import java.util.Random;

/**
 * Created by Jayam on 1/10/2017.
 */
public class QuickSortUtil {
  public static void quicksort(int[] arr, int low, int high) {

    int partition = findPivot(arr, low, high);
    if (low < partition - 1)
      quicksort(arr, low, partition - 1);
    if (partition < high)
      quicksort(arr, partition, high);
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
    int pos = findModifiedPivot(arr, low, high);
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

  public static int kthLargestElement(int[] nums, int low, int high, int k) {
    if (k < 1 || nums == null) {
      return 0;
    }

    return getKth(nums.length - k +1, nums, 0, nums.length - 1);
  }

  private static int getKth(int k, int[] nums, int start, int end) {

    int pivot = nums[end];

    int left = start;
    int right = end;

    while (true) {

      while (nums[left] < pivot && left < right) {
        left++;
      }

      while (nums[right] >= pivot && right > left) {
        right--;
      }

      if (left == right) {
        break;
      }

      swap(nums, left, right);
    }

    swap(nums, left, end);

    if (k == left + 1) {
      return pivot;
    } else if (k < left + 1) {
      return getKth(k, nums, start, left - 1);
    } else {
      return getKth(k, nums, left + 1, end);
    }
  }

  private static void swap(int[] nums, int n1, int n2) {
    int tmp = nums[n1];
    nums[n1] = nums[n2];
    nums[n2] = tmp;
  }


  private static int findModifiedPivot(int[] arr, int low, int high) {
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

  public static int[] randomizedQuickSort(int[] arr, int low, int high) {
    int pivot = randomPartition(arr, low, high);
    if (low < pivot - 1) {
      randomizedQuickSort(arr, low, pivot - 1);
    }
    if (pivot < high) {
      randomPartition(arr, pivot, high);
    }
    return arr;
  }

  private static int randomPartition(int[] arr, int low, int high) {
    Random rand = new Random();
    int randIndex = low + rand.nextInt(high - low);
    int temp = arr[randIndex];
    arr[randIndex] = arr[low];
    arr[low] = temp;
    return findPivot(arr, low, high);
  }
}