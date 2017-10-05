package darkRealm;

public class ComplexNumberMultiplication {
//  #537. Complex Number Multiplication
//  Given two strings representing two complex numbers.
//  You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
//  Example 1:
//  Input: "1+1i", "1+1i"
//  Output: "0+2i"
//  Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
//  Example 2:
//  Input: "1+-1i", "1+-1i"
//  Output: "0+-2i"
//  Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
//  The input strings will not have extra blank.
//  The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of
//  [-100, 100]. And the output should be also in this form.

  public static String complexNumberMultiply(String p, String q) {
    // a => a + bi, b => c + di
    String[] pp = p.split("\\+");
    int a = Integer.parseInt(pp[0]);
    int b = Integer.parseInt(pp[1].substring(0, pp[1].length() - 1));
    String[] qq = q.split("\\+");
    int c = Integer.parseInt(qq[0]);
    int d = Integer.parseInt(qq[1].substring(0, qq[1].length() - 1));
    int real = a * c;
    real += b * d * -1;
    int complex = a * d + b * c;
    return "" + real + "+" + complex + "i";
  }

  public static void main(String[] args) {
//    String a = "1+1i";
//    String b = "1+1i";
//
//    String a = "1+-1i";
//    String b = "1+-1i";

    String a = "1+-1i";
    String b = "0+0i";

    String r = complexNumberMultiply(a, b);
    System.out.println("A : " + a);
    System.out.println("B : " + b);
    System.out.println("R : " + r);
  }
}