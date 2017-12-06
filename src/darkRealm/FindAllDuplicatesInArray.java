package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInArray {


  /* #442 Find All Duplicates in an Array
  * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
  * Find all the elements that appear twice in this array.
  * Could you do it without extra space and in O(n) runtime?
  * Reuse the same array to mark that a number has appeared once by mulitplying it with -1. And when we encounter a -ve
  * no we know that its index is duplicate.
  * */

  public static List<Integer> findDuplicates(int[] arr) {
    List<Integer> dups = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[Math.abs(arr[i]) - 1] < 0) {
        dups.add(Math.abs(arr[i]));
        continue;
      }
      arr[Math.abs(arr[i]) - 1] = -1 * arr[Math.abs(arr[i]) - 1];
    }
    return dups;
  }


  public static void main(String[] args) {
    //    int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    int[] arr = new int[]{4, 3, 2, 5, 6, 1, 3, 4, 5};
    List<Integer> res = findDuplicates(arr);
    System.out.println("res  : " + Arrays.toString(res.toArray()) + "  " + Arrays.toString(arr));

  }
}
