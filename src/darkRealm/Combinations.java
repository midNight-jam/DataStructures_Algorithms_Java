package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

//  #77. Combinations  ::: Complexity - Time : O(n^min{k, n - k}))
//  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//      For example,
//  If n = 4 and k = 2, a solution is:
//      [
//      [2,4],
//      [3,4],
//      [2,3],
//      [1,2],
//      [1,3],
//      [1,4],
//      ]

  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    helper(res, new ArrayList<>(), 1, n, k);  // start from 1 to n, with K being set size
    return res;
  }

  private static void helper(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
    if (k == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i <= n; i++) {
      list.add(i);  // add the current no to list
      helper(res, list, i + 1, n, k - 1); // as we have used i, next start will be i + 1, and also one less element to add
      list.remove(list.size() - 1); // remove the last added no, this will aid in generating unique combinations
    }
  }

  // generate all combinations of size K using n sized input
  public static List<List<Integer>> k_Combinations(int N, int k){
    List<List<Integer>> res=  new ArrayList<>();
    recurAndCombine(res, new ArrayList<>(), 0, N, k);
    return res;
  }

  private static void recurAndCombine(List<List<Integer>> res, List<Integer> tempList, int startIndex, int N, int k){
    if(k == 0){
      res.add(new ArrayList<>(tempList));
      return;
    }
    for(int i = startIndex; i < N; i++){
      tempList.add(i);
      recurAndCombine(res, tempList, i + 1, N, k - 1);
      tempList.remove(tempList.size() - 1); // remove the last added element
    }
  }

  public static void main(String[] args) {
//    List<List<Integer>> res = combine(4, 2);
//    List<List<Integer>> res = combine(5, 3);
    List<List<Integer>> res = k_Combinations(5, 3);
    for(List<Integer> l : res)
      System.out.println(l);
  }
}
