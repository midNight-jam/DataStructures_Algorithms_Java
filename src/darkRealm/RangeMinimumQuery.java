package darkRealm;

import java.util.Arrays;

public class RangeMinimumQuery {

  int[] arr;
  int N;
  int[] segTree;

  RangeMinimumQuery(int[] arr) {
    this.arr = arr;
    N = arr.length;
    // Height of  a tree is LOG_base2_N + 1
    int height = (int) Math.floor((Math.log(N) / Math.log(2))) + 1;
    int no_of_nodes = (int) Math.pow(2, height + 1) - 1;
    segTree = new int[no_of_nodes];
    build(0, 0, N - 1);
  }

  private void build(int node, int start, int end) {
    if (start == end) {
      segTree[node] = arr[start];
      return;
    }

    int mid = start + (end - start) / 2;
    build(2 * node + 1, start, mid);
    build(2 * node + 2, mid + 1, end);

    segTree[node] = Math.min(segTree[2 * node + 1], segTree[2 * node + 2]);
  }

  public int query(int left, int right) {
    return queryHelper(0, 0, N - 1, left, right);
  }

  private int queryHelper(int node, int start, int end, int left, int right) {
    if (left > end || right < start)
      return Integer.MAX_VALUE;

    if (left <= start && end <= right)
      return segTree[node];

    int mid = start + (end - start) / 2;
    int subRes1 = queryHelper(2 * node + 1, start, mid, left, right);
    int subRes2 = queryHelper(2 * node + 2, mid + 1, end, left, right);

    return Math.min(subRes1, subRes2);
  }

  public void update(int index, int val) {
    updateHelper(0, 0, N - 1, index, val);
  }

  private void updateHelper(int node, int start, int end, int index, int val) {
    if (start == end) {
      arr[index] = val;
      segTree[node] = val;
      return;
    }
    int mid = start + (end - start) / 2;
    if (start <= index && index <= mid)
      updateHelper(2 * node + 1, start, mid, index, val);
    else
      updateHelper(2 * node + 2, mid + 1, end, index, val);

    segTree[node] = Math.min(segTree[2 * node + 1], segTree[2 * node + 2]);
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 5, 2, 4, 3};
    RangeMinimumQuery rmq = new RangeMinimumQuery(arr);

    System.out.println(Arrays.toString(rmq.segTree));
    rmq.update(3, 0);
    rmq.update(4, -1);
    rmq.update(0, -2);
    System.out.println(Arrays.toString(arr));

    int res;
    for (int re = arr.length - 1; re > -1; re--) {
      for (int le = 0; le <= re; le++) {
        res = rmq.query(le, re);
        System.out.println(le + ":" + re + " = " + res);
      }
    }
  }
}
