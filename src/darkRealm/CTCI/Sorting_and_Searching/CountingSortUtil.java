package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 2/1/2017.
 */
public class CountingSortUtil {
  public static int[] countingSort(int[] arr, int range) {
    int[] frequencyArr = new int[range];
    for (int i = 0; i < arr.length; i++) {
      frequencyArr[arr[i] - 1]++;
    }
    for (int i = 1; i < range; i++) {
      frequencyArr[i] = frequencyArr[i] + frequencyArr[i - 1];
    }
    int[] resultArr = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      resultArr[frequencyArr[arr[i] - 1] - 1] = arr[i];
      frequencyArr[arr[i] - 1]--;
    }
    return resultArr;
  }
}