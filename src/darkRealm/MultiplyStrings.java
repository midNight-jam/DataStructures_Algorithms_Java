package darkRealm;

public class MultiplyStrings {


/*
  Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
  Note:
  The length of both num1 and num2 is < 110.
  Both num1 and num2 contains only digits 0-9.
  Both num1 and num2 does not contain any leading zero.
  You must not use any built-in BigInteger library or convert the inputs to integer directly.
  */

  public static String multiply(String n1, String n2) {
    int a = n1.length(), b = n2.length();
    int[] pos = new int[a + b];
    // p1 goes at part (i + j) p2 goes at (i + j + 1) p1 = sum/10 p2  = sum % 10
    for (int i = n1.length() - 1; i >= 0; i--) {
      for (int j = n2.length() - 1; j >= 0; j--) {
        int prod = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
        int p1 = i + j;
        int p2 = i + j + 1;

        int sum = prod + pos[p2];
        pos[p1] += sum / 10;
        pos[p2] = sum % 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pos.length; i++) {
      if (!(pos[i] == 0 && sb.length() == 0))// dont append extra zeros at head
        sb.append(pos[i]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }

  public static void main(String[] args) {

  }
}
