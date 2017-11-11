package darkRealm;

public class PerfectNumber {

//  We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
//  Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
//  Example:
//  Input: 28
//  Output: True
//  Explanation: 28 = 1 + 2 + 4 + 7 + 14
//  Note: The input number n will not exceed 100,000,000. (1e8)

  public static boolean checkPerfectNumber(int n) {
    if (n < 0) return false;
    int root = (int) Math.sqrt(n);
    int i = 2;
    int sum = 1;
    while (i <= root) {
      if (n % i == 0) {
        sum += i;
        sum += n / i;
      }
      i++;
    }
    return sum == n;
  }

  public static void main(String[] args) {
    int n = 28;
    boolean res = checkPerfectNumber(n);
    System.out.println("N : " + n + "\nR : " + res);
  }
}