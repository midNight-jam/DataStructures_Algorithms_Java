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
    // carry goes at poisiton (i + j) & digit goes at (i + j + 1) carry = sum/10,  digit  = sum % 10
    int a = n1.length(), b = n2.length();
    int[] res = new int[a + b];
    for (int i = n1.length() - 1; i >= 0; i--) {
      for (int j = n2.length() - 1; j >= 0; j--) {
        int prod = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
        int carryPos = i + j;
        int digitPos = i + j + 1;

        int sum = prod + res[digitPos];
        int digit = sum % 10;
        int carry = sum / 10;
        res[carryPos] = res[carryPos] + carry; // current carry get added to prev carry
        res[digitPos] = digit; // current digits just overrides prev digit, as we have already captured overflow/carry in above step
      }
    }
    
   StringBuilder sbr = new StringBuilder();
    for (int i = 0; i < res.length; i++) {
      // dont append extra zeros at head
      if ((res[i] == 0 && sbr.length() == 0)) continue;
      sbr.append(res[i]);
    }
    return sbr.length() < 1 ? "0" : sbr.toString();
  }

  public static void main(String[] args) {

  }
}
