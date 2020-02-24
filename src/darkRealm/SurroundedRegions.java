package darkRealm;

import java.util.*;

public class SurroundedRegions {


  /*  130. Surrounded Regions
   * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
   * A region is captured by flipping all 'O's into 'X's in that surrounded region.
   * For example,
   * X X X X
   * X O O X
   * X X O X
   * X O X X
   * After running your function, the board should be:
   * X X X X
   * X X X X
   * X X X X
   * X O X X
   * */



  public static void solve(char[][] board) {
    if(board == null || board.length < 1 || board[0].length < 1) return;

    // The idea is to find all the 'O' that are attached to border, becuase these are the ones that cannot be
    // surrounded, thus we first find such 'O' mark them as 'Y', then we mark all the 'O' to 'X' as these are the
    // ones that are completely surrounded by the 'X'. In last step we restore the 'Y' to 'O', meaning the 'O' that
    // coulndt be surrounded

    // first row
    for(int j = 0; j < board[0].length; j++)
      if(board[0][j] == 'O'){
        dfs(board, 0, j);
      }

    // first col
    for(int i = 0; i < board.length; i++)
      if(board[i][0] == 'O'){
        dfs(board, i, 0);
      }

    // last col
    for(int i = 0; i < board.length; i++)
      if(board[i][board[0].length - 1] == 'O'){
        dfs(board, i, board[0].length - 1);
      }


    // last col
    for(int j = 0; j < board[0].length; j++)
      if(board[board.length - 1][j] == 'O'){
        dfs(board, board.length - 1, j);
      }


    // Mark all the remaining 'O' as 'X', these are the 'O' that are not ata the border & thus will be surrounded fully
    for(int i = 0; i < board.length; i++)
      for(int j = 0; j < board[0].length; j++)
        if(board[i][j] == 'O')
          board[i][j] = 'X';


    // Restore all the 'Y' to 'O', as we want surround the 'O' attached to the border
    for(int i = 0; i < board.length; i++)
      for(int j = 0; j < board[0].length; j++)
        if(board[i][j] == 'Y')
          board[i][j] = 'O';
  }

  private static void dfs(char[][] board, int r, int c){
    board[r][c]='Y'; // Change the 'O' to 'Y'
    int[] hor = new int[]{-1, 0, 1, 0};
    int[] ver = new int[]{0, 1, 0, -1};
    for(int i = 0; i < 4; i++){
      int rr = r + hor[i];
      int cc = c + ver[i];
      if(rr < 0 || rr >= board.length || cc < 0 || cc >= board[0].length || board[rr][cc] != 'O')
        continue;
      dfs(board, rr, cc); // move to the next adjacent 'O'
    }
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'O', 'O', 'X', 'X'},
        {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
        {'X', 'X', 'X', 'O', 'X', 'X', 'X'},
    };

    solve(board);
    for (char[] b : board)
      System.out.println(Arrays.toString(b));
  }
}
