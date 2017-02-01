package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 1/10/2017.
 */
public class BinarySearchUtil {

  public static int binarySearch(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int mid;
    while (low <= high) {
      mid = (low + (high-low)) / 2;
      if (k < arr[mid]) {
        high = mid - 1;
      } else if (arr[mid] < k) {
        low = mid + 1;
      } else {
//        System.out.println("Found : " + arr[mid]);
        return arr[mid];
      }
    }
    return Integer.MIN_VALUE;
  }

  public static int binarySearchRecursive(int arr[], int k, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      if(arr[mid]==k){
        System.out.println("Found  : " + arr[mid] + "  at " + mid);
        return mid;
      }
      else if (k < arr[mid]) {
        return binarySearchRecursive(arr, k, low, mid - 1);
      } else if (arr[mid] < k) {
        return binarySearchRecursive(arr, k, mid + 1, high);
      }
    }
    return Integer.MIN_VALUE;
  }
}