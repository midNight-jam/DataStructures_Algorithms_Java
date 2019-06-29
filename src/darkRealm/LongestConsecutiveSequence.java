package darkRealm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

//  #128. Longest Consecutive Sequence ::: Complexity - O(n)
//  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//  For example,
//  Given [100, 4, 200, 1, 3, 2],
//  The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//  Your algorithm should run in O(n) complexity.

  public static int longestConsecutive(int[] nums) {
    // Intuition is to use a map to keep checking that if a previous or next number has been encountered already, in this
    // map we keep the count of sequence that is present with that key, and when a new no comes we get the previous and
    // next number, get their seqcount and update it against the current number, then we update the current sequence count
    // till the boundary of the current seqeucend on left & right side
    if(nums == null || nums.length < 1) return 0;
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int n : nums){
      if(map.containsKey(n)) continue;
      
      int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
      int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
      
      int thisSeqLen = left + right + 1;
      res = Math.max(res, thisSeqLen);
      map.put(n, thisSeqLen); // update the seq len for this num
      
      // now extend the sequence count to the boundary points also
      // why does nums[i] - left gives us the left boundary, because if ther was a left
      // count means that there exisits a left edge, and if decrement that edges count from current no we will reach that edge
      // lets say 1, 2, 3 were present in map that means against 3 we will have 3 as seqcount, now comes 4, now for left
      // we will get seqCount of 3 , and if we subtract this seqcount from 4 we will get the boundary
      // 4 - 3 == 1 , which is the left boundary.
      
      int leftEdge = n - left;
      map.put(leftEdge, thisSeqLen);
      
      int rightEdge = n + right;
      map.put(rightEdge, thisSeqLen);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 400, 1, 200, 4, 3};
    int res = longestConsecutive(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("L : " + res);
  }
}
