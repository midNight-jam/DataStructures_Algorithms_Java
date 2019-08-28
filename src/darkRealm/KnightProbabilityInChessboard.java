package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityInChessboard {

//  688. Knight Probability in Chessboard
//  On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
//  The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
//
//  A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal
//  direction, then one square in an orthogonal direction.
//
//  Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece
//  would go off the chessboard) and moves there.
//
//  The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the
//  probability that the knight remains on the board after it has stopped moving.
//
//      Example:
//
//  Input: 3, 2, 0, 0
//  Output: 0.0625
//  Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
//  From each of those positions, there are also two moves that will keep the knight on the board.
//  The total probability the knight stays on the board is 0.0625.
//
//
//  Note:
//
//  N will be between 1 and 25.
//  K will be between 0 and 100.
//  The knight always initially starts on the board.

  static int[][] dirs = new int[][]{{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
  static double res;

  public static double knightProbability(int N, int K, int r, int c) {
    return helper(r, c, K, N, new HashMap<String, Double>());
  }


  /*  O(N*N*K) time complexity
   * Intuition is to fires the dfs, but memoize the states, for this we keep a triplet of [k,r,c] & store probabilities
   * against it. We return the sum of all the move's probabilities
   * */
  private static double helper(int r, int c, int k, int N, Map<String, Double> map) {
    if (r < 0 || r >= N || c < 0 || c >= N || k < 0) return 0.0;

    if (k == 0) return 1.0;
    String key = k + "," + r + "," + c;
    if (map.containsKey(key))
      return map.get(key);

    double here = 0.0;

    for (int i = 0; i < 8; i++) {
      int nr = r + dirs[i][0];
      int nc = c + dirs[i][1];
      here += helper(nr, nc, k - 1, N, map);
    }
    here = here * 0.125; // why 0.125, its equal to 1/8, as every hit is one among eight possible moves
    map.put(key, here);
    return here;
  }

  public static void main(String[] args) {
    int N = 3;
    int k = 2;
    double d = knightProbability(N, k, 0, 0);
    System.out.println("Probablity : " + d);
  }
}
