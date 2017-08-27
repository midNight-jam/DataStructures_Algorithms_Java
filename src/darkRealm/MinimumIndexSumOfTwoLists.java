package darkRealm;

import java.util.*;

public class MinimumIndexSumOfTwoLists {

//  Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
//
//  You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
//
//  Example 1:
//  Input:
//      ["Shogun", "Tapioca Express", "Burger King", "KFC"]
//      ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//  Output: ["Shogun"]
//  Explanation: The only restaurant they both like is "Shogun".
//  Example 2:
//  Input:
//      ["Shogun", "Tapioca Express", "Burger King", "KFC"]
//      ["KFC", "Shogun", "Burger King"]
//  Output: ["Shogun"]
//  Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).


  public static String[] fingRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++)
      map.put(list1[i], i);

    int minIndexSum = Integer.MAX_VALUE;
    Map<Integer, List<String>> result = new HashMap<>();
    for (int i = 0; i < list2.length; i++)
      if (map.containsKey(list2[i])) {
        int currentMin = map.get(list2[i]) + i;
        if (currentMin <= minIndexSum) {
          minIndexSum = currentMin;
          List<String> res = result.getOrDefault(minIndexSum, new ArrayList<>());
          res.add(list2[i]);
          result.put(minIndexSum, res);
        }
      }

    String[] minRes = new String[result.get(minIndexSum).size()];
    result.get(minIndexSum).toArray(minRes);
    return minRes;
  }

  public static void main(String[] args) {
    String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};


//    String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
//    String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};

    String[] res = fingRestaurant(list1, list2);
    System.out.println("L1 : " + Arrays.toString(list1));
    System.out.println("L2 : " + Arrays.toString(list2));
    System.out.println("R  : " + Arrays.toString(res));
  }
}