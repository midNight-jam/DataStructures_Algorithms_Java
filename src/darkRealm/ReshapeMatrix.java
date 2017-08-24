package darkRealm;

import java.util.Arrays;

public class ReshapeMatrix {
//  In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
//
//      You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
//
//  The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
//
//  If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
//
//  Example 1:
//  Input:
//  nums =
//      [[1,2],
//      [3,4]]
//  r = 1, c = 4
//  Output:
//      [[1,2,3,4]]
//  Explanation:
//  The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by usin

  public static int[][] reshapeMatrix(int[][] matrix, int r, int c) {
    if (null == matrix || 0 == matrix.length || 0 == matrix[0].length || r < 1 || c < 1 || matrix.length * matrix[0].length != r * c)
      return matrix;
    int[][] res = new int[r][c];
    int oldColumn = matrix[0].length;
    for (int i = 0; i < r * c; i++)
      res[i / c][i % c] = matrix[i / oldColumn][i % oldColumn];
    return res;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
    for (int i = 0; i < matrix.length; i++)
      System.out.println(Arrays.toString(matrix[i]));

    matrix = reshapeMatrix(matrix, 4, 2);

    for (int i = 0; i < matrix.length; i++)
      System.out.println(Arrays.toString(matrix[i]));
  }
}