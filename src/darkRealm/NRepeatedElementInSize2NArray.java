package darkRealm;

import java.util.Arrays;

public class NRepeatedElementInSize2NArray {

  public static int repeatedNTimes(int[] A) {
    if (A == null || A.length < 1) return Integer.MAX_VALUE;
    int first, second, third;
    first = second = third = Integer.MAX_VALUE;
    // If a number is repeated more than N times in a 2N array then in worst case it can be 2 indexes apart like 1231
    for (int i = 0; i < A.length; i++) {
      // look back the last 3 values
      if (A[i] == first || A[i] == second || A[i] == third) return A[i];

      first = second;
      second = third;
      third = A[i];
    }
    return Integer.MAX_VALUE;
  }

  public static void main(String[] args) {
    int[] A = new int[]{1, 2, 3, 1};
    int res = repeatedNTimes(A);
    System.out.println(Arrays.toString(A));
    System.out.println("res : " + res);
  }
}
