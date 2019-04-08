package darkRealm;

import java.util.TreeMap;

public class HandOfStraights {

//  846. Hand of Straights
//  Alice has a hand of cards, given as an array of integers.
//
//  Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
//      Return true if and only if she can.
//
//  Example 1:
//
//  Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
//  Output: true
//  Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
//
//  Example 2:
//
//  Input: hand = [1,2,3,4,5], W = 4
//  Output: false
//  Explanation: Alice's hand can't be rearranged into groups of 4.
//
//  Note:
//      1 <= hand.length <= 10000
//      0 <= hand[i] <= 10^9
//      1 <= W <= hand.length


  public static boolean isNStraightHand(int[] hand, int w) {
    if (hand == null || hand.length < w) return false;

    TreeMap<Integer, Integer> map = new TreeMap<>();

    for (int i : hand) {
      if (!map.containsKey(i))
        map.put(i, 0);
      map.put(i, map.get(i) + 1);
    }

    int len = hand.length;

    while (len > 0 && map.size() > 0) {
      int start = map.firstKey();
      int out = w;
      while (out > 0 && map.containsKey(start)) {
        map.put(start, map.get(start) - 1);
        if (map.get(start) == 0)
          map.remove(start);
        start++;
        out--;
      }
      if (out != 0) return false;
      len -= w;
    }

    return len == 0;
  }

  public static void main(String[] args) {
    int[] hand = new int[]{1, 2, 3, 4, 2, 3, 4, 4, 2, 3};
    int w = 3;
    boolean res = isNStraightHand(hand, w);
    System.out.println(res);
  }
}
