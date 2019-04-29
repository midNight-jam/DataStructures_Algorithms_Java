package darkRealm;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumSizeSubarraySum {

  public static int minSubArrayLen(int s, int[] nums) {
    Queue<Integer> que = new LinkedList<>();
    int sum = 0;
    int index = 0;
    int res = Integer.MAX_VALUE;

    while (index < nums.length) {
      while (index < nums.length && sum < s) {
        sum += nums[index];
        que.offer(nums[index]);
        index++;
      }
      while (sum >= s && que.size() > 0) {
        res = Math.min(res, que.size());
        sum -= que.poll();
      }
    }
    while (sum >= s && que.size() > 0) {
      res = Math.min(res, que.size());
      sum -= que.poll();
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public static void main(String[] args) {
    int s = 4;
    int[] nums = new int[]{2, 3, 1, 2, 4, 3};

//    int s = 1;
//    int[] nums = new int[]{0, 0, 0, 1, 0};
    int res = minSubArrayLen(s, nums);
    System.out.println(res);
  }
}
