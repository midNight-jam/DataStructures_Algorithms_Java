package darkRealm;

public class UglyNumberII {

//  #264. Ugly Number II
//  Write a program to find the n-th ugly number.
//  Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//  For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//  Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

  public static int nthUglyNumber(int n) {
    if (n < 1) return 0;
    // Intuition is to keep creating numbers using only 2,3 and 5, for this we create 3 pointers one for each number
    // and then we get the 3 possible numbers using those pointers on ugly array, we keep storing the current min no
    // from them as  the ith ugly number and increment the pointer if the current min was the multiple of any of these
    // number
    int[] ugly = new int[n];
    ugly[0] = 1;
    int i2 = 0, i3 = 0, i5 = 0;
    int nextMultipleOf2 = ugly[i2] * 2;
    int nextMultipleOf3 = ugly[i3] * 3;
    int nextMultipleOf5 = ugly[i5] * 5;
    int nextUgly = 0;
    for (int i = 1; i < n; i++) {
      nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
      ugly[i] = nextUgly;
      // Why we need "if" and not "else if", lets say we are seraching for 9th ugly number now for the 9th iteration
      // nextOF2 and nextOf5 are both 10, if we do "else if" only one pointer will move ahead, and as we have min, 10 will
      // again contribute for the next Ugly number, thus we have "if", so that when mulitples are equal and it is the min
      // both pointers will move ahead.
      if (nextUgly == nextMultipleOf2) {
        i2++;
        nextMultipleOf2 = ugly[i2] * 2;
      }
      if (nextUgly == nextMultipleOf3) {
        i3++;
        nextMultipleOf3 = ugly[i3] * 3;
      }
      if (nextUgly == nextMultipleOf5) {
        i5++;
        nextMultipleOf5 = ugly[i5] * 5;
      }
    }
    return ugly[n - 1];
  }

  public static void main(String[] args) {
//    int n = 0;
//    int n = 1;
//    int n = 2;
//    int n = 3;
//    int n = 4;
//    int n = 5;
//    int n = 6;
//    int n = 7;
    int n = 9;
    int nth = nthUglyNumber(n);
    System.out.println("N : " + n);
    System.out.println("T : " + nth);
  }
}
