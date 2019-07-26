package darkRealm;

import java.util.*;

/**
 * Created by Jayam on 4/3/2018.
 */
public class SubarraysWithZeroSum {

  private static List<int[]> subarraysWithZeroSum(int[] nums) {
    List<int[]> res = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == 0)  // if the sum is 0 till here, means this is a continuos segment from the first element with 0 sum
        res.add(new int[]{0, i});

      // if the map already holds this sum
      if (map.containsKey(sum))
        // for [0, 10, 0], now for i = 2, when sum is 10, we will get a segment of start = (1+1)2, end = 2
        for (int j : map.get(sum))
          res.add(new int[]{j + 1, i}); // every segment starting after(+1) the previous index with same sum is a result

      if (!map.containsKey(sum))
        map.put(sum, new ArrayList<>());

      map.get(sum).add(i);  // add the index to the sum in map
    }
    return res;
  }
  
  private static List<int[]> subarraysWithZeroSumNEW(int[] nums) {
    List<int[]> res = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == 0)  // if the sum is 0 till here, means this is a continuos segment from the first element with 0 sum
        res.add(new int[]{0, i});

      if (!map.containsKey(sum))
        map.put(sum, new ArrayList<>());

      // if the map already holds this sum
      // for [0, 10, 0], now for i = 2, when sum is 10, we will get a segment of start = (1+1)2, end = 2
        for (int j : map.get(sum))
          if(j + 1 < arr.nums.length)
            res.add(new int[]{j + 1, i}); // every segment starting after(+1) the previous index with same sum is a result
      
      map.get(sum).add(i);  // add the index to the sum in map
    }
    return res;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{0, 10, 0, -6, -4, 4, 6};
//    int[] nums = new int[]{0, 10, 0};
//    int[] nums = new int[]{0, 0, 0};
    int[] nums = new int[]{0, 0};
    int[] indexes = new int[nums.length];
    for (int i = 0; i < indexes.length; i++) indexes[i] = i;
    List<int[]> res = subarraysWithZeroSum(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(indexes));
    System.out.println("-------------------------");
    for (int[] r : res)
      System.out.println(Arrays.toString(r));
  }
}
