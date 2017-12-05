package darkRealm;

public class ReverseInteger {

  /*  #7 Reverse digits of an integer.
* Example1: x = 123, return 321
* Example2: x = -123, return -321
* */
  public static int reverseInteger(int x) {
    int result = 0;
    int t = Math.abs(x);
    while (t != 0) {
      if ((result * 10) / 10 != result)
        return 0;

      result *= 10;
      if ((result + t % 10) < 0)
        return 0;

      result += t % 10;
      t /= 10;
    }

    return x < 0 ? result * -1 : result;
  }

  public static void main(String[] args) {

  }
}
