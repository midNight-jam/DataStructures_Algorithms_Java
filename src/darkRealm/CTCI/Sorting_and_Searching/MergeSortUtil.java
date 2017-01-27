package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 1/10/2017.
 */
public class MergeSortUtil {
  /* Complexity : O(NlogN), Space : O(N)
  * */
  public static int[] mergeSort(int[] arr) {
    int[] helper = new int[arr.length]; // a temp array for holding the intermediate results
    mergeSort(arr, helper, 0, arr.length - 1);  // fire mergesort with bounds
    return arr;
  }

  private static void mergeSort(int[] arr, int[] helper, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2; // find mid & fire fo both halves
      mergeSort(arr, helper, low, mid);
      mergeSort(arr, helper, mid + 1, high);
      merge(arr, helper, low, mid, high); // merge the reults which are eithin bounds
    }
  }

  private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
    // copy both halves in the helper array
    for (int i = low; i <= high; i++) {
      helper[i] = arr[i];
    }
    int current = low;  // initilize current with low
    int left = low;
    int right = mid + 1;  // the begining of the next half
    while (left <= mid && right <= high) {
      if (helper[left] < helper[right]) {
        arr[current] = helper[left];  // take from half & put in its correc position
        left++;
      } else {
        arr[current] = helper[right]; // take from half & put in its correc position
        right++;
      }
      current++;
    }

    while (left <= mid) { // if any thing is left put that in the next available places
      arr[current] = helper[left];
      left++;
      current++;
    }
  }
}