package darkRealm;

public class RangeSumQuery {

//  #307. Range Sum Query - Mutable
//  Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//  The update(i, val) function modifies nums by updating the element at index i to val.
//  Example:
//  Given nums = [1, 3, 5]
//  sumRange(0, 2) -> 9
//  update(1, 2)
//  sumRange(0, 2) -> 8
//  Note:
//  The array is only modifiable by the update function.
//  You may assume the number of calls to update and sumRange function is distributed evenly.

  SegmentTreeNode root;
  int n;

  class SegmentTreeNode {
    int sum, start, end;
    SegmentTreeNode left, right;

    SegmentTreeNode(int v) {
      sum = v;
    }
  }

  RangeSumQuery(int[] nums) {
    if (nums == null || nums.length == 0) return;
    n = nums.length;
    root = construct(nums, 0, nums.length - 1);
  }

  private SegmentTreeNode construct(int[] nums, int start, int end) {
    if (end < start) return null;
    if (start == end) {
      SegmentTreeNode trav = new SegmentTreeNode(nums[start]);
      trav.start = trav.end = start;
      return trav;
    }
    int mid = start + (end - start) / 2;
    SegmentTreeNode left = construct(nums, start, mid);
    SegmentTreeNode right = construct(nums, mid + 1, end);
    int leftSum = left == null ? 0 : left.sum;
    int rightSum = right == null ? 0 : right.sum;
    int sum = leftSum + rightSum;
    SegmentTreeNode here = new SegmentTreeNode(sum);
    here.start = start;
    here.end = end;
    here.left = left;
    here.right = right;
    return here;
  }

  public void update(int i, int val) {
    updateHelper(i, val, root);
  }

  private SegmentTreeNode updateHelper(int i, int val, SegmentTreeNode trav) {
    if (trav.start == trav.end && trav.start == i) {
      trav.sum = val;
      return trav;
    }
    int mid = trav.start + (trav.end - trav.start) / 2;
    if (i <= mid) updateHelper(i, val, trav.left);
    if (i >= mid + 1) updateHelper(i, val, trav.right);
    trav.sum = trav.left.sum + trav.right.sum;
    return trav;
  }

  public int sumRange(int start, int end) {
    if (start < 0 || end >= n) return 0;
    return sumRangeHelper(root, start, end);
  }

  private int sumRangeHelper(SegmentTreeNode trav, int start, int end) {
    if (start == trav.start && end == trav.end) return trav.sum;
    int mid = trav.start + (trav.end - trav.start) / 2;
    if (end <= mid) return sumRangeHelper(trav.left, start, end); // completely on left side
    if (start >= mid + 1) return sumRangeHelper(trav.right, start, end);  // completely on right side
    int res = sumRangeHelper(trav.left, start, mid) + sumRangeHelper(trav.right, mid + 1, end);// spread over
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 5, 7, 9, 11};
    RangeSumQuery root = new RangeSumQuery(nums);
    System.out.println(" " + root);
    int sum = root.sumRange(0, 5);
    System.out.println(sum);
//    root.update(0, 2);
    root.update(5, 2);
    sum = root.sumRange(0, 5);
    System.out.println(sum);
  }
}
