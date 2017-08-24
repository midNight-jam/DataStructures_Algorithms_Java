package darkRealm;

import java.util.Arrays;

public class ReshapeMatrix {
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