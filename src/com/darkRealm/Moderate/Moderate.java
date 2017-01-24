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

  /* [Prob 16.4]
  * */

  public static boolean ticTacWin(char[][] game, int n) {
    //from top left
    char c = 'z';

    //check for whole row
    for (int r = 0; r < n; r++) {
      c = game[r][0];
      boolean rowComplete = true;
      for (int i = 0; i < n; i++) {
        rowComplete = rowComplete & (c == game[r][i]);
        if (!rowComplete) {
          break;
        }
      }
      if (rowComplete) {
        System.out.println("Winner " + c + " row complete");
        return true;
      }
    }

    //check for all 3 columns
    for (int j = 0; j < n; j++) {
      c = game[0][j];
      boolean colComplete = true;
      for (int i = 0; i < n; i++) {
        colComplete = colComplete & (c == game[i][j]);
        if (!colComplete) {
          break;
        }
      }
      if (colComplete) {
        System.out.println("Winner " + c + " col complete ");
        return true;
      }
    }

    // check for topleft to bottomright diagonal
    boolean diagComplete = true;
    c = game[0][0];
    for (int i = 0; i < n; i++) {
      diagComplete = diagComplete & (c == game[i][i]);
      if (!diagComplete) {
        break;
      }
    }
    if (diagComplete) {
      System.out.println("Winner " + c + " daig complete");
      return true;
    }

    // check for bottom left to top right  diagonal
    c = game[n - 1][0];
    diagComplete = true;
    for (int i = n - 1; i >= 0; i--) {
      diagComplete = diagComplete & (c == game[i][i]);
      if (!diagComplete) {
        break;
      }
    }
    if (diagComplete) {
      System.out.println("Winner " + c + " daig complete");
      return true;
    }
    return false;
  }
}