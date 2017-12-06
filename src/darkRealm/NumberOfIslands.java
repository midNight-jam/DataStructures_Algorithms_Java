package darkRealm;

import java.util.Arrays;

public class NumberOfIslands {



  /*
    #200 Number of Islands
   *   Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
   *   and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
   *   are all surrounded by water.
   *   Example 1:
   *   11110
   *   11010
   *   11000
   *   00000
   *   Answer: 1
   *
   *   Example 2:
   *   11000
   *   11000
   *   00100
   *   00011
   *   Answer: 3
   * */

  public static int numberOfIslands(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int islands = 0;
    _ROW = matrix.length;
    _COL = matrix[0].length;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1 && !visited[i][j]) {
          DFS(matrix, i, j, visited);
          ++islands;
        }
      }
    }
    return islands;
  }

  static int _ROW, _COL;

  private static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited) {
    boolean isSafe = (row > -1 && row < _ROW) && (col > -1 && col < _COL) && matrix[row][col] == 1 && !visited[row][col];
    return isSafe;
  }

  private static void DFS(int[][] matrix, int row, int col, boolean[][] visited) {
    // neighbours : top left, top, top right, right, bottom right, bottom, bottom left, left
    int[] rowNeighbours = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] colNeighbours = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    visited[row][col] = true;
    int eRow, eCol;

    for (int i = 0; i < rowNeighbours.length; i++) {
      eRow = row + rowNeighbours[i];
      eCol = col + colNeighbours[i];
      if (isSafe(matrix, eRow, eCol, visited)) {
        DFS(matrix, row + rowNeighbours[i], col + colNeighbours[i], visited);
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    };
    int islands = numberOfIslands(matrix);
    System.out.println(" Islands : " + islands);
    for(int[] m : matrix)
      System.out.println(Arrays.toString(m));
  }
}
