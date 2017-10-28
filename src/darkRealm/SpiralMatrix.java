package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

//  54. Spiral Matrix
//  Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//  For example,
//  Given the following matrix:
//      [
//      [ 1, 2, 3 ],
//      [ 4, 5, 6 ],
//      [ 7, 8, 9 ]
//      ]
//  You should return [1,2,3,6,9,8,7,4,5].

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if(matrix == null || matrix.length == 0 || matrix[0].length ==0) return res;
    int row = matrix.length, col = matrix[0].length;
    int top = 0, right = col - 1, bottom = row - 1, left = 0;
    while(res.size() < row * col){
      // top row : left to right
      for(int lrt = left; lrt <= right; lrt++)
        res.add(matrix[top][lrt]);
      top++;
      if(top > bottom) break;
      // right col : top to bottom
      for(int rc = top; rc <= bottom; rc++)
        res.add(matrix[rc][right]);
      right--;
      if(left > right) break;

      // bottom row : right to left
      for(int rlb = right; rlb >= left; rlb--)
        res.add(matrix[bottom][rlb]);
      bottom--;

      // left col : bottom to top
      for(int btl = bottom; btl >= top; btl--)
        res.add(matrix[btl][left]);
      left++;
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {2, 3}
    };
    List<Integer> res = spiralOrder(matrix);
    System.out.println(res);
  }
}