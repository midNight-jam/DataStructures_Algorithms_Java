package darkRealm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

//  #317. Shortest Distance from All Buildings
//  You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
//  You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//  Each 0 marks an empty land which you can pass by freely.
//  Each 1 marks a building which you cannot pass through.
//  Each 2 marks an obstacle which you cannot pass through.
//  For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
//      1 - 0 - 2 - 0 - 1
//      |   |   |   |   |
//      0 - 0 - 0 - 0 - 0
//      |   |   |   |   |
//      0 - 0 - 1 - 0 - 0
//  The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
//  So return 7.

  public static int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
    int minDist = Integer.MAX_VALUE;
    int[][] dist = new int[grid.length][grid[0].length];
    int[][] reached = new int[grid.length][grid[0].length];
    int buildingsCount = 0;

    // Rather than going to every "0" and bfs for every value, we do reverse, on every "1" we do bfs for "0"'s and keep
    // the dist adding for reached 0's and also the count for reached 0's. Count for that "0" tells us that by how many
    // "1"'s this 0 was reached and for us a valid "0" is the one who has this count equal to the number of buildings
    // For Such "0"'s get the minum dist

    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        if (grid[i][j] == 1) {
          Queue<int[]> que = new LinkedList<>();
          que.add(new int[]{i, j, 0});
          bfsBuildings(grid, que, dist, reached);
          buildingsCount++;
        }

    // get the minimum dist value
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        if (grid[i][j] == 0 && reached[i][j] == buildingsCount)
          minDist = Math.min(minDist, dist[i][j]);
    return minDist == Integer.MAX_VALUE ? -1 : minDist;
  }

  private static void bfsBuildings(int[][] grid, Queue<int[]> que, int[][] dist, int[][] reached) {
    int[] ver = new int[]{-1, 0, 1, 0};
    int[] hor = new int[]{0, 1, 0, -1};
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    while (!que.isEmpty()) {
      int[] dim = que.poll();
      int r = dim[0], c = dim[1], d = dim[2];
      for (int i = 0; i < ver.length; i++) {
        int nr = r + ver[i];
        int nc = c + hor[i];
        if (isValid(grid, nr, nc) && !visited[nr][nc] && grid[nr][nc] == 0) {
          dist[nr][nc] += d + 1;
          reached[nr][nc]++;
          visited[nr][nc] = true;
          que.add(new int[]{nr, nc, d + 1});
        }
      }
    }
  }

  private static boolean isValid(int[][] grid, int r, int c) {
    return r > -1 && r < grid.length && c > -1 && c < grid[0].length;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1, 0, 2, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
    };
//    int[][] grid = new int[][]{
//        {1, 0, 2},
//        {0, 0, 0},
//        {0, 0, 1},
//    };
    for (int[] r : grid)
      System.out.println(Arrays.toString(r));
    System.out.println("========================");
    int res = shortestDistance(grid);
    System.out.println("Res : " + res);
  }
}