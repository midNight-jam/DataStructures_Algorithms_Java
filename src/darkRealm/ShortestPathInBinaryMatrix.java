package darkRealm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

//  1091. Shortest Path in Binary Matrix
//  In an N by N square grid, each cell is either empty (0) or blocked (1).
//  A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
//
//  Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
//  C_1 is at location (0, 0) (ie. has value grid[0][0])
//  C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
//  If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
//  Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
//
//  Example 1:
//
//  Input: [[0,1],[1,0]]
//  Output: 2
//
//  Example 2:
//
//  Input: [[0,0,0],[1,1,0],[1,1,0]]
//  Output: 4
//
//  Note:
//      1 <= grid.length == grid[0].length <= 100
//  grid[r][c] is 0 or 1

  public static int shortestPathBinaryMatrix(int[][] grid) {
    if (grid == null || grid.length < 1 || grid[0].length < 1) return -1;
    int M = grid.length;
    int N = grid[0].length;
    if(M != N || grid[0][0] == 1 || grid[M -1][N-1] == 1) return -1;

    int[][] dists = new int[M][N];
    for (int[] d : dists)
      Arrays.fill(d, Integer.MAX_VALUE);

    int[][] dirs = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    Queue<int[]> que = new LinkedList<>();
    que.offer(new int[]{0, 0, 1});

    int nr, nc;
    while (que.size() > 0) {
      int p = que.size();
      while (p-- > 0) {
        int[] v = que.poll();
        int r = v[0];
        int c = v[1];
        int d = v[2];
        if (d >= dists[r][c])
          continue;

        dists[r][c] = d; // update the dist

        for (int di = 0; di < 8; di++) {
          nr = r + dirs[di][0];
          nc = c + dirs[di][1];
          if (!valid(nr, nc, grid)) continue;
          que.offer(new int[]{nr, nc, d + 1});
        }
      }
    }

    for (int[] d : dists)
      System.out.println(Arrays.toString(d));

    return dists[M - 1][N - 1] == Integer.MAX_VALUE ? -1 : dists[M - 1][N - 1];
  }

  static boolean valid(int r, int c, int[][] grid) {
    return !(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1);
  }

  public static void main(String[] args) {

//    int[][] grid = new int[][]{
//        {0, 1},
//        {1, 0},
//    };
//    int res = shortestPathBinaryMatrix(grid);
//    System.out.println(res);
//    System.out.println(res == 2 ? "Pass" : "Fail");

//    int[][] grid = new int[][]{
//        {0, 0, 0},
//        {1, 1, 0},
//        {1, 1, 0},
//    };
//    int res = shortestPathBinaryMatrix(grid);
//    System.out.println(res);
//    System.out.println(res == 4 ? "Pass" : "Fail");

//    int[][] grid = new int[][]{
//        {0, 0, 0},
//        {1, 1, 0},
//        {1, 1, 1},
//    };
//    int res = shortestPathBinaryMatrix(grid);
//    System.out.println(res);
//    System.out.println(res == -1 ? "Pass" : "Fail");


//    int[][] grid = new int[][]{
//        {0, 1, 1, 1, 0, 1, 0},
//        {1, 0, 1, 0, 1, 0, 0},
//        {1, 1, 0, 1, 0, 1, 0},
//        {1, 0, 1, 1, 0, 1, 0},
//        {0, 1, 1, 1, 0, 1, 0},
//        {1, 0, 1, 0, 0, 1, 0},
//        {1, 1, 0, 1, 0, 1, 0},
//    };
//    int res = shortestPathBinaryMatrix(grid);
//    System.out.println(res);
//    System.out.println(res == 11 ? "Pass" : "Fail");

    int[][] grid = new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {1, 1, 0},
    };
    int res = shortestPathBinaryMatrix(grid);
    System.out.println(res);
    System.out.println(res == -1 ? "Pass" : "Fail");


  }
}
