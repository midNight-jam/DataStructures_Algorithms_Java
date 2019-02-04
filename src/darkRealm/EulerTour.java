package darkRealm;

import java.util.Arrays;

public class EulerTour {

  private static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
      val = v;
    }
  }

  int[] eulerTour;
  int index;

  // N : no of nodes in the tree
  public int[] EulerTour(TreeNode root, int N) {
    // euler tour is always odd, nth odd no
    int eulerTourLength = 2 * N - 1;
    eulerTour = new int[eulerTourLength];
    index = 0;
    dfsEuler(root);
    return eulerTour;
  }

  private TreeNode dfsEuler(TreeNode root) {
    if (root == null) return null;
    eulerTour[index++] = root.val;

    TreeNode leftChild = dfsEuler(root.left);
    if (leftChild != null)
      eulerTour[index++] = root.val;

    TreeNode rightChild = dfsEuler(root.right);
    if (rightChild != null)
      eulerTour[index++] = root.val;

    return root;
  }


  // N : no of nodes in the tree
  public int[] EulerTour(int[] tree, int node, int N) {
    // euler tour is always odd, nth odd no
    int eulerTourLength = 2 * N - 1;
    eulerTour = new int[eulerTourLength];
    index = 0;
    dfsEuler(tree, node);
    return eulerTour;
  }

  private int dfsEuler(int[] tree, int node) {
    if (node >= tree.length || tree[node] == -1) return Integer.MAX_VALUE;
    eulerTour[index++] = tree[node];

    int leftChild = dfsEuler(tree, 2 * node + 1);
    if (leftChild != Integer.MAX_VALUE)
      eulerTour[index++] = tree[node];

    int rightChild = dfsEuler(tree, 2 * node + 2);
    if (rightChild != Integer.MAX_VALUE)
      eulerTour[index++] = tree[node];

    return tree[node];
  }

  public static void main(String[] args) {

    // Euler tour using TreeNode Struct
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
//    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    EulerTour et = new EulerTour();
    int[] res = et.EulerTour(root, 6);
    System.out.println(Arrays.toString(res));


    // Euler tour using flat tree in array
    // -1 denotes its not a child : child is null
    int[] tree = new int[]{1, 2, 3, 4, 5, -1, 7};
    res = et.EulerTour(tree, 0, 6);
    System.out.println(Arrays.toString(res));
  }
}
