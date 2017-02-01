package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 2/1/2017.
 */
public class InsertionSortUtil {
  public static void insertionSort(int[] arr) {
    int val;
    for (int i = 1; i < arr.length; i++) {
      val = arr[i];
      int j = i;
      while (j >= 1 && arr[j - 1] > val) {
        arr[j] = arr[j - 1];
        j--;
      }
      arr[j] = val;
    }
  }
}