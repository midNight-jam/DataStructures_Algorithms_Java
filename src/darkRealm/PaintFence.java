package darkRealm;

public class PaintFence {

//  #276. Paint Fence   :::   Complexity  -  Time : O(n),   Space : O(2n)
//  There is a fence with n posts, each post can be painted with one of the k colors.
//  You have to paint all the posts such that no more than two adjacent fence posts have the same color.
//  Return the total number of ways you can paint the fence.
//  Note:
//  n and k are non-negative integers.

  public static int numWays(int n, int k) {
    if (n == 0 || k == 0) return 0;
    if (n == 1) return k;
    int[] same = new int[n + 1];
    int[] diff = new int[n + 1];
    // the base case for first state is for n == 2, if we paint both same there are k ways of doing so
    // and if paint differently, there are k * (k - 1) ways of doing so, hence we initialize it same
    same[2] = k;
    diff[2] = k * (k - 1);

    // now moving forward, if prev 2 were painted same, then this fence we have to paint differently, thus (k - 1),
    // which can come from diff[i-1] and if we paint diff, then we have same paint * (k - 1) + diff paint * (k - 1)
    for (int i = 3; i <= n; i++) {
      same[i] = diff[i - 1];
      diff[i] = same[i - 1] * (k - 1) + diff[i - 1] * (k - 1);
    }
    return same[n] + diff[n];
  }

  public static void main(String[] args) {
    int n = 4, k = 3;
    int res = numWays(n, k);
    System.out.println("R : " + res);
  }
}
