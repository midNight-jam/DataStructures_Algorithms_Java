package darkRealm;

public class PowerOfTwo {
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
