package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


  /*  #15 3Sum
   *  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
   *  in the array which gives the sum of zero.
   *  Note: The solution set must not contain duplicate triplets.
   *  For example, given array S = [-1, 0, 1, 2, -1, -4],
   *  A solution set is:
   *  [
   *  [-1, 0, 1],
   *  [-1, -1, 2]
   *  ]
   *  */
  public static List<List<Integer>> threeSum(int[] arr) {
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(arr); // we go till -2 beacuse those triplets will be counted in inside loop

    // we also dont want to run loop for duplicate elements as duplicates are not allowed in result
    // as we have to atleast begin from array we have to pass for index =0 thats why first part of condition
    for (int i = 0; i < arr.length - 2; i++) {
      if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
        int low = i + 1;
        int high = arr.length - 1;
        while (low < high) {
          int a = arr[low];
          int b = arr[high];
          int sum = 0 - (arr[i]);
          if (a + b < sum) {
            low++;
          }
          if (a + b > sum) {
            high--;
          }
          if (a + b == sum) {
            //  a + b + c == 0
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(arr[i]);
            results.add(list);
            // skipping all the equal numbers in order to get rid of duplicate results
            while (low < high && arr[low] == arr[low + 1]) low++;
            while (low < high && arr[high - 1] == arr[high]) high--;
            low++;
            high--;
          }
        }
      }
    }
    return results;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
//    int[] arr = new int[]{-2, 0, 1, 2, -1, 4};
//    int[] arr = new int[]{-1, 3, 1, 2, -1, -2};
//    int[] arr = new int[]{-1,0,1,2,-1,-4};
//    int[] arr = new int[]{0, 0, 0, 0};
//    int[] arr = new int[]{-12, 3, 4, 1, 6, 9};
//    int[] arr = new int[]{-2,0,1,1,2};

    List<List<Integer>> res = threeSum(arr);
    for (int i = 0; i < res.size(); i++) {
      System.out.println("   res : " + Arrays.toString(res.get(i).toArray()));
    }
  }
}
