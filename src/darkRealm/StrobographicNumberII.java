package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class StrobographicNumberII {

//  #247. Strobogrammatic Number II
//  A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//  Find all strobogrammatic numbers that are of length = n.
//      For example,
//  Given n = 2, return ["11","69","88","96"].

  public static List<String> findStrobogrammatic(int n) {
    List<String> res = new ArrayList<>();
    int[] nos = new int[]{0, 1, 6, 8, 9};
    if ((n & 1) == 0) helper("", res, n, nos);
    else
      for (int i : new int[]{0, 1, 8})
        helper("" + i + "", res, n, nos);
    return res;
  }

  private static void helper(String s, List<String> res, int n, int[] nos) {
    if (s.length() >= n) {
      if (s.length() == n && (n < 2 || s.charAt(0) != '0')) res.add(s);
      return;
    }

    String h;
    for (int i = 0; i < nos.length; i++) {
      if (nos[i] == 6) h = "6" + s + "9";
      else if (nos[i] == 9) h = "9" + s + "6";
      else h = nos[i] + s + nos[i];
      helper(h, res, n, nos);
    }
  }

  public static void main(String[] args) {

  }
}
