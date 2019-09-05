package darkRealm;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

//  947. Most Stones Removed with Same Row or Column
//  On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
//  Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
//  What is the largest possible number of moves we can make?
//
//  Example 1:
//
//  Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//  Output: 5
//  Example 2:
//
//  Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//  Output: 3
//  Example 3:
//
//  Input: stones = [[0,0]]
//  Output: 0
//
//  Note:
//
//      1 <= stones.length <= 1000
//      0 <= stones[i][j] < 10000


  /*
   * This is a brilliant problem that took me 2 days to completely understand.
   * If we crack the crux the problem reduces to just count the number of dfs we have to fire.
   * The given inputs are the cordinates of the stones, pay attention we are not told how big the
   * grid is going to be or does it supports negative cordinates, so this init self is a hint that
   * dont go the grid rabbit hole of placing the stones on the grid, instead just use the cordinates.
   * as per the constrainsts we can remove the stone only if it has another stone on the same row or col.
   * This also points that the we cannot remove the last stone, as it will not have any neibor on the same
   * row/col because we would have already used it up.
   * This also lays the logical edge between the stones on the same row/col. Meaning this whole grid becomes a
   * graph in which stones on the same row/col are connected. After this problem reduces to capture all the
   * stones that we can reach after starting from a stone, but as we discussed we will not able to remove
   * the last stone in that connectedComponent/DFS, so we will be left with 1 stone after each traversal.
   * Thus the stones left at the end will the times of DFS we had to exceute and the score will be
   * Total Stones - DFS Count
   * */

  public static int removeStones(int[][] stones) {
    Set<int[]> visited = new HashSet();
    int dfsCount = 0;
    int totalStones = stones.length;
    for (int[] startStone : stones) {
      if (visited.contains(startStone)) continue;
      dfs(startStone, visited, stones);
      dfsCount++;
    }
    return totalStones - dfsCount;
  }

  private static void dfs(int[] sourceStone, Set<int[]> visited, int[][] stones) {
    visited.add(sourceStone);
    for (int[] nborStone : stones) {
      if (visited.contains(nborStone)) continue;
      // stone with same row or column. group them into island
      boolean actualNborOfSameRow = sourceStone[0] == nborStone[0];
      boolean actualNborOfSameCol = sourceStone[1] == nborStone[1];

      if (actualNborOfSameRow || actualNborOfSameCol)
        dfs(nborStone, visited, stones);
    }
  }

  public static void main(String[] args) {
    int[][] stones = new int[][]{
        {0, 0},
        {0, 1},
        {1, 0},
        {1, 2},
        {2, 1},
        {2, 2},
    };

    int res = removeStones(stones);
    System.out.println(res);
    System.out.println(res == 5 ? "Pass" : "Fail");
  }
}
