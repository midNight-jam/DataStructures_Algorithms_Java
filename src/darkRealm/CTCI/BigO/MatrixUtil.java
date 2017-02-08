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

  //searches matrix sequentially
  public static int searchSortedMatrix(int[][] mtx, int k) {
    //if amtrix is sorted... traverse with 1 row to determin which column will contain K
    // then binary search that column to find the K

    int rows = mtx.length;
    int cols = mtx[0].length;

    //first find the col in which K will be present by traversing 1st row
    int i;
    for (i = 0; i < cols; i++) {
      if (mtx[0][i] > k)
        break;
    }
    // if we reached end/ or we stood at 1st then element not in matrix
    if (i == cols || i == 0)
      return -1;

    //now we have the column in which it will be present

    int j;
    for (j = 0; j < rows; j++) {
      if (mtx[j][i - 1] == k) {
        System.out.println("element found at : " + j + " , " + (i - 1));
        return k;
      }
    }
    return -1;
  }

  // searches matrix from bottom left corner
  public static boolean searchSortedMatrixOZ(int[][] mtx, int k) {
    int rows = mtx.length;
    int cols = mtx[0].length;
    int i = rows - 1;
    int j = 0;
    while (i >= 0 && j <= cols) {
      if (mtx[i][j] > k) {
        i--;
      } else if (mtx[i][j] < k) {
        j++;
      } else {
        System.out.println("Found at " + i + " , " + j);
        return true;
      }
    }
    System.out.println("Not Found at ");

    return false;
  }

  public static String getPrintableMatrix(int[][] m) {
    int rows = m.length;
    int columns = m[0].length;
    StringBuffer string = new StringBuffer();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        string.append(" " + m[i][j]);
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