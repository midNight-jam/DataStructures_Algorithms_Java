package darkRealm;

public class MaximumBinaryTree {

//  #654. Maximum Binary Tree
//  Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//  The root is the maximum number in the array.
//  The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//  The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//  Construct the maximum tree by the given array and output the root node of this tree.
//      Example 1:
//  Input: [3,2,1,6,0,5]
//  Output: return the tree root node representing the following tree:
//         6
//      /    \
//     3      5
//     \     /
//      2   0
//      \
//      1
//  Note:
//  The size of the given array will be in the range [1,1000].


  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    return helper(nums, 0, nums.length - 1);
  }

  private static TreeNode helper(int[] nums, int left, int right) {
    if (right < left) return null;
    int max = Integer.MIN_VALUE;
    int index = -1;
    for (int i = left; i <= right; i++) {
      if (nums[i] > max) {
        max = Math.max(max, nums[i]);
        index = i;
      }
    }
    TreeNode trav = new TreeNode(nums[index]);
    trav.left = helper(nums, left, index - 1);
    trav.right = helper(nums, index + 1, right);
    return trav;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 1, 6, 0, 5};
    TreeNode root = constructMaximumBinaryTree(nums);
    System.out.println(root.val);
  }
}
