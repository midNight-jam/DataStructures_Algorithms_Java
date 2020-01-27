package darkRealm;

public class ArrangeCoins {

//  441. Arranging Coins
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


  public int arrangeCoinsLogN(int n) {
    if (n == 1) return 1;
    // sum of first N numbers  = n(n+1)/2;
    long left = 1; // long for overflows
    long right = n;
    long mid;
    long sum;

    while (left < right) {
      // would represent the mid or Mth row, if sum upto M rows is equal to mid, then we have M complete rows,
      // else we shift the left & right to reach the mid / Mth row.
      mid = left + (right - left) / 2;
      sum = (mid * (mid + 1) / 2);
      if (sum < n)
        left = mid + 1;
      else if (sum > n)
        right = mid;

      // else sum is completely matching, then Mth/ mid row is the last complete row
      else return (int) mid;
    }

    // if left >= right means the last row  return the prev to left row;
    return (int) (left - 1);
  }

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

  public static int arrangeCoins_O_of_N(int n) {
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