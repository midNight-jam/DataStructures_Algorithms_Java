package darkRealm;

import java.util.Arrays;

public class NextPermutation {

//  #31. Next Permutation   :::   Complexity  -   Time : O(n),    Space : O(1)
//  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//  The replacement must be in-place, do not allocate extra memory.
//  Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//      1,2,3 → 1,3,2
//      3,2,1 → 1,2,3
//      1,1,5 → 1,5,1

  
  public static void nextPermutation(int[] nums) {
    if(nums == null || nums.length < 1) return;
    int k = -1;
    // first, find the first number from behind that is GREATER then its previous
    for(int i = nums.length - 1; i > 0; i--)
      if(nums[i-1] < nums[i]){
        k = i;
        break;
      }
    
    // This means that array is in descenfding
    if( k == -1){
      Arrays.sort(nums);
      return;
    }
    
   // second, find the first number from behind that is GREATER than nums[k-1] & swap
    for(int i = nums.length - 1; i >= 0 ; i--)
      if(nums[i] > nums[k-1]){
        int temp = nums[i];
        nums[i] = nums[k-1];
        nums[k-1] = temp;
        break;
      }
    
    //Reverse the partition from k to end
    int l = k, r = nums.length - 1, temp;
    while(l <= r){
      temp = nums[r];
      nums[r] = nums[l];
      nums[l] = temp;
      l++;
      r--;
    }
  }
  
  public static void nextPermutationOLD(int[] nums) {
    if (nums == null || nums.length == 0) return;
    for (int i = nums.length - 1; i > 0; i--) {
      // first, find the first number from behind that is smaller then its previous
      if (nums[i - 1] < nums[i]) {
        int k = i - 1, l = nums.length - 1;
        // second, find the first number from behind that is greater than nums[k]
        while (nums[l] <= nums[k]) l--;
        // swap k & l
        int t = nums[k];
        nums[k] = nums[l];
        nums[l] = t;
        //Reverse the partition from k + 1 to end
        for (int f = k + 1, b = nums.length - 1; f < b; f++, b--) {
          t = nums[f];
          nums[f] = nums[b];
          nums[b] = t;
        }
        return;
      }
    }
    Arrays.sort(nums);
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 3, 2};
    int[] nums = new int[]{1, 4, 3, 2};
    System.out.println(Arrays.toString(nums));
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }
}
