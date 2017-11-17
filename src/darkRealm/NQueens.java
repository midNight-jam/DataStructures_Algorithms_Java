package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

//  #51. N-Queens ::: Complexity  - Time  : O(?)
//  The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//  Given an integer n, return all distinct solutions to the n-queens puzzle.
//  Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
//  queen and an empty space respectively.
//  For example,gd

//  There exist two distinct solutions to the 4-queens puzzle:
//      [
//      [".Q..",  // Solution 1
//      "...Q",
//      "Q...",
//      "..Q."],
//      ["..Q.",  // Solution 2
//      "Q...",
//      "...Q",
//      ".Q.."]
//      ]

  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board.length; j++)
        board[i][j] = '.';

    // Intuition is to place Queens for each col, if we reach the last col and have placed all queens that is one sol.
    solve(board, 0, res);
    return res;
  }

  public static boolean solve(char[][] board, int colIndex, List<List<String>> res) {
    if (board.length == colIndex) {
      res.add(getBoard(board));
      return true;
    }

    for (int i = 0; i < board.length; i++) {
      board[i][colIndex] = 'Q';
      if (isValid(board, i, colIndex))
        solve(board, colIndex + 1, res);
      board[i][colIndex] = '.';
    }
    return false;
  }

  public static boolean isValid(char[][] board, int row, int col) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < col; j++) {
        boolean alreadyPlaced = board[i][j] == 'Q';
        boolean sameRow = i == row; // AlreadyPlaced on this row
        //  Diagonal Check
        // row + col == i + j
        // Ex (row,col) = (0,1) and (i,j) = (1,0) , then row + col => 0 + 1 => 1 and i + j => 1 + 0 => 1
        // row + j == col + i
        // Ex (row,col) = (0,0) and (i,j) = (2,2) , then row + j => 0 + 2 => 2 and col + i => 0 + 2 => 2
        boolean diagonalPresent = row + col == i + j || row + j == col + i;
        if (alreadyPlaced && (sameRow || diagonalPresent)) return false;
      }
    }
    return true;
  }

  private static List<String> getBoard(char[][] board) {
    System.out.println();
    List<String> r = new ArrayList<>();
    for (char[] b : board) {
      String s = new String(b);
      r.add(s);
    }
    return r;
  }

  public static void main(String[] args) {
    int n = 4;
    List<List<String>> res = solveNQueens(n);
    for (List<String> r : res)
      for (String s : r)
        System.out.println(s);
  }
}
