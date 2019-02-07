package darkRealm;

import java.util.Arrays;

public class RangeSumQuery2DMutable {
//  #308 Range Sum QUery 2D - Mutable
//  Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
//  (row1, col1) and lower right corner (row2, col2).
//  Range Sum Query 2D
//  The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which
//  contains sum = 8.
//  Example:
//  Given matrix = [
//      [3, 0, 1, 4, 2],
//      [5, 6, 3, 2, 1],
//      [1, 2, 0, 1, 5],
//      [4, 1, 0, 1, 7],
//      [1, 0, 3, 0, 5]
//      ]
//  sumRegion(2, 1, 4, 3) -> 8
//  update(3, 2, 2)
//  sumRegion(2, 1, 4, 3) -> 10
//  Note:
//  The matrix is only modifiable by the update function.
//  You may assume the number of calls to update and sumRegion function is distributed evenly.
//  You may assume that row1 ≤ row2 and col1 ≤ col2.

  private int[][] matrix;
  private int[][] rowSums; // here each cell will hold the sum of all the rows above it for the same col
  int row, col;
  public RangeSumQuery2DMutable(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
    this.matrix = matrix;
    row = matrix.length;
    col = matrix[0].length;

    // initializing the row sum matrix
    rowSums = new int[row + 1][col];
    for (int i = 1; i < rowSums.length; i++)
      for (int j = 0; j < rowSums[0].length; j++)
        rowSums[i][j] = rowSums[i - 1][j] + matrix[i - 1][j];
  }

  public void update(int row, int col, int val) {
    for (int r = row + 1; r < rowSums.length; r++)
      rowSums[r][col] = rowSums[r][col] - matrix[row][col] + val;
    matrix[row][col] = val;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int c = col1; c <= col2; c++)
      sum += rowSums[row2 + 1][c] - rowSums[row1][c]; // why not row1 + 1..?? This is for capturing the diff from r1 to r2
    // and as we are keeping sum of cols from above rows, we remove the sum that is present from r1 And above, in this way
    // we are only capturing the given window
    return sum;
  }

  public void print() {
    for (int[] arr : matrix)
      System.out.println(Arrays.toString(arr));
  }



//  Approach #2 using segment trees


  private int[][] segTrees;
  private int N;

  public RangeSumQuery2DMutable(int[][] matrix, boolean overloadedConstructor) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
    this.matrix = matrix;

    N = matrix[0].length;
    int h = (int) Math.floor(Math.log(N) / Math.log(2)) + 1;
    int no_of_nodes = (int) Math.pow(2, h + 1) - 1;
    segTrees = new int[matrix.length][no_of_nodes];

    for (int i = 0; i < matrix.length; i++)
      constructSegTree(matrix[i], segTrees[i], 0, 0, N - 1);

  }

  private void constructSegTree(int[] arr, int[] segTree, int node, int start, int end) {
    if (start == end) {
      segTree[node] = arr[start];
      return;
    }

    int mid = start + (end - start) / 2;

    constructSegTree(arr, segTree, 2 * node + 1, start, mid);
    constructSegTree(arr, segTree, 2 * node + 2, mid + 1, end);

    segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
  }

  public void update2(int row, int col, int val) {
    updateHelper(segTrees[row], 0, val - matrix[row][col], 0, N - 1, row, col);
  }

  private void updateHelper(int[] segTree, int node, int val, int start, int end, int row, int col) {
    if (start == end) {
      segTree[node] += val;
      matrix[row][col] += val;
      return;
    }

    int mid = start + (end - start) / 2;
    // if updating in the left subtree
    if(col >= start && col <= mid)
      updateHelper(segTree, 2 * node + 1, val, start, mid, row, col);

    else
    updateHelper(segTree, 2 * node + 2, val, mid + 1, end, row, col);

    segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
  }

  public int sumRegion2(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
      sum += query(i, 0, 0, N - 1, col1, col2);
    }

    return sum;
  }

  private int query(int row, int node, int start, int end, int left, int right) {
    if(left > end || right < start) return 0;

    if(start >= left && end <= right)
      return segTrees[row][node];

    int mid = start + (end - start) / 2;
    int subRes1 = query(row, 2 * node + 1, start, mid, left, right);
    int subRes2 = query(row, 2 * node + 2, mid + 1, end, left, right);

    return subRes1 + subRes2;
  }

  public static void main(String[] args) {
//    int[][] matrix = new int[][]{
//        {1, 2},
//        {3, 4}
//    };

    int[][] matrix = new int[][]{
        {2, 4},
        {-3, 5}
    };

    RangeSumQuery2DMutable mat = new RangeSumQuery2DMutable(matrix);
    mat.print();
    mat.update(0, 1, 3);
    mat.update(1, 1, -3);
    mat.update(0, 1, 1);
    int res = mat.sumRegion(0, 0, 1, 1);
    mat.print();
    System.out.println("R : " + res);

//    int[][] matrix = new int[][]{
//        {3, 0, 1, 4, 2},
//        {5, 6, 3, 2, 1},
//        {1, 2, 0, 1, 5},
//        {4, 1, 0, 1, 7},
//        {1, 0, 3, 0, 5}
//    };
//    RangeSumQuery2DMutable mat = new RangeSumQuery2DMutable(matrix);
//    int res = mat.sumRegion(2, 1, 4, 3);
//    mat.print();
//    System.out.println("R : " + res);
//
//    mat.update(3, 2, 2);
//    res = mat.sumRegion(2, 1, 4, 3);
//    mat.print();
//    System.out.println("R : " + res);
  }
}
