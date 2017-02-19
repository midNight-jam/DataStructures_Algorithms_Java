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

  //
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
}