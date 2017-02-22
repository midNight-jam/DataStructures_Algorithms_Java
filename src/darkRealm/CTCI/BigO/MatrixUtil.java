package darkRealm.CTCI.BigO;

/**
 * Created by Jayam on 9/25/2016.
 */
public class MatrixUtil {

  public static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
    int[][] result = new int[0][0];
    int m1Rows = m1.length;
    int m1Columns = m1[0].length;
    int m2Rows = m2.length;
    int m2Columns = m2[0].length;

    if (m1Columns == m2Rows) {
      int resultRows = m1Rows;
      int resultColumns = m2Columns;
      result = new int[m1Rows][m2Columns];
      for (int i = 0; i < resultRows; i++) {
        for (int j = 0; j < resultColumns; j++) {
          for (int k = 0; k < m1Columns; k++) {
            result[i][j] += m1[i][k] * m2[k][j];
          }
        }
      }
    }
    return result;
  }

  public static int[][] transposeMatrix(int[][] mtx) {
    int rows = mtx.length;
    int columns = mtx[0].length;
    int[][] result = new int[columns][rows];

    for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows; j++) {
        result[i][j] = mtx[j][i];
      }
    }

    return result;
  }

  //inPlace, space O(1)
  public static int[][] transposeSquareMatrix(int[][] mtx) {
    int rows = mtx.length;
    int columns = mtx[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = i + i; j < columns; j++) {
        if (i != j) {
          mtx[i][j] = mtx[i][j] ^ mtx[j][i];
          mtx[j][i] = mtx[i][j] ^ mtx[j][i];
          mtx[i][j] = mtx[i][j] ^ mtx[j][i];
        }
      }
    }
    return mtx;
  }

  // Integers in each row are sorted from left to right.
  public static int searchRowSortedMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return Integer.MIN_VALUE;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int low = 0;
    int high = row * col - 1;
    int mid;
    while (low != high) {
      mid = (low + high - 1) / 2;
      if (matrix[mid / col][mid % col] < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return matrix[high / col][high % col] == target ? target : Integer.MIN_VALUE;
  }

  public static int searchSortedMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return Integer.MIN_VALUE;
    }
    int row = matrix.length - 1;
    int col = 0;

    while (row >= 0 && col < matrix[0].length) {
      if (matrix[row][col] > target) {
        row--;
      } else if (matrix[row][col] < target) {
        col++;
      } else {
        return matrix[row][col];
      }
    }
    return matrix[row][col] == target ? target : Integer.MIN_VALUE;
  }

  public static String getPrintableMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return "";
    int rows = matrix.length;
    int columns = matrix[0].length;
    StringBuffer string = new StringBuffer();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        string.append(" " + matrix[i][j]);
      }
      System.out.println("");
      string.append("\n");
    }
    return string.toString();
  }

  public static void rotateMatrixClockWise(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    int levels = matrix.length;
    int i = 0;
    int swapLevel = 0;
    while (i < (levels) / 2) {
      swapLevel = i;
      int temp;
      for (int j = swapLevel; j < levels - swapLevel - 1; j++) {
        temp = matrix[swapLevel][j];
        // left to top
        matrix[swapLevel][j] = matrix[levels - j - 1][swapLevel];
        // bottom to left
        matrix[levels - j - 1][swapLevel] = matrix[levels - swapLevel - 1][levels - j - 1];
        // right to bottom
        matrix[levels - swapLevel - 1][levels - j - 1] = matrix[j][levels - swapLevel - 1];
        // top to right
        matrix[j][levels - swapLevel - 1] = temp;
      }
      i++;
    }
  }

  public static void rotateMatrixAntiClockWise(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    int levels = matrix.length;
    int i = 0;
    int swapLevel;
    while (i < (levels) / 2) {
      swapLevel = i;
      int temp;
      for (int j = i; j < levels - swapLevel - 1; j++) {
        temp = matrix[swapLevel][j];
        //right to top
        matrix[swapLevel][j] = matrix[j][levels - swapLevel - 1];
        //bottom to right
        matrix[j][levels - swapLevel - 1] = matrix[levels - swapLevel - 1][levels - j - 1];
        //left to bottom
        matrix[levels - swapLevel - 1][levels - j - 1] = matrix[levels - j - 1][swapLevel];
        //top to left
        matrix[levels - j - 1][swapLevel] = temp;
      }
      i++;
    }
  }


  /*  [Prob 378] Kth Smallest Element in a Sorted Matrix
  *   Given a n x n matrix where each of the rows and columns are sorted in ascending order,
  *   find the kth smallest element in the matrix.
  *   Note that it is the kth smallest element in the sorted order, not the kth distinct element.
  *   Example:
  *   matrix = [
                 [ 1,  5,  9],
                 [10, 11, 13],
                 [12, 13, 15]
              ],
  *   k = 8,
  *   return 13.
  *   Note: You may assume k is always valid, 1 ≤ k ≤ n2.
  *
  *   A) we will use binary search, first using the left(left most) nad right (rightmost) number we will calculate a mid
  *   a mid not necesarrily in the matrix. now we will take each row, and will try to find the count of numbers that are
  *   smaller than mid and keep adding these small number count. Now after adding all these counts if the count is smaller
  *   than the asked Kth number then we serach in first half of matrix, else we search in the second half of the matrix.
  *   And this process continues.
  *   O(nlog(n)log(N)), n is the number of rows
  * */
  public static int kthSmallestSortedMatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || k > matrix.length * matrix.length) return 0;
    int n = matrix.length;
    int left = matrix[0][0];
    int right = matrix[n - 1][n - 1];

    while (left < right) {
      int mid = left + (right - left) / 2;
      int count = 0;
      for (int i = 0; i < n; i++) {
        int[] row = matrix[i];
        int pleft = 0, pright = n;
        while (pleft < pright) {
          int pmid = pleft + (pright - pleft) / 2;
          int val = row[pmid];
          if (val > mid) pright = pmid;
          else pleft = pmid + 1;
        }
        count += pleft;
      }

      if (count < k) left = mid + 1;
      else right = mid;
    }
    return left;
  }
}