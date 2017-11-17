package darkRealm;

import java.util.Arrays;

public class WordSearch {

//  #79. Word Search  :::   Complexity - Time : O(n*m), Space : O(1) no extra space
//  Given a 2D board and a word, find if the word exists in the grid.
//  The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
//  horizontally or vertically neighboring. The same letter cell may not be used more than once.
//  For example,
//  Given board =
//    [
//    ['A','B','C','E'],
//    ['S','F','C','S'],
//    ['A','D','E','E']
//    ]
//  word = "ABCCED", -> returns true,
//  word = "SEE", -> returns true,
//  word = "ABCB", -> returns false.

  public static boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        if (board[i][j] == word.charAt(0) && helper(board, i, j, word))
          return true;
    return false;
  }

  private static boolean helper(char[][] board, int i, int j, String w) {
    if (w.length() == 0) return true;
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] != w.charAt(0))
      return false;
    char val = board[i][j];
    board[i][j] = '#';
    boolean res = helper(board, i + 1, j, w.substring(1)) ||
        helper(board, i - 1, j, w.substring(1)) ||
        helper(board, i, j + 1, w.substring(1)) ||
        helper(board, i, j - 1, w.substring(1));
    board[i][j] = val;
    return res;
  }


  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
//    String word = "ABCCED";
//    String word = "SEE";
    String word = "ABCB";
    boolean res = exist(board, word);
    for (char[] c : board)
      System.out.println(Arrays.toString(c));
    System.out.println("R : " + res);
  }
}
