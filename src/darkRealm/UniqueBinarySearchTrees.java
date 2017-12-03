package darkRealm;

public class UniqueBinarySearchTrees {

  /*  #96 Unique Binary Search Trees
  * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
  * */
  public static int numTrees(int n) {
    if (n < 1) return 0;
    int[] DP = new int[n + 1];
    DP[0] = DP[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        DP[i] = DP[i] + DP[j - 1] * DP[i - j]; // cartesian product
      }
    }
    return DP[n];
  }

  public static void main(String[] args) {
    int n = 3;
    int res = numTrees(n);
    System.out.println("N : " + n);
    System.out.println("R : " + res);
  }
}