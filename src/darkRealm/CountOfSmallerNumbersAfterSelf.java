package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

  public static List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<>();

    if (nums == null || nums.length < 1) return res;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int n : nums)
      min = Math.min(min, n);

    int[] indexArr = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      indexArr[i] = nums[i] - min + 1;
      max = Math.max(max, indexArr[i]);
    }

    int[] bit = new int[max + 1];

    for (int i = nums.length - 1; i > -1; i--) {
      res.add(0, get(indexArr[i] - 1, bit));
      update(indexArr[i], bit);
    }

    return res;
  }

  public static void update(int index, int[] bit) {
    while (index < bit.length) {
      bit[index]++; // rather than storing sum we increment the val at index, denoting that a no has appeared 2ce/3ce etc...
      index += index & -index;
    }
  }

  public static int get(int index, int[] bit) {
    int sum = 0;
    while (index > 0) {
      sum += bit[index];
      index -= index & -index;
    }
    return sum;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{5, 2, 6, 1};
    int[] nums = new int[]{-1,-1};
    List<Integer> res = countSmaller(nums);
    System.out.println(res);
  }
}
