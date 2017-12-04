package darkRealm.Hyper;

import ADT.TNode;

import java.util.*;

/**
 * Created by Jayam on 2/22/2017.
 */
public class LC_Prob3 {


  public static int longestValidParanthesis(String str) {
    if (str == null || str.length() == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    int left = -1;
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') stack.push(i);
      else {
        if (stack.isEmpty()) left = i;
        else {
          stack.pop();
          if (stack.isEmpty())
            max = Math.max(max, i - left);
          else
            max = Math.max(max, i - stack.peek());
        }
      }
    }
    return max;
  }

  public static Map<Long, Integer> primeFactorization(long n) {
    Map<Long, Integer> primeFactors = new HashMap<>();
    for (long factor = 2; factor * factor <= n; factor++) {
      while (n % factor == 0) {
        System.out.print(factor + " ");
        n = n / factor;
        primeFactors.put(factor, primeFactors.getOrDefault(factor, 0) + 1);
      }
    }
    if (n > 1) {
      primeFactors.put(n, primeFactors.getOrDefault(n, 0) + 1);
      System.out.println(n);
    }
    return primeFactors;
  }
}