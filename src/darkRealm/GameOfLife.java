package darkRealm;

import java.util.Arrays;

public class GameOfLife {

  //  289. Game of Life
//  According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
//  by the British mathematician John Horton Conway in 1970."
//
//  Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its
//  eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//  Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//  Any live cell with two or three live neighbors lives on to the next generation.
//  Any live cell with more than three live neighbors dies, as if by over-population..
//  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//  Write a function to compute the next state (after one update) of the board given its current state.
//  The next state is created by applying the above rules simultaneously to every cell in the current state, where
//  births and deaths occur simultaneously.
//
//      Example:
//
//  Input:
//      [
//      [0,1,0],
//      [0,0,1],
//      [1,1,1],
//      [0,0,0]
//      ]
//  Output:
//      [
//      [0,0,0],
//      [1,0,1],
//      [0,1,1],
//      [0,1,0]
//      ]
//  Follow up:
//
//  Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some
//  cells first and then use their updated values to update other cells.
//  In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause
//  problems when the active area encroaches the border of the array. How would you address these problems?

  public static void gameOfLife(int[][] board) {
    if (board == null || board.length < 1) return;

    /*
    *  Intuition here is, as the input will always be 1 or 0, we have 31 extra bits to store extra information about
    *  the new state, but as the new state can also be just 1 or 0, using the 2 most left bit works for storing the
    *  information, one more thing to pay attention is as we will be updating the bits to keep the information about
    *  the new states, to get the old state we have to look the last bit i.e b[i][j] & 1
    *  Now either 0 can become 1, for this we mark it as 2 == "10" (new state alive , old state dead)
    *  or 1 can become 1, for this we mark it as 3 == "11" (new state alive , old state alive)
    *  & when we are done storing the second states for all of the board we delete the old states
    *  by right shifting & deleting the left most bit (old State)
    *  for the elements that dont get update like "0" & "1" on right shifting they all die automatically
    * */

    int m = board.length;
    int n = board[0].length;
    int oc ;
    int[] ver = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] hor = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        oc = 0;
        for (int k = 0; k < 8; k++) {
          int ni = i + ver[k];
          int nj = j + hor[k];
          if (ni >= 0 && nj >= 0 && ni < m && nj < n)
            oc += board[ni][nj] & 1; // take the first state
        }
        if (board[i][j] == 0 && oc == 3)
          board[i][j] = 2; // 10 in binary, new state is 1 (alive) old state was 0

        else if (board[i][j] == 1 && (oc == 2 || oc == 3))
          board[i][j] = 3; // 11 in binary, new state is 1 (alive) old state was also 1

      }
    }


    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        board[i][j] = board[i][j] >> 1; // move all elements from old state to new state
  }

  public static void main(String[] args) {
    int[][] board = new int[][]{
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0},
    };

    for (int[] b : board)
      System.out.println(Arrays.toString(b));

    gameOfLife(board);
    System.out.println("----------------------");
    for (int[] b : board)
      System.out.println(Arrays.toString(b));

  }
}
