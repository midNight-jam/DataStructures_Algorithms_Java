package darkRealm;

import java.util.Arrays;

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
  public static void surroundedRegions(char[][] board) {
    if (board.length > 0) {
      Status[][] statuses = new Status[board.length][board[0].length];
      for (int i = 0; i < statuses.length; i++) {
        for (int j = 0; j < statuses[0].length; j++) {
          statuses[i][j] = Status.NotProcessed;
        }
      }
      java.util.LinkedList<Pair> queue = new java.util.LinkedList();
      java.util.LinkedList<Pair> processed = new java.util.LinkedList();
      // we will begin from 1,1 cell because the ones which are on the boundary even of they are O, but they cannot be
      // completely surrounded by X thats why.

      boolean discard = false;
      for (int row = 1; row < board.length; row++) {
        for (int col = 1; col < board[0].length; col++) {
          if (board[row][col] == 'O' && statuses[row][col] == Status.NotProcessed) {
            queue.push(new Pair(row, col));
            statuses[row][col] = Status.UnderProcessing;
            discard = false;
          }
          while (!queue.isEmpty()) {
            Pair poped = queue.poll();
            int popR = poped.a;
            int popC = poped.b;
            //Top
            if (popR - 1 > -1 && board[popR - 1][popC] == 'O' && statuses[popR - 1][popC] == Status.NotProcessed) {
              queue.push(new Pair(popR - 1, popC));
              statuses[popR - 1][popC] = Status.UnderProcessing;
            }
            //Left
            if (popC - 1 > -1 && board[popR][popC - 1] == 'O' && statuses[popR][popC - 1] == Status.NotProcessed) {
              queue.push(new Pair(popR, popC - 1));
              statuses[popR][popC - 1] = Status.UnderProcessing;
            }
            //Bottom
            if (popR + 1 < board.length && board[popR + 1][popC] == 'O' && statuses[popR + 1][popC] == Status.NotProcessed) {
              queue.push(new Pair(popR + 1, popC));
              statuses[popR + 1][popC] = Status.UnderProcessing;
            }
            //Right
            if (popC + 1 < board[0].length && board[popR][popC + 1] == 'O' && statuses[popR][popC + 1] == Status.NotProcessed) {
              queue.push(new Pair(popR, popC + 1));
              statuses[popR][popC + 1] = Status.UnderProcessing;
            }

            processed.push(poped);
            if ((poped.a == 0 || poped.a == board.length - 1) ||
                (poped.b == 0 || poped.b == board[0].length - 1)) {
              discard = true;
            }
          }
          // mark all processed by X as they are not ending on boundary & can be captured as a region
          while (!processed.isEmpty() && !discard) {
            Pair poped = processed.poll();
            board[poped.a][poped.b] = 'X';
            statuses[poped.a][poped.b] = Status.Processed;
          }
          while (!processed.isEmpty() && discard) {
            Pair prevOnes = processed.poll();
            statuses[prevOnes.a][prevOnes.b] = Status.DontProcessAgain;
          }
        }
      }

      for (int i = 0; i < board.length; i++) {
        System.out.println(Arrays.toString(board[i]));
      }
    }
  }

  enum Status {
    NotProcessed,
    UnderProcessing,
    Processed,
    DontProcessAgain
  }

  static class Pair {
    int a;
    int b;

    Pair(int x, int y) {
      a = x;
      b = y;
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
//    char[][] board = new char[0][0];

    surroundedRegions(board);
  }
}
