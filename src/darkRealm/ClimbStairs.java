package darkRealm;

public class ClimbStairs {

//  #70. Climbing Stairs
//  You are climbing a stair case. It takes n steps to reach to the top.
//  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//  Note: Given n will be a positive integer.

  public static int climbStairs(int n) {
    if(n < 3) return n;
    
    int n_1 = 1; // n minus 1
    int n_2 = 2; // n minus 2
    int res = 0;
    for(int i = 3; i <= n; i++){
      res = n_1 + n_2; // to reach this step total ways = (n minus 1) + (n minus 2)
      n_1 = n_2; // as we move ahead n-1 & n-2 shifts
      n_2 = res;
    }
    return res;
  }

  public static void main(String[] args) {

  }
}
