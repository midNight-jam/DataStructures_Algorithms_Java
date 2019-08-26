package darkRealm;

import java.util.Arrays;

public class CatalanNumber {

  /* Catalan Number :   https://en.wikipedia.org/wiki/Catalan_number

  the first Catalan numbers for n = 0, 1, 2, 3, ... are
                                    1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796,

  My note if you can reduce the problem to any of the 4 below problem types then its a cataln number problem
  The catalan problem would only have 2 operations like Dyckword : Dyck word is a balanced string of square brackets [,]
  { ( , ) } or {down, right} or {2 childs, no child} etcc

  * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3,
  * possible expressions are ((())), ()(()), ()()(), (())(), (()()).
  *
  * 2) Count the number of possible Binary Search Trees with n keys (See this)
  *
  * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or
  * no children) with n+1 leaves.
  *
  * 4) No of ways you can reach the bottom right from starting in top right using only down & right moves
  *
  * */




  //Time Complexity O(n^2)
  private static long nthCatalanNumner(int n) {
    long[] catalanNos = new long[n + 2]; // first two are 1 , 1
    catalanNos[0] = catalanNos[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        catalanNos[i] += catalanNos[j] * catalanNos[i - j - 1];
      }
    }
    System.out.println(Arrays.toString(catalanNos));
    return catalanNos[n];
  }

  public static void main(String[] args) {
    long cn;
    for (int n = 0; n < 26; n++) {
      cn = nthCatalanNumner(n);
      System.out.print(cn + " ");
    }
  }
}
