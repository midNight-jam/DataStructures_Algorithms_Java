package darkRealm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AndroidUnlockPatterns {


  static List<List<String>> res;
  static int[][] knightMoves = new int[][]{{2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}};
  static int[][] rowMoves = new int[][]{{0, 1}, {0, 2}, {0, -1}, {0, -2}};
  static int[][] colMoves = new int[][]{{1, 0}, {2, 0}, {-1, 0}, {-2, 0}};
  static int[][] diagMoves = new int[][]{{1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {2, 2}, {-2, -2}};

  public static int numberOfPatterns(int m, int n) {
    res = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Set<String> taken = new HashSet<>();
        String k = i + "," + j;
        taken.add(k);
        List<String> seq = new ArrayList<>();
        seq.add(k);
        helper(i, j, taken, m, n, seq);
      }
    }

    for (List<String> r : res)
      System.out.println(r);

    return res.size();
  }

  private static void helper(int r, int c, Set<String> taken, int m, int n, List<String> seq) {
    if (seq.size() >= m && seq.size() <= n) {
      res.add(new ArrayList<>(seq));
    }
    if (seq.size() >= n) return;
    int nr, nc;
    String k;
    // knightMoves
    for (int i = 0; i < knightMoves.length; i++) {
      nr = r + knightMoves[i][0];
      nc = c + knightMoves[i][1];
      if (!valid(r, c, nr, nc, taken, true)) continue;

      k = nr + "," + nc;
      taken.add(k);
      seq.add(k);
      helper(nr, nc, taken, m, n, seq);
      taken.remove(k);
      seq.remove(seq.size() - 1);
    }

    // rowMoves
    for (int i = 0; i < rowMoves.length; i++) {
      nr = r + rowMoves[i][0];
      nc = c + rowMoves[i][1];
      if (!valid(r, c, nr, nc, taken, false)) continue;

      k = nr + "," + nc;
      taken.add(k);
      seq.add(k);
      helper(nr, nc, taken, m, n, seq);
      taken.remove(k);
      seq.remove(seq.size() - 1);
    }


    // colMoves
    for (int i = 0; i < colMoves.length; i++) {
      nr = r + colMoves[i][0];
      nc = c + colMoves[i][1];
      if (!valid(r, c, nr, nc, taken, false)) continue;

      k = nr + "," + nc;
      taken.add(k);
      seq.add(k);
      helper(nr, nc, taken, m, n, seq);
      taken.remove(k);
      seq.remove(seq.size() - 1);
    }


    // diagMoves
    for (int i = 0; i < diagMoves.length; i++) {
      nr = r + diagMoves[i][0];
      nc = c + diagMoves[i][1];
      if (!valid(r, c, nr, nc, taken, false)) continue;

      k = nr + "," + nc;
      taken.add(k);
      seq.add(k);
      helper(nr, nc, taken, m, n, seq);
      taken.remove(k);
      seq.remove(seq.size() - 1);
    }
  }

  private static boolean valid(int fr, int fc, int tr, int tc, Set<String> taken, boolean hmove) {
    String k = tr + "," + tc;
    if (taken.contains(k) || tr < 0 || tr > 2 || tc < 0 || tc > 2) return false;
    if (hmove) return true;
    boolean twoDist = Math.abs(tr - fr) >= 2 || Math.abs(tc - fc) >= 2;
    boolean sameRow1D = fr == tr && !twoDist;
    boolean sameCol1D = fc == tc && !twoDist;
    boolean sameRow2D = fr == tr && twoDist;
    boolean sameCol2D = fc == tc && twoDist;
    boolean diag2D = twoDist && !sameRow2D && !sameCol2D && taken.contains("1,1");
    boolean sc2dvalid = (sameCol2D && (fc < tc) && taken.contains(fr + "," + (fc + 1))) || (sameCol2D && (fc > tc) && taken.contains(fr + "," + (fc - 1)));
    boolean sr2dvalid = (sameRow2D && (fr < tr) && taken.contains((fr + 1) + "," + fc)) || (sameCol2D && (fr > tr) && taken.contains((fr - 1) + "," + fc));
    boolean diag1D = Math.abs(fr - tr) == 1 && Math.abs(fc - tc) == 1;

    return sameRow1D || sameCol1D || diag2D || sc2dvalid || sr2dvalid || diag1D;
  }

  public static void main(String[] args) {
//    int m = 1;
//    int n = 2;
//    int res = numberOfPatterns(m, n); // 65
    int m = 1;
    int n = 3;
    int res = numberOfPatterns(m, n); // 385
    System.out.println(res);
  }
}
