package darkRealm;

import java.util.Arrays;

/**
 * Created by Jayam on 4/1/2017.
 */
public class RemoveDuplicatesFromArray {

  public static int removeDuplicatesFromArray(int[] arr) {
    if (arr.length < 2) return arr.length;
    int index = 1;
    for (int i = 1; i < arr.length; i++)
      if (arr[i] != arr[i - 1])
        arr[index++] = arr[i];
    return index;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 2};
    int res = removeDuplicatesFromArray(arr);
    System.out.println(Arrays.toString(arr) + "  :  " + res);
  }
}