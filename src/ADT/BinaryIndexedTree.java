package ADT;

public class BinaryIndexedTree {

  int[] arr;
  int[] bitTree;
  int N;

  BinaryIndexedTree(int[] nums) {
    if(nums == null || nums.length < 1) return;
    arr = new int[nums.length];
    N = arr.length;
    bitTree = new int[nums.length + 1];// N + 1, bcoz we ignore bit[0] : think of it as a root place holder but no value
    for(int i = 0; i < arr.length; i++){
      updateBit(i, nums[i]);
      arr[i] = nums[i];
    }
  }

  // Time COmplexity O(NlogN)
   private void updateBit(int index, int val){
    // Get the last set bit in an integer
    // Example: x = 10(in decimal) = 1010(in binary)
    // The last set bit is given by x&(-x) = (10)1(0) & (01)1(0) = 0010 = 2 (in decimal)

    index += 1;
    while(index <= arr.length){
      bitTree[index] += val;
      index += index & (-index);
    }
  }

   public void update(int i, int val) {
    int diff = val - arr[i];
    arr[i] = val;
    updateBit(i, diff);
  }

  // TimeComplexity O(LogN) as we loop only as many times as the 1 bits in the index
  private int query(int index){
     index += 1;
    int sum = 0;
    while(index > 0){
      sum += bitTree[index];
      index -= index & (-index);
    }
    
    return sum;
  }

 public int sumRange(int i, int j) {
   //exclude any sum before start
    return query(j) - query(i - 1);
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] nums = new int[]{5, 4, 3, 2, 1};
    BinaryIndexedTree bit = new BinaryIndexedTree(nums);
    for (int i = 1; i <= nums.length; i++)
      System.out.println("Index : " + i + " Sum : " + bit.query(i));

    int res;
    for (int re = nums.length; re > 0; re--) {
      for (int le = 1; le <= re; le++) {
        res = bit.sumRange(le, re);
        System.out.println((le) + ":" + (re) + " = " + res);
      }
    }
  }
}
