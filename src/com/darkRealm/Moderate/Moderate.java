package com.darkRealm.Moderate;

import java.util.HashMap;

/**
 * Created by Jayam on 1/23/2017.
 */
public class Moderate {
  /*  [Prob 16.1]
  *   Q) Number Swapper : swap 2 nos without using extra variable & by using  XOR
  *   */
  public static void numberSwapper(int a, int b) {
    System.out.println("Before  a : " + a + " b : " + b);
    a = a ^ b;
    b = b ^ a;
    a = a ^ b;
    System.out.println("After a : " + a + " b : " + b);
  }

  /*  [Prob 16.2]
  *   Q) Word Frequncies : deisgn a method to find the frequency of occurencses of any given word in a book. What if we
  *   were running this algorithm multiple times.
  *   A)
  * */

  public static int wordFrequency(String[] book, String word) {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < book.length; i++) {
      if (map.containsKey(book[i])) {
        map.put(book[i], map.get(book[i]) + 1);
      } else {
        map.put(book[i], 1);
      }
    }
    return map.containsKey(word) ? map.get(word) : 0;
  }
}
