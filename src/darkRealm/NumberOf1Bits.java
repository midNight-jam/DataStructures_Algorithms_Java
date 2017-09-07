package darkRealm;

public class NumberOf1Bits {
  public static int numberOf1Bits(int n) {
    int count = n < 0 ? 1 : 0;
    n = Math.abs(n);
    while (n != 0) {
      if ((n & 1) == 1) count++;
      n = n >>> 1;
    }
    return count;
  }

  public static void main(String[] args) {
    int n = -7;
    int oneBit = numberOf1Bits(n);
    System.out.println("N : " + n + "\nO : " + oneBit);
  }
}
