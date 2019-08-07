package darkRealm;

public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int res = Integer.MIN_VALUE;
    int sum = 0;
    // if at any time sum goes -ve, reset it
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      res = Math.max(res, sum);
      if (sum < 0)
        sum = 0;
    }

    return res;
  }

  public static void main(String[] args) {

  }

}
