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
  
  
  // Override all the islands with water when performing the dfs, count the no of fired dfs
  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
    int res = 0;
    for (int i = 0; i < grid.length; i++) 
      for (int j = 0; j < grid[0].length; j++) 
        if (grid[i][j] == '1') {
          res++;
          dfsHelper(grid, i, j);
        }

    return res;
  }
  
  private static void dfsHelper(char[][]grid, int r, int c){
    if (grid[r][c] == '0') return;
    grid[r][c] = '0'; // override the land with water
    int[] rows = new int[]{-1, 0, 1, 0};
    int[] cols = new int[]{0, 1, 0, -1};
    for (int i = 0; i < 4; i++) 
      if (isValid(r + rows[i], c + cols[i], grid) && grid[r + rows[i]][c + cols[i]] == '1') {
        dfsHelper(grid, r + rows[i], c + cols[i]);
      }
  }
  
  private static boolean isValid(int nr, int nc, char[][] grid) {
    return !(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length);
  }

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
