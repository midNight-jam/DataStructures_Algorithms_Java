package ADT;

import java.util.Arrays;

public class CartesianTree {

  public int[] buildCartesianTree(int[] arr) {
    if (arr == null) return arr;

    int[] parent = new int[arr.length];
    int[] left = new int[arr.length];
    int[] right = new int[arr.length];
    Arrays.fill(parent, -1);
    Arrays.fill(left, -1);
    Arrays.fill(right, -1);

    int root = 0;
    int last;

    // root is its own parent
    parent[root] = root;

    for (int i = 1; i < arr.length; i++) {
      last = i - 1;
      right[i] = -1; // there is no right child of new node

      // find the first smallest value in tree
      while (arr[i] <= arr[last] && last != parent[last]) {
        last = parent[last];
      }

      // current element is smaller than the root, make it a new root & make the old root the left child of new root
      if (arr[i] <= arr[last]) {
        parent[last] = i;
        left[i] = last;
        root = i; // udpate the root
        parent[root] = root; // root doesnt have a parent
      }

      // this is the biggest element just insert it, and make it the new right of last, and parent of current is last
      else if (right[last] == -1) {
        right[last] = i;
        parent[i] = last;
      }

      // the new node will fit in somewhere middle so make the rotation:
      // make the new node right child of last
      // make last the left child of new node
      // update the parent of new node to parent of last
      else {
        int rightOfLast = right[last];
        right[last] = i;
        left[i] = rightOfLast;
        parent[i] = last;
        parent[rightOfLast] = i;
      }
    }

    System.out.println("parent : " + Arrays.toString(parent));
    System.out.println("left   : " + Arrays.toString(left));
    System.out.println("right  : " + Arrays.toString(right));

    return cartesianHelper(arr, root, left, right);
  }

  private int[] cartesianHelper(int[] arr, int root, int[] left, int[] right) {
    int N = arr.length;
    // no of nodes in a complete binary tree with height N (assuming skewed)
    int no_of_nodes = (int) Math.pow(2, N) - 1;
    int[] cartesianTree = new int[no_of_nodes];
    constructTreeFromArrays(0, cartesianTree, arr, root, left, right);
    return cartesianTree;
  }

  private void constructTreeFromArrays(int node, int[] cartesianTree, int[] arr, int root, int[] left, int[] right) {
    if (root == -1) return;

    cartesianTree[node] = arr[root];

    constructTreeFromArrays(2 * node + 1, cartesianTree, arr, left[root], left, right);

    constructTreeFromArrays(2 * node + 2, cartesianTree, arr, right[root], left, right);
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{9, 2, 8, 13, 1, 5, 2, 10, 3};
    int[] arr = new int[]{5, 10, 40, 30, 28};
    CartesianTree ct = new CartesianTree();
    int[] res = ct.buildCartesianTree(arr);
    System.out.println("Cartesian " + Arrays.toString(res));
  }
}
