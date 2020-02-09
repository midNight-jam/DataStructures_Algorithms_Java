package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class SortByFrequency {


/*
  #451. Sort Characters By Frequency
  DescriptionHintsSubmissionsDiscussSolution
  Discuss Pick One
  Given a string, sort it in decreasing order based on the frequency of characters.
  Example 1:
  Input:
      "tree"
  Output:
      "eert"

  Explanation:
      'e' appears twice while 'r' and 't' both appear once.
      So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
      Example 2:

  Input:
      "cccaaa"
  Output:
      "cccaaa"

  Explanation:
  Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
  Note that "cacaca" is incorrect, as the same characters must be together.

  Example 3:
  Input:
      "Aabb"
  Output:
      "bbAa"

  Explanation:
      "bbaA" is also a valid answer, but "Aabb" is incorrect.
  Note that 'A' and 'a' are treated as two different characters.
*/


  public static String sortByFrequency(String str) {
    int[] map = new int[256];
    int max = 0;

    for (char c : str.toCharArray()) {
      map[c]++;
      max = Math.max(max, map[c]);
    }

    List<Character>[] buckets = new List[max + 1];
    for (int i = 0; i < map.length; i++) {
      int freq = map[i];
      if (buckets[freq] == null)
        buckets[freq] = new ArrayList<>();
      buckets[freq].add((char) i);
    }

    StringBuilder sbr = new StringBuilder();
    for (int f = max; f >= 0; f--) {
      if (buckets[f] == null) continue;
      int times;
      for (Character c : buckets[f]) {
        times = f;
        while (times-- > 0) {
          sbr.append(c);
        }
      }
    }

    return sbr.toString();
  }

  public static void main(String[] args) {
    String str = "tree";
//    String str = "zaaactcccfddtddzdeef";
//    String str = "cccaaa";
//    String str = "Aabb";
    String res = sortByFrequency(str);
    System.out.println("Str : " + str + " Sorted : " + res);
  }
}
