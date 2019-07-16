package darkRealm;

public class WiggleSort {

//  #280. Wiggle Sort
//  Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
//  For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

  public static void wiggleSort(int[] nums) {
    // problem in short is to arrange the nos in a way such that Odd positions have bigger nos
    // and even positions have smaller nos, so to achieve this we swap nos when they violate above
    // conditions
    if(nums == null || nums.length < 1) return;
    for(int i = 1; i < nums.length; i++){
      if((i & 1) == 0){
      // even will be small
        if(nums[i] > nums[i-1]){
          int t = nums[i-1];
          nums[i - 1] = nums[i];
          nums[i] = t;
        }
      }
      else{
      // odd will be bigger
        if(nums[i] < nums[i-1]){
          int t = nums[i-1];
          nums[i - 1] = nums[i];
          nums[i] = t;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 5, 2, 1, 6, 4};
    for (int n : nums)
      System.out.print(n + " ");
    wiggleSort(nums);
    System.out.println("\nwiggled");
    for (int n : nums)
      System.out.print(n + " ");
    System.out.println("");
  }
}
