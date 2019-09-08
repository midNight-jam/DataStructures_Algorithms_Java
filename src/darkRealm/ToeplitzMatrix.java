package darkRealm;

public class ToeplitzMatrix {

  public boolean isToeplitzMatrix(int[][] mat) {
    if (mat == null || mat.length < 1) return false;
    boolean t = true;
    int m = mat.length;
    int n = mat[0].length;

    int nr = m;
    // first fire from first col
    while (--nr >= 0) {
      int val = mat[nr][0];
      int r = nr;
      int c = 0;
      while (r < m && c < n) {
        if (val != mat[r][c]) break;
        r++;
        c++;
      }

      t = t & (r >= m || c >= n);
      if (!t) return false;
    }


    // second fire from first row
    int nc = -1;
    while (++nc < n) {
      int val = mat[0][nc];
      int r = 0;
      int c = nc;
      while (r < m && c < n) {
        if (val != mat[r][c]) break;
        r++;
        c++;
      }

      t = t & (r >= m || c >= n);
      if (!t) return false;
    }

    return true;
  }

  public static void main(String[] args) {

  }
}
