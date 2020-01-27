package darkRealm;

public class ValidPerfectSquare {

//  367. Valid Perfect Square
//  Given a positive integer num, write a function which returns True if num is a perfect square else False.
//  Note: Do not use any built-in library function such as sqrt.
//  Example 1:
//  Input: 16
//  Returns: True
//  Example 2:
//  Input: 14
//  Returns: False

  public static boolean perfectSquare(int n) {
    // Every perfect square is the sum of first N odd numbers
    int i = 1;
    while (n > 0) {
      n -= i;
      i += 2;
      if (n == 0) return true;
    }
    return false;
  }

  public static void main(String[] args) {
//    int n = Integer.MAX_VALUE;
    int n = 998001;

    long start = System.currentTimeMillis();
    boolean res = perfectSquare(n);
    long time = System.currentTimeMillis() - start;
    System.out.println("N : " + n + "\nR : " + res + "\nT : " + time);
  }
}
