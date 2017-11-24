package ADT;

import java.util.Arrays;

public class SegmentTree_RangeSum {

  //  Time Complexity :  Building - O(N) , Searching - O(logN)
  // Space Complexity : O(2^H), where H is the least height of binary tree which will give N leaf nodes

  private SegmentNode[] nodes;
  private int size;
  private int n;

  // This segment tree is for sum of given range
  class SegmentNode {
    //Here We store the value that will be propagated lazily
    Integer val = null;
    int from; // range from
    int to; // range to

    int size() {
      return to - from + 1;
    }
  }

  public SegmentTree_RangeSum(int[] nums) {
    n = nums.length;
    //Max no of nodes is 2* [2^ceil(Log2(n))] -1
    // Which is the height of tree for having atleast n leaves
    int height = (int)Math.ceil(Math.log(nums.length) / Math.log(2));
    size = (int) Math.pow(2, height  + 1 ) - 1;
    nodes = new SegmentNode[size];  // Segemented tree is represented as a flat tree with childs at 2 * i + 1 and 2 * i + 2
    constructSegmentTree(nums, 0, nums.length - 1, 0);
  }

  private int constructSegmentTree(int[] nums, int from, int to, int index) {
    nodes[index] = new SegmentNode();
    nodes[index].from = from;
    nodes[index].to = to;
    if (from == to) {
      nodes[index].val = nums[from];
      return nodes[index].val;
    }
    int mid = from + (to - from) / 2;
    nodes[index].val = constructSegmentTree(nums, from, mid, 2 * index + 1) +
        constructSegmentTree(nums, mid + 1, to, 2 * index + 2);
    return nodes[index].val;
  }

  public int getSum(int queryFrom, int queryTo) {
    if (queryFrom < 0 || queryTo >= n || queryFrom > queryTo) return Integer.MIN_VALUE;
    return getSum_helper(0, 0, n - 1, queryFrom, queryTo);
  }

  private int getSum_helper(int index, int from, int to, int queryFrom, int queryTo) {
    if (queryFrom <= from && queryTo >= to) return nodes[index].val;  // if this range completely lies within the query
    // range then this will contribute to the result. Ex: query is from 0-4, and this nodes range is from 1-2, then this
    // will contribute to the result.
    if (queryFrom > to || queryTo < from) return 0;
    int mid = from + (to - from) / 2;
    int res = getSum_helper(2 * index + 1, from, mid, queryFrom, queryTo)
        + getSum_helper(2 * index + 2, mid + 1, to, queryFrom, queryTo);
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 5, 7, 9, 11};
//    int[] nums = new int[]{1};
//    int[] nums = new int[]{1,3};
//    int[] nums = new int[]{1, 3, 5};
//    int[] nums = new int[]{1, 3, 5, 7, 9, 11};
//    int[] nums = new int[]{1, 3, 5, 7, 9, 11};
    SegmentTree_RangeSum segTree = new SegmentTree_RangeSum(nums);
    for (SegmentNode n : segTree.nodes)
      System.out.print(n == null ? 0 : n.val + " ");
//    int res = segTree.getSum(-1, 20);
//    int res = segTree.getSum(1, 10);
//    int res = segTree.getSum(0, 5);
    int res = segTree.getSum(0, 4);
//    int res = segTree.getSum(1, 1);
//    int res = segTree.getSum(4, 4);
    System.out.println("\nR : " + res);
  }
}
