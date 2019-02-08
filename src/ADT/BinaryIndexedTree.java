package ADT;

public class BinaryIndexedTree {

  int[] arr;
  int[] bit;
  int N;

  BinaryIndexedTree(int[] arr) {
    if (arr == null || arr.length < 1) return;
    this.arr = arr;
    bit = new int[arr.length + 1]; // N + 1, bcoz we ignore bit[0] : think of it as a root place holder but no value
    N = arr.length;
    constructBinaryIndexedTree();
  }

  // Time COmplexity O(NlogN)
  private void constructBinaryIndexedTree() {
    for (int i = 1; i <= N; i++)
      update(i, arr[i - 1]);
  }

  // TimeComplexity O(LogN) as we loop only as many times as the 1 bits in the index
  public void update(int index, int val) {
    // Get the last set bit in an integer
    // Example: x = 10(in decimal) = 1010(in binary)
    // The last set bit is given by x&(-x) = (10)1(0) & (01)1(0) = 0010 = 2 (in decimal)

    while (index <= N) {
      bit[index] += val;
      index += (index & -index);
    }
  }

  // TimeComplexity O(LogN) as we loop only as many times as the 1 bits in the index
  public int query(int index) {
    int sum = 0;
    while (index > 0) {
      sum += bit[index];
      index -= (index & -index);
    }
    return sum;
  }

  public int queryRange(int start, int end) {
    //exclude any sum before start
    return query(end) - query(start - 1);
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    BinaryIndexedTree bit = new BinaryIndexedTree(nums);
    for (int i = 1; i <= nums.length; i++)
      System.out.println("Index : " + i + " Sum : " + bit.query(i));

    int res;
    for (int re = nums.length; re > 0; re--) {
      for (int le = 1; le <= re; le++) {
        res = bit.queryRange(le, re);
        System.out.println((le) + ":" + (re) + " = " + res);
      }
    }
  }
}
