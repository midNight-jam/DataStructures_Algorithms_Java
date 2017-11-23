package darkRealm;

public class PowerOfThree {

//  #326. Power of Three    :::   COmplexity  -   Time : O(1)
//  Given an integer, write a function to determine if it is a power of three.
//  Follow up:
//  Could you do it without using any loop / recursion?

  public static boolean powerOfThree(int n) {
    if (n < 1) return false;
    double pow = Math.log(n) / Math.log(3);
    pow = Math.round(pow);
    double d = Math.pow(3, pow);
    boolean res = d == n;
    return res;
  }

  public static void main(String[] args) {
//    int n = 3;
//    int n = 4;
//    int n = 5;
//    int n = 28;
    int n = 243;
//    int n = 0;
//    int n = 2;
//    int n = 1;
    boolean res = powerOfThree(n);
    System.out.println("N : " + n);
    System.out.println("R : " + res);
  }
}
