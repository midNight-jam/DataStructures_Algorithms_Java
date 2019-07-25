package darkRealm;

import java.util.ArrayList;
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

    TreeNode(int v) {
      val = v;
      dupCount = 1;
    }
  }

  static TreeNode root;

  public static List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length < 1) return new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    // Intuition is to built a BST from the array by scanning it from right to left, so we insert end elements first,
    // But the BST nodes now will also track the dup count and the small count. smallcount means the no of nodes smaller than
    // itself, and dupcount if the input contiains duplicate then for it.
    for (int i = nums.length - 1; i >= 0; i--) {
      root = insert(nums[i], root, res, 0);
    }
    return res;
  }

  private static TreeNode insert(int n, TreeNode root, List<Integer> res, int runningSmallCount) {
    if (root == null) {
      res.add(0, runningSmallCount); // add runningSmallCount to head
      return new TreeNode(n); // dupCount count as one, counting it self
    } else if (root.val == n) {
      root.dupCount++;
      res.add(0, runningSmallCount + root.smallCount);
      // why we are taking here nodesmallCount in sum, bcoz for ex
      // the array is 2,1,4,2, now when firs time the 2 was inserted its small count was 0, but after inserting 1, its
      // small count is 0+1, now when the 2nd 2 comes if we just take account of running small count it will be 1, which
      // will be wrong , thus we add
    } else if (root.val > n) {
      root.smallCount++;// if we are moving left, we just increase the small count of this node, bcoz the new element
      // getting inserted is smaller then this node
      root.left = insert(n, root.left, res, runningSmallCount);
    } else {
      // if we are moving right, we have to take account to small Counts of the left subtree of the node from which
      // we are moving right, thus we are adding the nodes smallcount and the dupCount to the runningSmallCount
      int nodesInLeftSubTree = runningSmallCount + root.smallCount + root.dupCount;
      root.right = insert(n, root.right, res, nodesInLeftSubTree);
    }

    return root;
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{5, 2, 6, 1};
//    int[] nums = new int[]{3, 2, 2, 6, 1};
    int[] nums = new int[]{0, 5, 5, 6, 1};
    List<Integer> res = countSmaller(nums);
    System.out.println(res);
  }
}
