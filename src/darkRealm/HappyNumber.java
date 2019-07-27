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
    if(n < 1) return false;
    Set<Integer> prevSums = new HashSet<>();
    int t, sum;
    while(n > 1){
      t = n;
      sum = 0;
      while(t > 0){
        sum += (t % 10) * (t % 10);
        t = t / 10;
      }
      if(prevSums.contains(sum))
        return false;
      prevSums.add(sum);
      n = sum;
    }
    
    return true;
  }

  public static void main(String[] args) {
    int n = 19;
    boolean res = isHappy(n);
    System.out.println(res);
  }
}
