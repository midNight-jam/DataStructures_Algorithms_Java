package darkRealm;

public class SurfaceAreaOf3DShapes {

//  892. Surface Area of 3D Shapes
//  On a N * N grid, we place some 1 * 1 * 1 cubes.
//  Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//  Return the total surface area of the resulting shapes.
//
//      Example 1:
//  Input: [[2]]
//  Output: 10
//
//  Example 2:
//  Input: [[1,2],[3,4]]
//  Output: 34
//
//  Example 3:
//  Input: [[1,0],[0,2]]
//  Output: 16
//
//  Example 4:
//  Input: [[1,1,1],[1,0,1],[1,1,1]]
//  Output: 32
//
//  Example 5:
//  Input: [[2,2,2],[2,1,2],[2,2,2]]
//  Output: 46

  public static int surfaceArea(int[][] grid) {
    int res = 0;
    if (grid == null || grid.length < 1 || grid[0].length < 1) return res;

    int[] hor = new int[]{0, 1, 0, -1};
    int[] ver = new int[]{1, 0, -1, 0};
    int temp, reduction;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) continue;
        temp = 4 * grid[i][j] + 2;
        for (int k = 0; k < hor.length; k++) {
          int ii = i + hor[k];
          int jj = j + ver[k];

          if (isAdjacent(grid, ii, jj)) {
            reduction = grid[ii][jj] > grid[i][j] ? grid[i][j] : grid[ii][jj];
            temp -= reduction;
          }
        }
        res += temp;
      }
    }
    return res;
  }

  private static boolean isAdjacent(int[][] grid, int ii, int jj) {
    return !(ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || grid[ii][jj] < 1);
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{{1, 2}};
    int res = surfaceArea(grid);
    System.out.println(res);
  }
}
