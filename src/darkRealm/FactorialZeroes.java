package darkRealm;

public class FactorialZeroes {

//  Given an integer n, return the number of trailing zeroes in n!.
//  Note: Your solution should be in logarithmic time complexity.

  public static int trailingZeroes(int n) {
    // Brilliant,
    // Dumb : was trying to do this without iteration or loop but wont work.
    int zeros = 0;
    while (n > 0) {
      n = n / 5;
      zeros += n;
    }
    return zeros;
  }

  public static int trailingZeroesOLD(int n) {
    // Fails around overflow
    int zeros = 0;
    int closestFiveMultiple = (n - (n % 5));
    zeros += closestFiveMultiple / 5;
    int pow = 25;
    while ((closestFiveMultiple / pow) > 0) {
      zeros += closestFiveMultiple / pow;
      if (pow * 5 > pow) pow *= 5;
      else break;
    }
    return zeros;
  }

  public static void main(String[] args) {
    int n = 200;
    int z = trailingZeroes(n);
    System.out.println("N : " + n);
    System.out.println("Z : " + z);
  }
}
