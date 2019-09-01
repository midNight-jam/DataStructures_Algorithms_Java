package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class GuessNumberHigherOrLowerII {

//  375. Guess Number Higher or Lower II
//  We are playing the Guess Game. The game is as follows:
//  I pick a number from 1 to n. You have to guess which number I picked.
//  Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
//  However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the
//  number I picked.
//
//      Example:
//
//  n = 10, I pick 8.
//
//  First round:  You guess 5, I tell you that it's higher. You pay $5.
//  Second round: You guess 7, I tell you that it's higher. You pay $7.
//  Third round:  You guess 9, I tell you that it's lower. You pay $9.
//
//  Game over. 8 is the number I picked.
//
//  You end up paying $5 + $7 + $9 = $21.
//  Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

  
  /* My explaination :
  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/371686/tree-visualization-memoized-recursive-soln-faster-than-504-of-java
  */

  static Map<String, Integer> map;

  public static int getMoneyAmount(int n) {
    if (n < 1) return 0;
    map = new HashMap<>();
    return helper(1, n);
  }

  private static int helper(int start, int end) {
    String k = start + "," + end;
    if (map.containsKey(k))
      return map.get(k);

    // only one value, or crossed over [a], we dont need to call the api at all if there is only one value thus cost is 0
    if (start >= end) {
      map.put(k, 0);
      return 0;
    }
    // consecutive values [a, b] return a, if we choose a & its a match thats the answer, if its lower then we know
    // that b is the answer, thus by spending "a" cost we can determine the value
    if (start + 1 == end) {
      map.put(k, start);
      return start;
    }
    // consecutive triplet [a,b,c] return b, because if we choose b & its a match if its lesser we know a is answer,
    // & if its higher we know c is answer thus by spending b cost we can determine the value in a triplet
    if (start + 1 == end - 1) {
      map.put(k, start + 1);
      return start + 1;
    }
    int minCost = Integer.MAX_VALUE;
    int cost;
    for (int i = start; i <= end; i++) {
      int left = helper(start, i - 1);
      int right = helper(i + 1, end);
      cost = i + Math.max(left, right);
      minCost = Math.min(cost, minCost);
    }
    map.put(k, minCost);
    return minCost;
  }

  public static void main(String[] args) {
//    int n = 4;
//    int n = 6;
    int n = 5;
    int res = getMoneyAmount(n);
    System.out.println(res);
  }
}
