package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UglyNumber {

//  263. Ugly Number
//  Write a program to check whether a given number is an ugly number.
//  Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is
//  not ugly since it includes another prime factor 7.
//  Note that 1 is typically treated as an ugly number.
//  Credits:
//  Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

  public static boolean isUglyBasic(int num) {
    if(num == 0) return false;
    int [] primes =  new int[]{2, 3, 5};
    for(int p : primes){
      while(num % p == 0)
        num = num / p;
    }

    return num == 1;
  }

  public static boolean uglyNumber(int n) {
    Set<Integer> primes = new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 5}));
    int factor = 2;
    for (; factor * factor <= n; factor++) {
      while (n % factor == 0)
        n = n / factor;
      if (factor > 5 && !primes.contains(factor)) return false;
    }

    return primes.contains(n);
  }


  public static void main(String[] args) {
//    int n = 49;
    int n = 13;
//    int n = 256;
//    int n = 16;
//    int n = 21;
    boolean res = uglyNumber(n);
    System.out.println("N : " + n);
    System.out.println("R : " + res);
  }
}
