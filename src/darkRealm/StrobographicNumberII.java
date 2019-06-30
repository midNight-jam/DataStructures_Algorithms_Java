package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class StrobographicNumberII {

//  #247. Strobogrammatic Number II
//  A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//  Find all strobogrammatic numbers that are of length = n.
//      For example,
//  Given n = 2, return ["11","69","88","96"].
  
  
   // this version is far better in mem usage than the old version.
   // Memory Usage: 50 MB, less than 99.75% of Java
   public List<String> findStrobogrammatic(int n) {
    List<String> res = new ArrayList<>();
    // even len
    String[] seeds = new String[] {"0","1","8"};
    
    if(n == 1)
      return new ArrayList<String>(Arrays.asList(seeds));
    
    boolean even = (n & 1) == 0;
    
    for(int i = 0; i < seeds.length; i++){
      if(even){
        // dont add 0's as numbers cant start with leading 0's because next iteration will be the last iteration.
        if(n == 2 && i == 0) continue;
        res.add(seeds[i] + seeds[i]);
      }
      else
        res.add(seeds[i]);
    }

    if(even){
      res.add("69");
      res.add("96");
      n = n -2;
    }
    else
      n--;

    res = helper(res, n);    
    return res;
  }
  
  private List<String> helper(List<String> seeds, int n){
    if(n <= 0) return seeds;
    boolean even = (n & 1) == 0;
    char [][] valids = new char[][]{{'0','0'}, {'1', '1'}, {'6', '9'}, {'8','8'}, {'9', '6'}};
    List<String> res = new ArrayList<>();
    
    for(String s : seeds){
      for(int i = 0; i < valids.length; i++){
        // dont add 0's as numbers cant start with leading 0's because next iteration will be the last iteration.
        if(n <= 2 && i == 0) continue; 
        res.add(valids[i][0] + s + valids[i][1]);
      }
    }
    return helper(res, n - 2);
  }

  //Memory Usage: 53.9 MB, less than 18.31% of Java
  public static List<String> findStrobogrammaticOLD(int n) {
    List<String> res = new ArrayList<>();
    int[] nos = new int[]{0, 1, 6, 8, 9};
    if ((n & 1) == 0) helperOLD("", res, n, nos);
    else
      for (int i : new int[]{0, 1, 8})
        helperOLD("" + i + "", res, n, nos);
    return res;
  }

  private static void helperOLD(String s, List<String> res, int n, int[] nos) {
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
