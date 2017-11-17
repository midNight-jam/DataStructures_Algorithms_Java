package darkRealm;

public class NQueensII {

//  #52. N-Queens II
//  Follow up for N-Queens problem.
//  Now, instead outputting board configurations, return the total number of distinct solutions.

  private int count;
  public int totalNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board.length; j++)
        board[i][j] = '.';

    // Intuition is to place Queens for each col, if we reach the last col and have placed all queens that is one sol.
    solve(board, 0);
    return count;
  }

  public boolean solve(char[][] board, int colIndex) {
    if (board.length == colIndex) {
      count++;
      return true;
    }

    for (int i = 0; i < board.length; i++) {
      board[i][colIndex] = 'Q';
      if (isValid(board, i, colIndex))
        solve(board, colIndex + 1);
      board[i][colIndex] = '.';
    }
    return false;
  }

  public boolean isValid(char[][] board, int row, int col) {
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

  public static void main(String[] args) {

  }
}
