package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulArray {

//  932. Beautiful Array
//  For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:
//
//  For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
//  Given N, return any beautiful array A.  (It is guaranteed that one exists.)
//
//  Example 1:
//
//  Input: 4
//  Output: [2,1,4,3]
//  Example 2:
//
//  Input: 5
//  Output: [3,1,2,5,4]
//
//  Note:
//      1 <= N <= 1000

  public static int[] beautifulArray(int N) {
    List<Integer> nums = new ArrayList<>();
    for (int i = 0; i < N; i++)
      nums.add(i+1);
    nums = helper(nums);
    int[] res = new int[N];
    for (int i = 0; i < nums.size(); i++)
      res[i] = nums.get(i);

    return res;
  }

  public static List<Integer> helper(List<Integer> nums) {
    if (nums.size() == 1) return nums;
    List<Integer> odds = new ArrayList<>();
    List<Integer> evens = new ArrayList<>();
    // Add all odd index nums before even indexed nums
    for (int i = 0; i < nums.size(); i++) {
      if (((i + 1) & 1) == 1) odds.add(nums.get(i)); // as i is starting from 0, so to get actual num + 1
      else evens.add(nums.get(i));
    }
    List<Integer> a = helper(odds);
    List<Integer> b = helper(evens);
    a.addAll(b);
    return a;
  }

  public static void main(String[] args) {
    int N = 20;
    int[] res = beautifulArray(N);
    System.out.println(Arrays.toString(res));
  }
}
