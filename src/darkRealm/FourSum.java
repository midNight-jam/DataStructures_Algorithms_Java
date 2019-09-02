package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 1) return res;
    int N = nums.length;
    Arrays.sort(nums);
    boolean[] used = new boolean[N];
    for (int i = 0; i + 3 < N; i++) {
      for (int j = i + 1; j + 2 < N; j++) {
        if (nums[j] == nums[i]) continue;
        for (int k = j + 1; k + 1 < N; k++) {
          if (nums[k] == nums[j]) continue;
          int s = nums[i] + nums[j] + nums[k];
          int d = target - s;
          int f = Arrays.binarySearch(nums, d, k + 1, N - 1);
          System.out.println(i + "," + j + "," + k);
          if (f < 0) continue;
          List<Integer> l = new ArrayList<>(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k], nums[f]}));
          res.add(l);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {

    int[] nums = new int[]{1, 0, -1, 0, 2, -2};
    int target = 0;
    List<List<Integer>> res = fourSum(nums, target);
    for (List<Integer> l : res)
      System.out.println(l);
  }
}
