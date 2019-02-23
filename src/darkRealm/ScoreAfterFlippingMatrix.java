package darkRealm;

import java.util.Arrays;

public class ScoreAfterFlippingMatrix {

//  861. Score After Flipping Matrix
//  We have a two dimensional matrix A where each value is 0 or 1.
//  A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s,
//  and all 1s to 0s.
//
//  After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of
//  the matrix is the sum of these numbers.
//
//  Return the highest possible score.
//
//      Example 1:
//  Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//  Output: 39
//  Explanation:
//  Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
//      0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
//  Note:
//      1 <= A.length <= 20
//      1 <= A[0].length <= 20
//  A[i][j] is 0 or 1.


  public static int matrixScore(int[][] A) {
    if (A == null || A.length < 1 || A[0].length < 1) return 0;

    // Greedy approach
    // 1: Any row that starts with a 0 flip it, bcoz 1000 (8)> 0111 (7)
    // 2: After #1, flip all the cols who have more no of 0's than 1's, as we that will give us gain
    for (int i = 0; i < A.length; i++) {
      if (A[i][0] == 0) {
        // Flip the row, as it starts with 0
        for (int j = 0; j < A[0].length; j++) {
          if (A[i][j] == 1)
            A[i][j] = 0;
          else
            A[i][j] = 1;
        }
      }
    }

    // get the zeros count, we can get 1's count by ColumnSize - zeros count
    int[] zerosCount = new int[A[0].length];

    int zc;
    for (int j = 0; j < A[0].length; j++) {
      zc = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i][j] == 0) zc++;
      }
      zerosCount[j] = zc;
    }

    // for any col whose zerosCount > onesCount flip the col
    for (int j = 0; j < A[0].length; j++) {
      if (zerosCount[j] > A.length - zerosCount[j]) {
        // Flip the col, as it has more 0's, so after flipping we will be in gain
        for (int i = 0; i < A.length; i++) {
          if (A[i][j] == 1)
            A[i][j] = 0;
          else
            A[i][j] = 1;
        }
      }
    }


    int maxScore = 0;
    // Now count the score
    for (int i = 0; i < A.length; i++)
      // read from behind in the increasing powers of 2
      for (int j = A[0].length - 1; j > -1; j--)
        if (A[i][j] == 1)
          maxScore += (int) Math.pow(2, (A[0].length - 1) - j);

    return maxScore;
  }

  public static void main(String[] args) {
    int[][] mat = new int[][]{
        {0, 0, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 0}
    };

    int res = matrixScore(mat);
    for (int[] r : mat)
      System.out.println(Arrays.toString(r));

    System.out.println("Res : " + res);
  }
}
