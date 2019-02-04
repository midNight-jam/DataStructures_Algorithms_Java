package ADT;

import java.util.Arrays;

//Segment Tree for Range Sum
public class SegmentTree {

  int[] arr;
  int[] seg_tree;
  int N;

  SegmentTree(int[] arr) {
    this.arr = arr;
    N = arr.length;

    // Height of a full binary tree which can accomodate N nodes is LOG_base2_N + 1
    int height = (int) Math.floor((Math.log(N) / Math.log(2))) + 1;

    // Max no of nodes in full Binary tree are (2^(height+1) - 1)
    int no_of_nodes = (int) Math.pow(2, height + 1) - 1;
    seg_tree = new int[no_of_nodes];

    // kick off the construction of seg tree
    build(0, 0, N - 1);
  }

  private void build(int node, int start, int end) {
    if (start == end) {
      seg_tree[node] = arr[start];  // its a leaf node, take the value from input arr
      return;
    }
    int mid = start + (end - start) / 2;

    // as seg tree is a binary tree
    int leftChild = 2 * node + 1;
    int rightChild = 2 * node + 2;
    // recurse for left child
    build(leftChild, start, mid);
    // recurse for right child
    build(rightChild, mid + 1, end);

    seg_tree[node] = seg_tree[leftChild] + seg_tree[rightChild];
  }

  public void update(int index, int val) {
    int diff = val - arr[index];
    updateHelper(0, 0, N - 1, index, diff);
  }

  // Complexity of update O(logN)
  private void updateHelper(int node, int start, int end, int index, int diff) {
    if (start == end) {
      arr[index] += diff;
      seg_tree[node] += diff;
      return;
    }

    int mid = start + (end - start) / 2;

    // if updating value in left subtree
    if (start <= index && index <= mid)
      updateHelper((2 * node) + 1, start, mid, index, diff);

      // if updating value in right subtree
    else
      updateHelper((2 * node) + 2, mid + 1, end, index, diff);

    // update the segtree while returning from recursion
    seg_tree[node] = seg_tree[2 * node + 1] + seg_tree[2 * node + 2];
  }

  public int query(int left, int right) {
    return queryHelper(0, 0, N - 1, left, right);
  }

  // Complexity of query O(logN)
  private int queryHelper(int node, int start, int end, int left, int right) {
    // query out of this range
    if (left > end || right < start)
      return 0;

    // query within range, then we are at correct node, return res
    if (left <= start && end <= right)
      return seg_tree[node];

    // query partially within range, get the partial results from left & right child, sum them & return
    int mid = start + (end - start) / 2;

    int subRes1 = queryHelper(2 * node + 1, start, mid, left, right);
    int subRes2 = queryHelper(2 * node + 2, mid + 1, end, left, right);
    return subRes1 + subRes2;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{1, 3, 5};
//    int[] arr = new int[]{1, 3, 5, 7};
    int[] arr = new int[]{1, 3, 5, 7, 9, 11};
    SegmentTree segTree = new SegmentTree(arr);
    System.out.println(Arrays.toString(segTree.seg_tree));
    System.out.println(Arrays.toString(arr));
    int res;

    segTree.update(1, 6);
    segTree.update(5, 0);
    segTree.update(0, -5);
    System.out.println(Arrays.toString(arr));
    for (int re = arr.length - 1; re > -1; re--) {
      for (int le = 0; le <= re; le++) {
        res = segTree.query(le, re);
        System.out.println(le + ":" + re + " = " + res);
      }
    }
  }
}
