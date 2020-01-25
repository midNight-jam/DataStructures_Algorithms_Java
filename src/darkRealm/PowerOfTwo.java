package darkRealm;

public class PowerOfTwo {

//  231. Power of Two
//  Given an integer, write a function to determine if it is a power of two.
//
//  Example 1:
//
//  Input: 1
//  Output: true
//  Explanation: 20 = 1
//  Example 2:
//
//  Input: 16
//  Output: true
//  Explanation: 24 = 16
//  Example 3:
//
//  Input: 218
//  Output: false

  public static boolean powerOfTwo(int n) {
    if (1 > n) return false;
    int n_1 = n - 1;
    boolean res = (n & n_1) == 0;
    return res;
  }

  public static void main(String[] args) {
    int n = Integer.MIN_VALUE;
    boolean res = powerOfTwo(n);
    System.out.println(" N : " + n);
    System.out.println(" R : " + res);
  }
}
