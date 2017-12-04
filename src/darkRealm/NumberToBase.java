package darkRealm;

public class NumberToBase {


  public static String numToBase(int num, int base) {
    if (num == 0) return "0";
    int i = 0;
    boolean sign = num < 0;
    num = Math.abs(num);
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      sb.append(getSymbol(num % base));
      num /= base;
    }
    if (sign) sb.append("-");
    return sb.reverse().toString();
  }

  private static char getSymbol(int n) {
    if (n >= 0 && n <= 9) return (char) (n + '0');
    else return (char) (n - 10 + 'A');
  }


  public static void main(String[] args) {
    int n = -7;
    int base = 7;
    String res = numToBase(n, base);
    System.out.println(" Changed Base : " + res + " Orig " + n);
  }
}
