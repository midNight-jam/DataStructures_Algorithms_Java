package darkRealm;

public class BombEnemy {
//  #361. Bomb Enemy
//  Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum
//  enemies you can kill using one bomb.
//  The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the
//  wall is too strong to be destroyed.
//  Note that you can only put the bomb at an empty cell.
//  Example:
//  For the given grid
//  0 E 0 0
//  E 0 W E
//  0 E 0 0
//  return 3. (Placing a bomb at (1,1) kills 3 enemies)

  public static int maxKilledEnemies(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int rowKills = 0;
    int[] colKills = new int[grid[0].length];
    int res = 0;
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 'W') continue;

        //count the hits for this row till next wall
        if (j == 0 || grid[i][j - 1] == 'W') {
          rowKills = 0;
          for (int c = j; c < n && grid[i][c] != 'W'; c++)
            if (grid[i][c] == 'E') rowKills++;
        }

        //count the hits for this col till next wall
        if (i == 0 || grid[i - 1][j] == 'W') {
          colKills[j] = 0;
          for (int r = i; r < m && grid[r][j] != 'W'; r++)
            if (grid[r][j] == 'E') colKills[j]++;
        }
        if (grid[i][j] == '0')
          res = Math.max(res, rowKills + colKills[j]); // if its a spot for bomb get the kill count
      }
    }
    return res;
  }

  public static void main(String[] args) {
    char[][] grid = new char[][]{
        {'0', 'E', '0', '0'},
        {'E', '0', 'W', 'E'},
        {'0', 'E', '0', '0'}
    };
//    char[][] grid = new char[][]{
//        {'E'},
//        {'E'},
//        {'E'}
//    };
    int res = maxKilledEnemies(grid);
    System.out.println("RES : " + res);
  }
}