package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

  /*
    #89 Gray Code
  * The gray code is a binary numeral system where two successive values differ in only one bit.
  * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
   * A gray code sequence must begin with 0.
   * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
   * 00 - 0
   * 01 - 1
   *11 - 3
   *10 - 2
   *Note:
   * For a given n, a gray code sequence is not uniquely defined.
   *
   *For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
  * */
  public static List<Integer> grayCode(int n) {
    int end = (int) Math.pow(2, n);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < end; i++) {
      res.add(binaryToGray(i));
    }
    return res;
  }

  private static int binaryToGray(int k) {
    // divide by 2 & XOR with self
    return (k >> 1) ^ k;
  }
  public static void main(String[] args) {
    int n = 3;
    List<Integer> res = grayCode(n);
    System.out.println(" N : " + n + " gray : " + res);
  }
}
