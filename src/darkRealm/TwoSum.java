package darkRealm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    int[] res = null;
    if (nums == null || nums.length < 1) return res;

    Map<Integer, Integer> map = new HashMap<>();
    int diff;
    for(int i = 0; i < nums.length; i++){
      diff = target - nums[i];
      if(map.containsKey(diff)){
        res = new int[2];
        res[0] = map.get(diff);
        res[1] = i;
        return res;
      }
      map.put(nums[i], i);
    }
    return res;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{2, 7, 11, 15};
//    int target = 9;
    int[] nums = new int[]{3, 2, 4};
    int target = 6;
    int[] res = twoSum(nums, target);
    System.out.println(Arrays.toString(res));
  }
}
