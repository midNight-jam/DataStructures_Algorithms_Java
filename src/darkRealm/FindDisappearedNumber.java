package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumber {


  /* [448] Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * */
  public static List<Integer> disappearedNumbers(int[] arr) {
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      index = Math.abs(arr[i]) - 1;
      if (arr[index] > 0) {
        arr[index] = -1 * arr[index];
      }
    }
    List<Integer> missingNos = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        missingNos.add(i + 1);
      }
    }
    return missingNos;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> res = disappearedNumbers(arr);
    System.out.println("res  : " + Arrays.toString(res.toArray()) + "  " + Arrays.toString(arr));
  }
}
