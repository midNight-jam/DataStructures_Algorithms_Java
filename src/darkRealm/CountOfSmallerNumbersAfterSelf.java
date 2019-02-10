package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

  private static List<Integer> countSmallerNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length < 1) return res;

    // reduce the nums array to indexArray as thats how I have understood BIT for creation/update/queries
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int n : nums)
      min = Math.min(min, n);

    int[] reducdedToIndexArray = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int nonZeroIndex = nums[i] - min + 1; // + 1 bcoz in bit we dont want a value to be on root i.e index 0
      reducdedToIndexArray[i] = nonZeroIndex;
      max = Math.max(max, nonZeroIndex); // keep track of max index as that will determine our BIT len
    }

    int[] bit = new int[max + 1];
    for (int i = nums.length - 1; i > -1; i--) {
      // first fetch how many elements smaller than this element are already present in the BIT
      int smallCount = query(reducdedToIndexArray[i] - 1 , bit); // why -1 because excluding self how many smaller are present, if the prob was for <= then we can use same index
      res.add(0, smallCount); // as we are reading the array from behind, the result will get created in reverse order, thus insert at head.
      update(reducdedToIndexArray[i], bit); // insert this value in the BIT
    }
    return res;
  }

  private static void update(int index, int[] bit) {
    while (index < bit.length) {
      bit[index]++;
      index += (index & -index);
    }
  }

  private static int query(int index, int[] bit) {
    int smallCount = 0;
    while (index > 0) {
      smallCount += bit[index];
      index -= (index & -index);
    }
    return smallCount;
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{5, 2, 6, 1};
    int[] nums = new int[]{-1, -1};
    List<Integer> res = countSmallerNumbers(nums);
    System.out.println(res);
  }
}
