package darkRealm;

public class DivideTwoIntegers {

  /*
  #29 Divide two integers
  Divide two integers without using multiplication, division and mod operator.
  If it is overflow, return MAX_INT.
  */
  public static int divide(int dividend, int divisor) {
    if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
    long dvd = Math.abs((long) dividend);
    long dvs = Math.abs((long) divisor);
    int res = 0;
    while (dvd >= dvs) {
      // calculate the number of shifts
      long temp = dvs;
      int mul = 1;
      while (dvd >= temp << 1) {
        temp = temp << 1;
        mul = mul << 1;
      }
      dvd = dvd - temp;
      res = res + mul;
    }
    return sign == -1 ? -res : res;
  }


  public static void main(String[] args) {

  }
}
