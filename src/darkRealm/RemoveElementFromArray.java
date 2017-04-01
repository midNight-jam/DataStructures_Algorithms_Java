package darkRealm;

import java.util.Arrays;

/**
 * Created by Jayam on 4/1/2017.
 */
public class RemoveElementFromArray {
  public static int removeDuplicatesFromArray(int[] arr, int val) {
    if (arr.length < 2) return arr.length;
    int index = 0;
    for (int i = 0; i < arr.length; i++)
      if (arr[i] != val)
        arr[index++] = arr[i];
    return index;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{3,2,2,3};
    int val= 3;
    int res = removeDuplicatesFromArray(arr,val);
    System.out.println(Arrays.toString(arr) + "  :  " + res);
  }
}
