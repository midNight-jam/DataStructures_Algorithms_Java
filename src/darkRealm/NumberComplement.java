package darkRealm;

public class NumberComplement {
/* Number Complement
* Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation
* Input: 5
* Output: 2
* Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
* */

  public static int complementNumber(int n) {
    int nbits = (int) (Math.log(n) / Math.log(2)) + 1;
    int mask = 1 << nbits;
    return ~n & --mask;
  }

  public static void main(String[] args) {
    int n = 5;
//    int n = 1;
    int res = complementNumber(n);
    System.out.println("number : " + n + "\nComplement : " + res);
  }
}