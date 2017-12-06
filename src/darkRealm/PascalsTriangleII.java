package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {


  /*  [Prob 119] ith Row of Pascals Triangle
 Pascal's Triangle II
* */
  public static List<Integer> pascalsTriangleRow(int n) {
    Integer[] result =  new Integer[n + 1];
    Arrays.fill(result, 0);
    result[0] = 1;
    for(int i = 1; i < n + 1; i++)
      for(int j = i; j >= 1; j--)
        result[j] += result[j - 1];
    return Arrays.asList(result);
  }

  public static void main(String[] args) {
    int n = 5;
    List<Integer> res = pascalsTriangleRow(n);
    System.out.println(n + "th row : " + res);
  }
}
