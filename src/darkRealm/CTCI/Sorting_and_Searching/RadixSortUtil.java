package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 2/1/2017.
 */
public class RadixSortUtil {

  /* k is the most nuumber of digits in the array*/
  public static int[] radixSort(int[] arr, int k) {
    int powerTen = 10;
    for (int i = 0; i < k; i++) {
      // as we are sorting by digits, the range for digits is always 10 (0-9)
      arr = modifiedCountingSort(arr, 10, powerTen);
      powerTen *= 10;
    }
    return arr;
  }

  public static int[] modifiedCountingSort(int[] arr, int range, int powerTen) {
    int[] frequencyArr = new int[range];
    int digit = 0;
    for (int i = 0; i < arr.length; i++) {
      digit = arr[i] % powerTen;
      digit = digit / (powerTen / 10);
      frequencyArr[digit]++;
    }
    for (int i = 1; i < range; i++) {
      frequencyArr[i] = frequencyArr[i] + frequencyArr[i - 1];
    }
    int[] resultArr = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      digit = arr[i] % powerTen;
      digit = digit / (powerTen / 10);
      resultArr[frequencyArr[digit] - 1] = arr[i];
      frequencyArr[digit]--;
    }
    return resultArr;
  }
}