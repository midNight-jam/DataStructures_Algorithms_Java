package darkRealm;

public class PaintHouse {

//  #256. Paint House ::: Complexity : Time - O(n^2), Space - O(1)
//  There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost
//  of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent
//  houses have the same color.
//  The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0]
//  is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and
//  so on... Find the minimum cost to paint all houses.
//  Note:
//  All costs are positive integers.

  public static int minCost(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
    int minCost = 0;
    // Intuition is to begin from second row borrow the min of the 2 other cols from above and add its minimum to keep
    // track of min cost till now, why we take min from 2 other cols bcoz no tow houses can be painted with same color
    // for example, costs for 2 houses in rgb are as below
    //      [2, 3, 4]
    //      [5, 1, 2]
    // then for 5, we take Min between 3 and 4, which is 3 and we add it to cost of 5 so it becomes 5 + 3 = 8
    // same for 1, we take Min between 2 and 4, which is 2 and we add it to cost of 1 so it becomes 1 + 2 = 3
    // then for 2, we take Min between 2 and 3, which is 2 and we add it to cost of 2 so it becomes 2 + 2 = 4
    // Finally we take the min from the last row for minCost
    for (int i = 1; i < costs.length; i++) {
      costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
    }
    int lastRow = costs.length - 1;
    minCost = Math.min(Math.min(costs[lastRow][0], costs[lastRow][1]), costs[lastRow][2]);
    return minCost;
  }

  public static void main(String[] args) {
//    int[][] nums = new int[][]{
//        {20, 18, 4},
//        {9, 9, 10},
//    };

    int[][] nums = new int[][]{
        {5, 8, 6},
        {19, 14, 13},
        {7, 5, 12},
        {14, 15, 17},
        {3, 20, 10},
    };
    int res = minCost(nums);
    System.out.println("C : " + res);
  }
}
