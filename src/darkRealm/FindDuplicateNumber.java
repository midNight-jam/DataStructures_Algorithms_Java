package darkRealm;

import java.util.Arrays;

public class FindDuplicateNumber {

  /*  #287 Find the Duplicate Number
  * Given an array numbers containing n + 1 integers where each integer is between 1 and n (inclusive),
  * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
  * find the duplicate one.
  * Note:
  * You must not modify the array (assume the array is read only).
  * You must use only constant, O(1) extra space.
  * Your runtime complexity should be less than O(n2).
  * There is only one duplicate number in the array, but it could be repeated more than once.
  * */
  public static int duplicateNumber(int[] arr) {
    int slowPtr = 0;
    int fastPtr = 0;
    while (true) {
      if (fastPtr >= arr.length || slowPtr >= arr.length) {
        return 0;
      }
      slowPtr = arr[slowPtr];
      fastPtr = arr[arr[fastPtr]];
      if (slowPtr == fastPtr) {
        break;
      }
    }
    // calculate the length of the loop
    int trav = arr[slowPtr];
    int loopSize = 1;
    while (arr[trav] != arr[fastPtr]) {
      trav = arr[trav];
      loopSize++;
    }

    int aheadPtr = arr[0];
    for (int i = 1; i < loopSize; i++) {
      aheadPtr = arr[aheadPtr];
    }
    int behindPtr = 0;
    while (aheadPtr != behindPtr) {
      aheadPtr = arr[aheadPtr];
      behindPtr = arr[behindPtr];
    }
    return behindPtr;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{3, 1, 3, 4, 2};
//    int[] arr = new int[]{4,1,2,3,2};
//    int[] arr = new int[]{1,2,3,2};
    int res = duplicateNumber(arr);
    System.out.println("res  : " + res + "  " + Arrays.toString(arr));
  }
}
