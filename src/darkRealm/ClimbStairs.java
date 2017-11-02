package darkRealm;

public class ClimbStairs {

//  #70. Climbing Stairs
//  You are climbing a stair case. It takes n steps to reach to the top.
//  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//  Note: Given n will be a positive integer.

  public static int climbStairs(int n) {
    int prev = 0, here = 1;
    int sum = 0;
    while(n > 0){
      sum = prev + here;
      prev = here;
      here = sum;
      n--;
    }
    return sum;
  }

  public static void main(String[] args) {

  }
}
