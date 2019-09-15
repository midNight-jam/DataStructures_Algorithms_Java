package ADT;

import java.util.Arrays;

//Segment Tree for Range Sum
public class SegmentTree {

  int[] arr;
  int[] segTree;
  int N;

  SegmentTree(int[] nums) {
      if (nums == null || nums.length < 1) return;

      this.arr = nums;
      N = arr.length;

      // Height of a full binary tree which can accomodate N nodes is LOG_base2_N
      int height = (int) Math.ceil((Math.log(N) / Math.log(2)));

      // Max no of nodes in full Binary tree are (2^(height+1) - 1)
      int no_of_nodes = (int) Math.pow(2, height + 1) - 1;
      segTree = new int[no_of_nodes];

      // kick off the construction of seg tree
      build(0, 0, N - 1);
    }

    private void build(int node, int start, int end) {
      if (start == end) {
        segTree[node] = arr[start];  // its a leaf node, take the value from input arr
        return;
      }
      int leftChild = 2 * node + 1;
      int rightChild = 2 * node + 2;
      int mid = start + (end - start) / 2;
      build(leftChild, start, mid);
      build(rightChild, mid + 1, end);
      segTree[node] = segTree[leftChild] + segTree[rightChild];
    }

    public void update(int index, int val) {
      if (index < 0 || index >= arr.length) return;
      int diff = val - arr[index];
      updateSegTree(0, 0, N - 1, index, diff);
    }

    // Complexity of update O(logN)
    private void updateSegTree(int node, int start, int end, int index, int diff) {
      if (start == end) {
        arr[index] += diff;
        segTree[node] += diff;
        return;
      }

      int mid = start + (end - start) / 2;
      int leftChild = 2 * node + 1;
      int rightChild = 2 * node + 2;

      // if updating value in left subtree
      if (index <= mid)
        updateSegTree(leftChild, start, mid, index, diff);

        // if updating value in right subtree
      else
        updateSegTree(rightChild, mid + 1, end, index, diff);

      // update the segtree while returning from recursion
      segTree[node] = segTree[leftChild] + segTree[rightChild];
    }

    public int sumRange(int left, int right) {
      if (right < left) return 0;
      return queryHelper(0, 0, N - 1, left, right);
    }


    // Complexity of query O(logN)
    private int queryHelper(int node, int start, int end, int left, int right) {
      // query out of this range
      if (left > end || right < start)
        return 0;

      // this range is within query,  so it will contribute to the result
      if (left <= start && end <= right)
        return segTree[node];

      // query partially within range, get the partial results from left & right child, sum them & return
      int mid = start + (end - start) / 2;
      int leftChild = 2 * node + 1;
      int rightChild = 2 * node + 2;

      int subRes1 = queryHelper(leftChild, start, mid, left, right);
      int subRes2 = queryHelper(rightChild, mid + 1, end, left, right);
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
