package darkRealm;

import java.util.Arrays;

public class ImageSmoother {

//  Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
//  scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
//  If a cell has less than 8 surrounding cells, then use as many as you can.
//  Example 1:
//  Input:
//      [[1,1,1],
//      [1,0,1],
//      [1,1,1]]
//  Output:
//      [[0, 0, 0],
//      [0, 0, 0],
//      [0, 0, 0]]
//  Explanation:
//  For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
//  For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
//  For the point (1,1): floor(8/9) = floor(0.88888889) = 0
//  Note:
//  The value in the given matrix is in the range of [0, 255].
//  The length and width of the given matrix are in the range of [1, 150].

  public static int[][] imageSmoother(int[][] m) {
    if (m == null || m.length == 0) return m;
    int[][] res = new int[m.length][m[0].length];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        int[] rows = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] cols = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int count = 1, sum = m[i][j];
        for (int k = 0; k < rows.length; k++) {
          if (isValid(i + rows[k], j + cols[k], m.length, m[i].length)) {
            count++;
            sum += m[i + rows[k]][j + cols[k]];
          }
        }
        res[i][j] = sum / count;
      }
    }
    return res;
  }

  public static boolean isValid(int r, int c, int m, int n) {
    return r > -1 && r < m && c > -1 && c < n;
  }

  public static void main(String[] args) {
//    int[][] m = new int[][]{
//        {1, 1, 1},
//        {1, 0, 1},
//        {1, 1, 1},
//    };

    int[][] m = new int[][]{
        {2, 3, 4},
        {5, 6, 7},
        {8, 9, 10},
        {11, 12, 13},
        {14, 15, 16}
    };

    for (int[] a : m)
      System.out.println(Arrays.toString(a));
    m = imageSmoother(m);
    for (int[] a : m)
      System.out.println(Arrays.toString(a));
  }
}