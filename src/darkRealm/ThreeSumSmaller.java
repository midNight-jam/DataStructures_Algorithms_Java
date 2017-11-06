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
    if(nums == null || nums.length  == 0) return 0;
    int l, h;
    Arrays.sort(nums);
    int triplet = 0;
    for(int i = 0; i < nums.length - 2; i++){
      l = i + 1;
      h = nums.length - 1;
      while(l < h){
        if(nums[i] + nums[l] + nums[h] < target){
          triplet += h - l; // because all in this range will create a triplet smaller than target
          l++;
        }
        else h--;
      }
    }
    return triplet;
  }

  public static void main(String[] args) {
    int [] nums = new int[]{-1,-1,1,-1};
    int target = -1;
    int res = threeSumSmaller(nums, target);
    System.out.println("R : " + res);
  }

}
