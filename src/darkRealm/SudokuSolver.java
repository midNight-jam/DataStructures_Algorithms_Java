package darkRealm;

import java.util.Arrays;

public class SudokuSolver {

//  #37. Sudoku Solver  ::: Complexity  - Time : O(9^m), where m is the no of blank chars, Space : O(1)
//  Write a program to solve a Sudoku puzzle by filling the empty cells.
//  Empty cells are indicated by the character '.'.
//  You may assume that there will be only one unique solution.

  public static void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) return;
    solve(board);
  }

  public static boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') { // If its a blank char
          for (char c = '1'; c <= '9'; c++) {//try all from 1 to 9
            if (isValid(board, i, j, c)) {
              board[i][j] = c; //Put c for this cell

              if (solve(board))
                return true; //If it's the solution return true

              board[i][j] = '.'; //restore cell value (go back)
            }
          }
          return false; // If there was no solution for this blank char, return false, means we will have to backtrack
        }
      }
    }
    return true;  // finally return true
  }

  private static boolean isValid(char[][] board, int row, int col, char c) {
    int cellRow, cellCol;
    for (int i = 0; i < 9; i++) {
      if (board[i][col] != '.' && board[i][col] == c) return false;// char is already used on same col
      if (board[row][i] != '.' && board[row][i] == c) return false; // char is already used on same row
      // dividing by 3 and Xllying by 3 seems useless, but divinding / 3 round the integer to the first row.
      // for example i = 7, i/7 = 2 and 3 * 2 is 6, which gives us the start row & col for i = 7
      cellRow = 3 * (row / 3) + (i / 3);  // for i = 0, gets the start row of the 3x3 cell
      cellCol = 3 * (col / 3) + (i % 3);  // for i = 0, gets the start col of the 3x3 cell
      if (board[cellRow][cellCol] != '.' && board[cellRow][cellCol] == c)
        return false;  // char is already used in local cell 3x3
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '3', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '3', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '3', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };
    for (char[] c : board)
      System.out.println(Arrays.toString(c));

    System.out.println();

    solveSudoku(board);

    for (char[] c : board)
      System.out.println(Arrays.toString(c));

  }
}
