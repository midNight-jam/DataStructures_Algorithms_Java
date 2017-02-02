package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 2/1/2017.
 */
public class RadixSortUtil {

  public static int[] radixSort(int[] arr, int k) {
    int powerTen = 10;
    int belowPower = 1;
    for (int i = 0; i < k; i++) {
      arr = modifiedCountingSort(arr, 10, powerTen, belowPower);
      belowPower = powerTen;
      powerTen *= 10;
    }
    return arr;
  }

  public static int[] modifiedCountingSort(int[] arr, int range, int powerTen, int belowPower) {
    int[] frequencyArr = new int[range];
    int digit = 0;
    for (int i = 0; i < arr.length; i++) {
      digit = arr[i] % powerTen;
      digit = digit / belowPower;
      frequencyArr[digit]++;
    }
    for (int i = 1; i < range; i++) {
      frequencyArr[i] = frequencyArr[i] + frequencyArr[i - 1];
    }
    int[] resultArr = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      digit = arr[i] % powerTen;
      digit = digit / belowPower;
      resultArr[frequencyArr[digit] - 1] = arr[i];
      frequencyArr[digit]--;
    }
    return resultArr;
  }
}