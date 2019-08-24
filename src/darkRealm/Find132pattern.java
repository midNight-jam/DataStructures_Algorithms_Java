package darkRealm;

import java.util.Stack;

public class Find132pattern {


// 456. 132 Pattern
// Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
// Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
// Note: n will be less than 15,000.
// Example 1:
// Input: [1, 2, 3, 4]
// Output: False
// Explanation: There is no 132 pattern in the sequence.
// Example 2:
// Input: [3, 1, 4, 2]
// Output: True
// Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
// Example 3:
// Input: [-1, 3, 2, 0]
// Output: True
// Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
  
  public static boolean find132pattern(int[] nums) {
    if(nums == null || nums.length < 3 ) return false;
    
    // the idea of 132 pattern is first try to find the max number which is on the right side of a 
    // big num i.e fid the biggest 2 on right of 3 then find any 1 which is smaller than this biggest 2
    
    int secondMax = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<>();
    for(int i = nums.length - 1; i >= 0; i--){
      if(nums[i] < secondMax) return true;

      while(stack.size() > 0 && nums[i]> stack.peek() ){
        secondMax = Math.max(secondMax, stack.pop());
      }

      stack.push(nums[i]);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-2, 1, 2, -2, 1, 2};
    boolean res = find132pattern(nums);
    System.out.println(res);
  }
}
