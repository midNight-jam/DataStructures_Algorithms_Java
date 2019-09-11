package darkRealm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LargestValuesFromLabels {

//  1090. Largest Values From Labels
//  We have a set of items: the i-th item has value values[i] and label labels[i].
//  Then, we choose a subset S of these items, such that:
//      |S| <= num_wanted
//  For every label L, the number of items in S with label L is <= use_limit.
//  Return the largest possible sum of the subset S.
//
//      Example 1:
//
//  Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
//  Output: 9
//  Explanation: The subset chosen is the first, third, and fifth item.
//  Example 2:
//
//  Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
//  Output: 12
//  Explanation: The subset chosen is the first, second, and third item.
//  Example 3:
//
//  Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
//  Output: 16
//  Explanation: The subset chosen is the first and fourth item.
//      Example 4:
//
//  Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
//  Output: 24
//  Explanation: The subset chosen is the first, second, and fourth item.
//
//  Note:
//
//      1 <= values.length == labels.length <= 20000
//      0 <= values[i], labels[i] <= 20000
//      1 <= num_wanted, use_limit <= values.length



  /*
  * The gist of this problem is to understand it, after that its an easy one.
  * We are given the useLimit for each label : we cannot use any label more than this capacity
  * We are given num_wanted: this is the max size of the subset we can select
  *
  * Now the break down
  *https://leetcode.com/problems/largest-values-from-labels/discuss/313011/Question-Explanation-and-Simple-Solution-or-Java-or-100
  * */
  static public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    if (values == null || labels == null) return 0;
    Map<Integer, Integer> used = new HashMap<>();
    for (int l : labels)
      if (!used.containsKey(l))
        used.put(l, 0);

    int[][] inputs = new int[values.length][2];
    for (int i = 0; i < values.length; i++) {
      inputs[i][0] = values[i];
      inputs[i][1] = labels[i];
    }

    Arrays.sort(inputs, new Comparator<int[]>() {
      public int compare(int[] o1, int[] o2) {
        return -1 * Integer.compare(o1[0], o2[0]);
      }
    });
    int sum = 0;
    for (int i = 0; i < inputs.length; i++) {
      if (used.get(inputs[i][1]) < use_limit) {
        sum += inputs[i][0];
        used.put(inputs[i][1], used.get(inputs[i][1]) + 1);
        num_wanted--;
      }
      if (num_wanted == 0) break;
    }

    return sum;
  }

  public static void main(String[] args) {
    int[] values = new int[]{5, 4, 3, 2, 1};
    int[] labels = new int[]{1, 1, 2, 2, 3};
    int num_wanted = 3;
    int use_limit = 1;

    int res = largestValsFromLabels(values, labels, num_wanted, use_limit);
    System.out.println(res);
  }
}
