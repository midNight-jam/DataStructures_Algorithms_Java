package darkRealm;

import java.util.Arrays;
import java.util.List;

public class CountSmallerNumberAfterSelf {

//  #315. Count of Smaller Numbers After Self   :::   Complexity  - Time : search O(LogN)   - Space : O(N)
//  You are given an integer array nums and you have to return a new counts array. The counts array has the property
//  where counts[i] is the number of smaller elements to the right of nums[i].//
//  Example:
//  Given nums = [5, 2, 6, 1]
//  To the right of 5 there are 2 smaller elements (2 and 1).
//  To the right of 2 there is only 1 smaller element (1).
//  To the right of 6 there is 1 smaller element (1).
//  To the right of 1 there is 0 smaller element.
//  Return the array [2, 1, 1, 0].

  static class TreeNode {
    int val, smallCount, dupCount;
    TreeNode left, right;

    TreeNode(int v, int s, int d) {
      val = v;
      smallCount = s;
      dupCount = d;
    }
  }

  public static List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    Integer[] res = new Integer[nums.length];
    TreeNode root = null;
    // Intuition is to built a BST from the array by scanning it from right to left, so we insert end elements first,
    // But the BST nodes now will also track the dup count and the small count. smallcount means the no of nodes smaller than
    // itself, and dupcount if the input contiains duplicate then for it.
    root = build(root, res, nums.length - 1, nums[nums.length - 1], 0);
    for (int i = nums.length - 2; i >= 0; i--)
      build(root, res, i, nums[i], 0);

    return Arrays.asList(res);
  }

  private static TreeNode build(TreeNode node, Integer [] res, int index, int num, int runningSmallCount) {
    if (node == null) {
      node = new TreeNode(num, 0, 1); // dupCount count as one, counting it self
      res[index] = runningSmallCount; // whatever the runningSmallCount is create new node with that
    } else if (node.val == num) {
      node.dupCount++;
      res[index] = runningSmallCount + node.smallCount; // why we are taking here nodesmallCount in sum, bcoz for ex
      // the array is 2,1,4,2, now when firs time the 2 was inserted its small count was 0, but after inserting 1, its
      // small count is 0+1, now when the 2nd 2 comes if we just take account of running small count it will be 1, which will
      // be wrong , thus we add
    } else if (num < node.val ) {
      node.smallCount++;  // if we are moving left, we just increase the small count of this node, bcoz the new element
      // getting inserted is smaller then this node
      node.left = build(node.left, res, index, num, runningSmallCount);
    } else {
      // if we are moving right, we have to take account to small Counts of the left subtree of the node from which
      // we are moving right, thus we are adding the nodes smallcount and the dupCount to the runningSmallCount
      node.right = build(node.right, res, index, num, runningSmallCount + node.dupCount + node.smallCount);
    }
    return node;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{5, 2, 6, 1};
    int[] nums = new int[]{3, 2, 2, 6, 1};
    List<Integer> res = countSmaller(nums);
    System.out.println(res);
  }
}
