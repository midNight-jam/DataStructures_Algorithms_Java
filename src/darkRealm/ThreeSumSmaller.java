package darkRealm;

import java.util.Arrays;

public class ThreeSumSmaller {


//  #259. 3Sum Smaller
//  Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//  For example, given nums = [-2, 0, 1, 3], and target = 2.
//  Return 2. Because there are two triplets which sums are less than 2:
//      [-2, 0, 1]
//      [-2, 0, 3]


  public static int threeSumSmaller(int[] nums, int target) {
    if(nums == null || nums.length < 3) return 0;
    // Similar to traingle number problem, we reduce the triplet to triangle no by moving one of the triplet of sum from LHS to RHS
    // nums[i] + nums[j] + nums[k] < target  === reduced to ====  nums[i] + nums[j] <  target - nums[k] 
    Arrays.sort(nums);
    int low;
    int high;
    int k;
    int res = 0;
    for(int i = 2; i < nums.length; i++){
      low = 0;
      high = i - 1;
      k = target - nums[i];
      while(low < high){
        if(nums[low] + nums[high] < k){
          res += high - low;  // count the no of sliding windows that generate a pair who has sum less than k (target - nums[i])
          low++;
        }
        else
          high--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int [] nums = new int[]{-1,-1,1,-1};
    int target = -1;
    int res = threeSumSmaller(nums, target);
    System.out.println("R : " + res);
  }

}
