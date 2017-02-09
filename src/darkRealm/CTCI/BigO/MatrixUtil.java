package darkRealm.CTCI.BigO;


import darkRealm.CTCI.Sorting_and_Searching.BinarySearchUtil;

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
  public static int searchSortedMatrix(int[][] matrix, int target) {
    //if matrix is sorted... traverse with 1 row to determin which column will contain K
    // then binary search that column to find the K
    if(matrix==null||matrix.length==0){
      return -1;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    //first find the col in which K will be present by traversing 1st row
    int i;
    for (i = 0; i < cols; i++) {
      if (matrix[0][i] > target)
        break;
    }
    // if we reached end/ or we stood at 1st then element not in matrix
    if (i == cols || i == 0)
      return -1;

    //now we have the column in which it will be present

    int j;
    for (j = 0; j < rows; j++) {
      if (matrix[j][i - 1] == target) {
        System.out.println("element found at : " + j + " , " + (i - 1));
        return target;
      }
    }
    return -1;
  }

  /*[Prob 10.9]
  *   Q) Sorted Matrix Search : Given a M*N matrix in which each row & each column is sorted in ascending order, write
  *   a method to find an element
  *   A) The idea is very similar to binary search but rather than on one dimension like array we do it for 2 dimesion matrix
  *     First take low as top left corner, & high as bottom right corner. now take mid which will be any element in between
  *     the matrix. Compare this mid with k if k is greater than move in the upper half, if k is smaller than move in the
  *     lower half. We stop at a point where we have narowed down to 2 consecutive rows among which the element K shoud be
  *     present. However, we dont do a binary serach on whole rows, rather we benefit from fact that its sorted matrix
  *     and in first row we srach from low index to end. And in second row we search from start to high index
  * */
  public static int sortedMatrixSearch(int[][] mat, int k) {
    int lowX, lowY, highX, highY, midX, midY;
    lowX = lowY = 0;
    highX = mat.length;
    highY = mat[0].length;
    while (true) {  // till we have not found two rows within which our element should be
      midX = (lowX + highX) / 2;
      midY = (lowY + highY) / 2;

      if (mat[midX][midY] == k) {
        return mat[midX][midY]; // Lucky Case!!
      }
      if (Math.abs(lowX - highX) == 1) {
        break;  // the closest rows
      }

      if (k < mat[midX][midY]) {
        highX = midX;
        highY = midY;
      }
      if (k > mat[midX][midY]) {
        lowX = midX;
        lowY = midY;
      }
    }

    int resX = lowX;
    //binary search on lowX row, between LowY till end for searching K
    int resY = BinarySearchUtil.binarySearchRecursive(mat[lowX], k, lowY, mat[lowX].length - 1);
    //binary search on highX row, between start till highY for searching K
    if (resY == Integer.MIN_VALUE) {
      resX = highX;
      resY = BinarySearchUtil.binarySearchRecursive(mat[highX], k, 0, highY);
    }
    return resY == Integer.MIN_VALUE ? Integer.MIN_VALUE : mat[resX][resY];
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