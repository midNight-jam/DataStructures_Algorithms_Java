package darkRealm;

public class SortedToBST {

//  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode getRoot(int[] arr, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = getRoot(arr, low, mid - 1);
    node.right = getRoot(arr, mid + 1, high);
    return node;
  }

  public static TreeNode convertSortedToBST(int[] arr) {
    if (null == arr || 0 == arr.length) return null;
    return getRoot(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3};
    TreeNode root = convertSortedToBST(arr);
    System.out.println("Root : " + root);
  }
}
