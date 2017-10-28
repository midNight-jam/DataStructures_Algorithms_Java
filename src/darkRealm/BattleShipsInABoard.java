package darkRealm;

import java.util.Arrays;

public class BattleShipsInABoard {

//  #419. Battleships in a Board
//  Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are
//  represented with '.'s. You may assume the following rules:
//  You receive a valid board, made of only battleships or empty slots.
//  Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape
//  1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
//  At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
//  Example:
//  X..X
//  ...X
//  ...X
//  In the above board there are 2 battleships.
//  Invalid Example:
//      ...X
//      XXXX
//      ...X
//  This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
//  Follow up:
//  Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

  public static int countBattleships(char[][] board) {
    int count = 0;
    // The problems is to count to number of ships, as the input is going to be always valid the porblem boils down to
    // count the start of such ships, to capture the start of ship we capture if the given element is s ship 'X',
    // it should be the leftmost and topmost, if so then it is a start of the ship, and we increase the count.
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        if ((board[i][j] == 'X') && (j == 0 || board[i][j - 1] == '.') && (i == 0 || board[i - 1][j] == '.')) count++;
            // is a ship                  //(no left)                        // no top
    return count;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'X','.','.','X'},
        {'.','X','.','X'},
        {'.','X','.','X'},
    };
    for (char[] a : board)
      System.out.println(Arrays.toString(a));
    int c = countBattleships(board);
    System.out.println("S : " + c);
  }
}