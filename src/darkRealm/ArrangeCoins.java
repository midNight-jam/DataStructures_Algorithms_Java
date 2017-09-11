package darkRealm;

public class ArrangeCoins {

//  You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//  Given n, find the total number of full staircase rows that can be formed.
//  n is a non-negative integer and fits within the range of a 32-bit signed integer.
//  Example 1:
//  n = 5
//  The coins can form the following rows:
//  ¤
//  ¤ ¤
//  ¤ ¤
//  Because the 3rd row is incomplete, we return 2.
//  Example 2:
//  n = 8
//  The coins can form the following rows:
//  ¤
//  ¤ ¤
//  ¤ ¤ ¤
//  ¤ ¤
//  Because the 4th row is incomplete, we return 3

  public static int arrangeCoins(int n) {
    int start = 0;
    int end = n;
    int mid = 0;
    double sum = 0;
    // shift the sum of AP till we hit the correct range
    while (start <= end) {
      mid = (end + start) / 2;
      sum = 0.5 * mid * mid + 0.5 * mid;
      if (sum <= n) start = mid + 1;
      else end = mid - 1;
    }
    return start - 1;
  }

  public static int arrangeCoinsOLD(int n) {
    if (1 > n) return 0;
    int i = 0;
    for (; n > 0; i++) {
      n -= i;
      if (n - i < 1) break;
    }
    return i;
  }

  public static void main(String[] args) {
    int n = 1804289383;
//    int n = 5;
    int row = arrangeCoins(n);
    System.out.println("N : " + n + "\nR : " + row);
  }
}