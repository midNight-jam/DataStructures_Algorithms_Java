package darkRealm;

public class SumSquareNumber {

//  Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
//  Example 1:
//  Input: 5
//  Output: True
//  Explanation: 1 * 1 + 2 * 2 = 5
//  Example 2:
//  Input: 3
//  Output: False

  public static boolean judgeSquareSum(int c) {
    int left = 0, right = (int) Math.sqrt(c);
    int sum = 0;
    while (left <= right) {
      sum = left * left + right * right; // this can cause overflow, thus we are checking if sum goes -ve
      if (sum < 0 || sum > c) right--;
      else if (sum < c) left++;
      else return true;
    }
    return (left * left + right * right) == c;
  }

  public static void main(String[] args) {
    int n = 1000000;
    boolean res = judgeSquareSum(n);
    System.out.println("N : " + n + "\nR : " + res);
  }
}