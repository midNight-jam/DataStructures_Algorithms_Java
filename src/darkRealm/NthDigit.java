package darkRealm;

public class NthDigit {

//  #400. Nth Digit ::: Complexity - Time : O(logN) bcoz count is mulitplied by 10, Space : O(1)
//  Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
//  Note:
//  n is positive and will fit within the range of a 32-bit signed integer (n < 231).
//  Example 1:
//  Input:
//      3
//  Output:
//      3
//
//  Example 2:
//  Input:
//      11
//  Output:
//      0
//
//  Explanation:
//  The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

  public static int nthDigitZZ(int n) {
    int len = 1, start = 1;
    long count = 9;
    // why this config, beacuase there are ...
    // 9 number's of 1 digit [1-9]
    // 90 number's of 2 digit [10-99]
    // 900 number's of 3 digit [100-999] ... so on..
    while (n > len * count) {
      n -= len * count;
      len++;
      count *= 10;
      start *= 10;
    }

    // why we are doing "/" len, because at this stage every number is "len(3 or 5 .. etc)" thus each will consume that
    // much amount from n, and why are we doing (n - 1) because the nth digit will lie in the nth number thus we want to
    // reach the start of that number, for ex : n = 194,  then after loop we get start  = 100 and n = 5 and len = 3, now
    // in ordert o consume a whole len equivalent digits that will give us a number of len 3 we do (5-1)/3 == 1 and we
    // increase start by 1, now we have reached the start of the number in which the nth digit will lie. which should be
    // the 2nd digit of that number
    start = start + (n - 1) / len;
    String number = Integer.toString(start);
    // why n-1 , because string start from 0 index
    return number.charAt((n - 1) % len) - '0';
  }

  public static void main(String[] args) {
//    int n = 3;
//    int n = 11;
//    int n = 12;
//    int n = 13;
//    int n = 14;
//    int n = 194;
    int n = 2147483647;
    int d = nthDigitZZ(n);
    System.out.println("N : " + n + "\nD : " + d);
  }
}
