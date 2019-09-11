package darkRealm;

import java.util.*;

public class SortAPartiallySortedArray {

//  https://leetcode.com/discuss/interview-question/378774/Google-or-Onsite-or-Sort-a-Partially-Sorted-Array
//Given an array of positive integers (possibly with duplicates) such that the numbers have been sorted only by 28 most
// significant bits. Sort the array completely.
//
//  Example 1:
//
//  Input: [0, 15, 12, 17, 18, 19, 33, 32]
//  Output: [0, 12, 15, 17, 18, 19, 32, 33]
//  Explanation:
//  The integers in their binary representation are:
//      0 = 0000 0000 0000 0000 0000 0000 0000 0000
//      15 = 0000 0000 0000 0000 0000 0000 0000 1111
//      12 = 0000 0000 0000 0000 0000 0000 0000 1100
//      17 = 0000 0000 0000 0000 0000 0000 0001 0001
//      18 = 0000 0000 0000 0000 0000 0000 0001 0010
//      19 = 0000 0000 0000 0000 0000 0000 0001 0011
//      33 = 0000 0000 0000 0000 0000 0000 0010 0001
//      32 = 0000 0000 0000 0000 0000 0000 0010 0000
//
//  In sorted order:
//      0 = 0000 0000 0000 0000 0000 0000 0000 0000
//      12 = 0000 0000 0000 0000 0000 0000 0000 1100
//      15 = 0000 0000 0000 0000 0000 0000 0000 1111
//      17 = 0000 0000 0000 0000 0000 0000 0001 0001
//      18 = 0000 0000 0000 0000 0000 0000 0001 0010
//      19 = 0000 0000 0000 0000 0000 0000 0001 0011
//      32 = 0000 0000 0000 0000 0000 0000 0010 0000
//      33 = 0000 0000 0000 0000 0000 0000 0010 0001
//  Example 2:
//
//  Input: [100207, 100205, 100204, 100206, 100203]
//  Output: [100203, 100204, 100205, 100206, 100207]
//  Explanation:
//  The integers in their binary representation are:
//      100207 = 0000 0000 0000 0001 1000 0111 0110 1111
//      100205 = 0000 0000 0000 0001 1000 0111 0110 1101
//      100204 = 0000 0000 0000 0001 1000 0111 0110 1100
//      100206 = 0000 0000 0000 0001 1000 0111 0110 1110
//      100203 = 0000 0000 0000 0001 1000 0111 0110 1011
//
//  In sorted order:
//      100203 = 0000 0000 0000 0001 1000 0111 0110 1011
//      100204 = 0000 0000 0000 0001 1000 0111 0110 1100
//      100205 = 0000 0000 0000 0001 1000 0111 0110 1101
//      100206 = 0000 0000 0000 0001 1000 0111 0110 1110
//      100207 = 0000 0000 0000 0001 1000 0111 0110 1111
//  Expected O(n) time solution.



  /*
  * Intuition is to use bucket sort, where the bucket is chosen bu using the last 4 bits of the number
  * as we only use last 4 bits the bucket can have max 0-15 keys, and as we are sorting in ascending order, we read the
  * bucket from 0 & increasing. The key is also to realise that the bucket sort completes as the the first 28 bits changes
  * */
  public static List<Integer> sort(int nums[]) {
    if (nums == null || nums.length < 1) return new ArrayList<>();
    int first28BitsMask = ~15;
    int curr_28Bits = first28BitsMask & nums[0];
    Map<Integer, List<Integer>> buckets = new HashMap<>();
    List<Integer> sorted = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int mostSig28Bits = (nums[i] & first28BitsMask);
      // most significant 28 bits have changed, thus start sorting again...
      if (mostSig28Bits != curr_28Bits) {
        for (int fi = 0; fi < 16; fi++) {
          if (!buckets.containsKey(fi)) continue;
          sorted.addAll(buckets.get(fi)); // add all nos of this freq to sorted
        }

        curr_28Bits = nums[i] & first28BitsMask;// update to new 28 bits
        buckets = new HashMap<>(); // reset the bucket
      }

      int leastSig28Bits = (nums[i] & 15);
      if (!buckets.containsKey(leastSig28Bits))
        buckets.put(leastSig28Bits, new ArrayList<>());
      buckets.get(leastSig28Bits).add(nums[i]); // update the bucket freq
    }

    for (int fi = 0; fi < 16; fi++) {
      if (!buckets.containsKey(fi)) continue;
      sorted.addAll(buckets.get(fi)); // add all nos of this freq to sorted
    }
    return sorted;
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{0, 15, 12, 17, 18, 19, 33, 32};
    int[] nums = new int[]{100207, 100205, 100204, 100206, 100203};
    List<Integer> res = sort(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println(res);
    System.out.println("@>@ Test here...");
  }
}
