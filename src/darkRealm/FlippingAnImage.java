package darkRealm;

import java.util.Arrays;

/**
 * Created by Jayam on 1/13/2019.
 */
public class FlippingAnImage {


//  #832. Flipping an Image
//
//  Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//  To flip an image horizontally means that each row of the image is reversed.
//  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//  To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
//  For example, inverting [0, 1, 1] results in [1, 0, 0].
//
//  Example 1:
//  Input: [[1,1,0],[1,0,1],[0,0,0]]
//  Output: [[1,0,0],[0,1,0],[1,1,1]]
//  Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//  Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
//
//  Example 2:
//  Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//  Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//  Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
//  Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//
//  Notes:
//      1 <= A.length = A[0].length <= 20
//      0 <= A[i][j] <= 1

  public static int[][] flipAndInvertImage(int[][] A) {
    if (A == null || A.length < 1) return A;

    int i, j;
    for (int[] a : A) {
      i = 0;
      j = a.length - 1;
      while (i <= j) {
        // If the pixels are diff, then after reversing and inverting they would have same value, thus we can skip these pixels, as below
        // [1,1,0,0] ==> after reversing [0,0,1,1] ==> after inverting  ==> [1,1,0,0] (same values)
        // We only need to make a change if the image pixels are same, only then we would need to invert it.
        if (a[i] == a[j]) {
          if (a[i] == 0)
            a[i] = a[j] = 1;  //invert
          else
            a[i] = a[j] = 0;  //invert
        }
        i++;
        j--;
      }
    }

    return A;
  }

  public static void main(String[] args) {
    int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

    System.out.println("Input Image");
    for (int[] a : A)
      System.out.println(Arrays.toString(a));

    A = flipAndInvertImage(A);

    System.out.println("Flipped Image");
    for (int[] a : A)
      System.out.println(Arrays.toString(a));
  }
}
