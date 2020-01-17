package darkRealm;

import java.util.Arrays;

public class IslandPerimeter {
// 463. Island Perimeter
// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
// Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
// and there is exactly one island (i.e., one or more connected land cells).
// The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
// One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
// Determine the perimeter of the island.
//  Example:
//
//      [[0,1,0,0],
//      [1,1,1,0],
//      [0,1,0,0],
//      [1,1,0,0]]
//
//  Answer: 16

  public static int islandPerimeter(int[][] matrix) {
    if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int perimeter = 0;

    // starting from the top left, on any island look right & down
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (1 == matrix[i][j]) {
          perimeter += 4; // consider it is an isolated 1, thus will have 4 boundaries
          if (j < matrix[0].length - 1 && 1 == matrix[i][j + 1])
            perimeter -= 2;  // if there is a right neighbour, reduce 2 (one for self & one for nbor)
          if (i < matrix.length - 1 && 1 == matrix[i + 1][j])
            perimeter -= 2;  // if there is a down neighbour, reduce 2

        }
    return perimeter;
  }

  public int islandPerimeterBASIC(int[][] grid) {
    if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
    int pmt = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) continue;
        pmt += 4;
        // For every nbor reduce the perimeter
        if (i - 1 > -1 && grid[i - 1][j] == 1)
          pmt--;
        if (i + 1 < grid.length && grid[i + 1][j] == 1)
          pmt--;
        if (j - 1 > -1 && grid[i][j - 1] == 1)
          pmt--;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
          pmt--;
      }
    }
    return pmt;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {0, 1, 0, 0},
        {1, 1, 1, 0},
        {0, 1, 0, 0},
        {1, 1, 0, 0}
    };
    int res = islandPerimeter(matrix);
    System.out.println("Island : " + Arrays.toString(matrix));
    System.out.println("Perimeter : " + res);
  }
}
