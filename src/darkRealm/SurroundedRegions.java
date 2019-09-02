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
//  public static void surroundedRegions(char[][] board) {
//    if (board.length > 0) {
//      Status[][] statuses = new Status[board.length][board[0].length];
//      for (int i = 0; i < statuses.length; i++) {
//        for (int j = 0; j < statuses[0].length; j++) {
//          statuses[i][j] = Status.NotProcessed;
//        }
//      }
//      java.util.LinkedList<Pair> queue = new java.util.LinkedList();
//      java.util.LinkedList<Pair> processed = new java.util.LinkedList();
//      // we will begin from 1,1 cell because the ones which are on the boundary even of they are O, but they cannot be
//      // completely surrounded by X thats why.
//
//      boolean discard = false;
//      for (int row = 1; row < board.length; row++) {
//        for (int col = 1; col < board[0].length; col++) {
//          if (board[row][col] == 'O' && statuses[row][col] == Status.NotProcessed) {
//            queue.push(new Pair(row, col));
//            statuses[row][col] = Status.UnderProcessing;
//            discard = false;
//          }
//          while (!queue.isEmpty()) {
//            Pair poped = queue.poll();
//            int popR = poped.a;
//            int popC = poped.b;
//            //Top
//            if (popR - 1 > -1 && board[popR - 1][popC] == 'O' && statuses[popR - 1][popC] == Status.NotProcessed) {
//              queue.push(new Pair(popR - 1, popC));
//              statuses[popR - 1][popC] = Status.UnderProcessing;
//            }
//            //Left
//            if (popC - 1 > -1 && board[popR][popC - 1] == 'O' && statuses[popR][popC - 1] == Status.NotProcessed) {
//              queue.push(new Pair(popR, popC - 1));
//              statuses[popR][popC - 1] = Status.UnderProcessing;
//            }
//            //Bottom
//            if (popR + 1 < board.length && board[popR + 1][popC] == 'O' && statuses[popR + 1][popC] == Status.NotProcessed) {
//              queue.push(new Pair(popR + 1, popC));
//              statuses[popR + 1][popC] = Status.UnderProcessing;
//            }
//            //Right
//            if (popC + 1 < board[0].length && board[popR][popC + 1] == 'O' && statuses[popR][popC + 1] == Status.NotProcessed) {
//              queue.push(new Pair(popR, popC + 1));
//              statuses[popR][popC + 1] = Status.UnderProcessing;
//            }
//
//            processed.push(poped);
//            if ((poped.a == 0 || poped.a == board.length - 1) ||
//                (poped.b == 0 || poped.b == board[0].length - 1)) {
//              discard = true;
//            }
//          }
//          // mark all processed by X as they are not ending on boundary & can be captured as a region
//          while (!processed.isEmpty() && !discard) {
//            Pair poped = processed.poll();
//            board[poped.a][poped.b] = 'X';
//            statuses[poped.a][poped.b] = Status.Processed;
//          }
//          while (!processed.isEmpty() && discard) {
//            Pair prevOnes = processed.poll();
//            statuses[prevOnes.a][prevOnes.b] = Status.DontProcessAgain;
//          }
//        }
//      }
//
//      for (int i = 0; i < board.length; i++) {
//        System.out.println(Arrays.toString(board[i]));
//      }
//    }
//  }

  enum Statuszz {
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


  enum Status {
    NotProcessed,
    UnderProcess,
    Finished,
    DontProcess
  }

  public static void solve(char[][] board) {
    if (board == null || board.length < 1 || board[0].length < 1) return;
    int row = board.length;
    int col = board[0].length;
    Status[][] status = new Status[row][col];

    for (Status[] r : status)
      Arrays.fill(r, Status.NotProcessed);

    Queue<int[]> que = new LinkedList<>();
    Queue<int[]> processed = new LinkedList<>();
    boolean discard = false;

    for (int i = 1; i < row; i++) {

      for (int j = 1; j < col; j++) {

        if (board[i][j] == 'O' && status[i][j] == Status.NotProcessed) {
          discard = false;
          que.offer(new int[]{i, j});
          status[i][j] = Status.UnderProcess;
        }

        while (que.size() > 0) {
          int size = que.size();

          while (size-- > 0) {
            int[] cords = que.poll();
            int r = cords[0];
            int c = cords[1];

            // top
            if (r - 1 >= 0 && board[r - 1][c] == 'O' && status[r - 1][c] == Status.NotProcessed) {
              que.offer(new int[]{r - 1, c});
              status[r - 1][c] = Status.UnderProcess;
            }

            // right
            if (c + 1 < col && board[r][c + 1] == 'O' && status[r][c + 1] == Status.NotProcessed) {
              que.offer(new int[]{r, c + 1});
              status[r][c + 1] = Status.UnderProcess;
            }

            // bottom
            if (r + 1 < row && board[r + 1][c] == 'O' && status[r + 1][c] == Status.NotProcessed) {
              que.offer(new int[]{r + 1, c});
              status[r + 1][c] = Status.UnderProcess;
            }

            // left
            if (c - 1 >= 0 && board[r][c - 1] == 'O' && status[r][c - 1] == Status.NotProcessed) {
              que.offer(new int[]{r, c - 1});
              status[r][c - 1] = Status.UnderProcess;
            }

            processed.offer(cords);

            if (r == 0 || r == row - 1 || c == 0 || c == col - 1)
              discard = true;

          }
        }

        if (!discard) {
          while (processed.size() > 0) {
            int[] cords = processed.poll();
            int r = cords[0];
            int c = cords[1];
            status[r][c] = Status.Finished;
            board[r][c] = 'X';
          }
        } else {
          while (processed.size() > 0) {
            int[] cords = processed.poll();
            int r = cords[0];
            int c = cords[1];
            status[r][c] = Status.DontProcess;
          }
        }
      }
    }


    for (char[] b : board)
      Arrays.toString(b);

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

//    surroundedRegions(board);
    solve(board);
    for (char[] b : board)
      System.out.println(Arrays.toString(b));

  }
}
