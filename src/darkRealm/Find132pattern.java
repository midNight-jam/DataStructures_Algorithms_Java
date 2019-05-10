package darkRealm;

import java.util.Stack;

public class Find132pattern {


  public static boolean find132pattern(int[] nums) {
    if(nums == null || nums.length < 3 ) return false;
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
