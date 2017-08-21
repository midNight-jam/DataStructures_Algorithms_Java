package darkRealm;

import java.util.Arrays;
import java.util.HashSet;

public class DistributeCandies {

/*
* Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
* Example 1:
* Input: candies = [1,1,2,2,3,3]
* Output: 3
* Explanation:
* There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
* Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
* The sister has three different kinds of candies.
* */

  public static int sisterCandies(int[] arr) {
    if (null == arr || 0 == arr.length)
      return 0;
    HashSet<Integer> set = new HashSet<>();
    for(int a : arr)
      set.add(a);
    // if there are more types of candies than half, then types will comprise any half
    if(set.size() >= arr.length / 2 )
      return arr.length / 2;
    // if there are less types than half, then given candies will comprise of max of these types
    return set.size();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 2, 2, 3, 3};
    int res = sisterCandies(arr);
    System.out.println("Candies : " + Arrays.toString(arr) + "\nSister : " + res);
  }
}