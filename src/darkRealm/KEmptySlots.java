package darkRealm;

import java.util.Arrays;

public class KEmptySlots {
//  #683. K Empty Slots
//  There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
//  Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.
//  For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.
//  Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.
//  Example 1:
//  Input:
//  flowers: [1,3,2]
//  k: 1
//  Output: 2
//  Explanation: In the second day, the first and the third flower have become blooming.
//  Example 2:
//  Input:
//  flowers: [1,2,3]
//  k: 1
//  Output: -1

  public static int kEmptySlots(int[] flowers, int k) {
    int[] days = new int[flowers.length];
    // mark for the days on which the ith flower will start blooming
    for (int i = 0; i < flowers.length; i++)
      days[flowers[i] - 1] = i + 1; // i + 1 because the flowers are nor 0 indexed
    // now we have to find a window that is K+1 size broad and satisfies
    // days[left] <  days[i]  --> means that flower on left have started blooming
    // days[right] < days[i] --> means flower on right also have started blooming
    // and as on i , the window is k+1 broad and both left & right have bloomed the ith should not have bloomed
    // if so we return the result.
    int left = 0, right = k + 1;
    int res = Integer.MAX_VALUE;
    for (int i = 0; right < flowers.length; i++) {
      if (days[left] > days[i] || days[right] >= days[i])// shift the window because this is not valid for use we need the above condition
      {
        if (i == right) {
          res = Math.min(res, Math.max(days[left], days[right]));// why are we getting the flower number
        }
        left = i;
        right = i + k + 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] flowers = new int[]{1, 3, 2};
//    int[] flowers = new int[]{1, 3, 2};
    int k = 1;
    int res = kEmptySlots(flowers, k);
    System.out.println("F : " + Arrays.toString(flowers) + "\nR : " + res);
  }
}