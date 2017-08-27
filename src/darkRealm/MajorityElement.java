package darkRealm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public static int majorityElement(int[] nums) {
    if (nums == null || 0 == nums.length) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int major = Integer.MIN_VALUE;
    int res = 0;
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
      int currentMajor = Math.max(major, map.get(n));
      if (currentMajor > major) {
        major = currentMajor;
        res = n;
      }
    }
    return res;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1};
    int[] nums = new int[]{6, 5, 5};
    int res = majorityElement(nums);
    System.out.println("Nums : " + Arrays.toString(nums));
    System.out.println("Maj  : " + res);
  }
}
