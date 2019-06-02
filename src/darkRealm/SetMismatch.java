package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

//  The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in
//  the set got duplicated to another number in the set, which results in repetition of one number and loss of another
//  number.
//  Given an array nums representing the data status of this set after the error. Your task is to firstly find the
//  number occurs twice and then find the number that is missing. Return them in the form of an array.
//  Example 1:
//  Input: nums = [1,2,2,4]
//  Output: [2,3]

  public static int[] setMismatch(int[] nums) {
    int [] res = new int[2];
    if(nums == null || nums.length < 1) return res;
    int ni;
    for(int i : nums){
      ni = Math.abs(i);
      if(nums[ni - 1] < 0)
        res[0] = ni;
      else
        nums[ni - 1] *= -1;
    }
    for(int i = 0; i < nums.length; i++)
      if(nums[i] > 0){
        res[1] = i + 1;
        break;
      }
    
    return res;
  }

  public static int[] setMismatchOLD(int[] arr) {
    if (arr == null || 0 == arr.length) return new int[]{};
    int[] res = new int[2];
    Set<Integer> set = new HashSet<>();
    int sum = (arr.length * (arr.length + 1)) / 2;
    for (int i = 0; i < arr.length; i++)
      if (!set.contains(arr[i])) {
        set.add(arr[i]);
        sum -= arr[i];
      } else
        res[0] = arr[i];
    res[1] = sum;
    return res;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{1, 2, 3, 4};
//    int[] arr = new int[]{1, 2, 4, 4};
//    int[] arr = new int[]{1, 2, 4, 4, 5};
//    int[] arr = new int[]{2, 2};
//    int[] arr = new int[]{1, 1};
    int[] arr = new int[]{2, 3, 2};
//    int[] arr = new int[]{3, 2, 2};
//    int[] arr = new int[]{3, 2, 3};
//    int[] arr = new int[]{1, 3, 3, 4};
//    int[] arr = new int[]{2, 2, 3, 4};
    System.out.println("Arr : " + Arrays.toString(arr));
    int[] res = setMismatch(arr);
    System.out.println("Res : " + Arrays.toString(res));
  }
}
