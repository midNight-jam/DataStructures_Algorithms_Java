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
  public static List<Integer> pascalsTriangleRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();

    // Any pascal row has starts with 1 & ends with 1, thus we have  res.add(1) when starting the row
    // & another one when returning
    // the elements of a pascal row are the sum of two consecutive numbers of a previous pascal row
    for(int i = 1; i <= rowIndex; i++){
      res.add(1);
      for(int j = res.size() - 1; j > 0; j--)
        res.set(j, res.get(j-1) + res.get(j));  // set, update the val at that index
    }

    res.add(1);
    return res;
  }

  public static void main(String[] args) {
    int n = 5;
    List<Integer> res = pascalsTriangleRow(n);
    System.out.println(n + "th row : " + res);
  }
}
