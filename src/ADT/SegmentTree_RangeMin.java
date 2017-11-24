package ADT;

public class SegmentTree_RangeMin {

  //  Time Complexity :  Building - O(N) , Searching - O(logN)
  // Space Complexity : O(2^H), where H is the least height of binary tree which will give N leaf nodes

  class SegmentTreeNode {
    Integer val;
    int from;
    int to;
  }

  SegmentTreeNode[] nodes;
  int size;
  int n;

  SegmentTree_RangeMin(int[] nums) {
    n = nums.length;
    int height = (int) Math.ceil(Math.log(n) / Math.log(2));
    size = (int) Math.pow(2, height + 1) - 1;
    nodes = new SegmentTreeNode[size];
    constructSegmentTree(nums, 0, n - 1, 0);
  }

  private int constructSegmentTree(int[] nums, int from, int to, int index) {
    if (from < 0 || to >= n || to < from) return 0;

    // create the node
    SegmentTreeNode node = new SegmentTreeNode();
    node.from = from;
    node.to = to;
    nodes[index] = node;
    // if range is 1 width, assign value
    if (from == to) {
      nodes[index].val = nums[from];
      return nodes[index].val;
    }
    // recurse bottom up and get the min among the two childs
    int mid = from + (to - from) / 2;
    int min = Math.min(constructSegmentTree(nums, from, mid, 2 * index + 1),
        constructSegmentTree(nums, mid + 1, to, 2 * index + 2));
    nodes[index].val = min;
    return nodes[index].val;
  }

  public int getMin(int queryFrom, int queryTo) {
    if (queryFrom < 0 || queryTo >= n || queryFrom > queryTo) return Integer.MAX_VALUE;
    return getMin_helper(0, queryFrom, queryTo, 0, n - 1);
  }

  private int getMin_helper(int index, int queryFrom, int queryTo, int from, int to) {
    if (queryTo < from || queryFrom > to) return Integer.MAX_VALUE;
    if (from >= queryFrom && to <= queryTo) return nodes[index].val;
    int mid = from + (to - from) / 2;
    return Math.min(getMin_helper(2 * index + 1, queryFrom, queryTo, from, mid),
        getMin_helper(2 * index + 2, queryFrom, queryTo, mid + 1, to));
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 3, 5, 7, 9, 11};
//    int[] nums = new int[]{5, 3, 9, 1, 7, 11};
    int[] nums = new int[]{2, 5, 1, 4, 9, 3};
    SegmentTree_RangeMin segTree = new SegmentTree_RangeMin(nums);
    for (SegmentTreeNode node : segTree.nodes)
      System.out.print(node == null ? "__" : node.val + " ");
//    int res = segTree.getMin(0, -1);
//    int res = segTree.getMin(-1, 0);
//    int res = segTree.getMin(5, 6);
//    int res = segTree.getMin(0, 0);
//    int res = segTree.getMin(1, 1);
//    int res = segTree.getMin(2, 2);
//    int res = segTree.getMin(3, 3);
//    int res = segTree.getMin(4, 4);
//    int res = segTree.getMin(5, 5);
//    int res = segTree.getMin(0, 5);
//    int res = segTree.getMin(0, 2);
//    int res = segTree.getMin(1, 3);
    int res = segTree.getMin(4, 5);
    System.out.println("\n R : " + res);
  }
}
