import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SpiralMatrixNoTouch {

  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(System.in);
      System.out.println("Rows : ");
      int row = sc.nextInt();
      System.out.println("Cols : ");
      int col = sc.nextInt();
      int [][] matrix = new int[row][col];
      spiralMatrix(matrix);
    }
    catch (InputMismatchException e){
      System.out.println("Please input only integers   [0_0]");
    }
  }

  // Spiral a matrix of dimension m * n      Time Complexity - O(m*n)
  private static void spiralMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
    int row = matrix.length;
    int col = matrix[0].length;
    int left = -2;
    int right = col - 1;
    int top = 0;
    int bottom = row - 1;
    while (left <= right && top <= bottom) {
      // increase left
      left += 2;

      // fill top row from left to right
      if (top <= bottom)
        // intialization condition helps us take care of first left col
        for (int i = left - 1 > -1 ? left - 1 : left; i <= right; i++)
          matrix[top][i] = 1;

      // fill right col from top to bottom
      if (right >= left)
        for (int i = top; i <= bottom; i++)
          matrix[i][right] = 1;

      // increase top
      top += 2;

      // fill bottom row from right to left
      if (top <= bottom)
        for (int i = right; i >= left; i--)
          matrix[bottom][i] = 1;

      // reduce right
      right -= 2;

      // fill left col from bottom to top
      if (right >= left || left == 0)
        for (int i = bottom; i >= top; i--)
          matrix[i][left] = 1;

      // reduce bottom
      bottom -= 2;
    }

    for (int i = 0; i < matrix.length; i++)
      System.out.println(Arrays.toString(matrix[i]) + " - " + i);
  }
}
