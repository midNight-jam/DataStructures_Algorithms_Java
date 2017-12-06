package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {


  /*  [Prob 119] 
 Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
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
