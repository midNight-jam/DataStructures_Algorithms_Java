package darkRealm;

/**
 * Created by Jayam on 4/1/2017.
 */
public class NumToBase {

  private static char getSymbol(int n) {
    if (n >= 0 && n <= 9) return (char) (n + '0');
    return (char) ((n - 10) + 'A');
  }

  public static String numToBase(int num, int base) {
    boolean sign = num < 0 ? true : false;
    num = Math.abs(num);
    StringBuffer sb = new StringBuffer();

    while (num > 0) {
      sb.append(getSymbol(num % base));
      num = num / base;
    }
    if (sign) sb.append("-");
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    int num = -123;
    int base = 16;
    System.out.println(" Input : " + num + " base : " + base + " output : " + numToBase(num, base));
  }
}