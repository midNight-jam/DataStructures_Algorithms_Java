package darkRealm;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {


/*
  Write an algorithm to determine if a number is "happy".
  A happy number is a number defined by the following process: Starting with any positive integer, replace the number
  by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it
  loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
  Example: 19 is a happy number
*/

  public static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    int r = 0;
    while (true) {
      set.add(n);
      r = 0;
      while (n > 0) {
        r += (n % 10) * (n % 10);
        n = n / 10;
      }
      if (r == 1)
        return true;
      else if (set.contains(r))
        return false;
      set.add(r);
      n = r;
    }
  }

  public static void main(String[] args) {
    int n = 19;
    boolean res = isHappy(n);
    System.out.println(res);
  }
}
