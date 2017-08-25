package darkRealm;

public class SumOfTwoIntegers {

//  Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//  Example:
//  Given a = 1 and b = 2, return 3.

  public static int sumOfTwoIntegers(int a, int b) {
    while (b != 0) {
      int carry = a & b; // do AND get the carry bit
      a = a ^ b; // do XOR to get the sum of bits
      b = carry << 1;
    }
    return a;
  }

  public static void main(String[] args) {
//    int a = 2;
//    int b = 3;

    int a = -16;
    int b = 32;
    int sum = sumOfTwoIntegers(a, b);
    System.out.println("a : " + a + "\nb : " + b + "\nsum : " + sum);
  }
}
