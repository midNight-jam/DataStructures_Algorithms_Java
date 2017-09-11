package darkRealm;

public class PowerOfFour {

//  Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//  Example:
//  Given num = 16, return true. Given num = 5, return false.
//  Follow up: Could you solve it without loops/recursion?

  public static boolean isPowerOfFour(int num) {
    if (num < 1) return false;
    double sq = Math.sqrt(num);
    if (sq % 1 != 0) return false;
    num = (int) sq;
    return (num & (num - 1)) == 0;
  }

  public static void main(String[] args) {
    int n = 16;
    boolean res = isPowerOfFour(n);
    System.out.println("N : " + n + "\nPOW4 : " + res);
  }
}