package darkRealm;

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
    if (str == null || str.length() < 1) return str;
    int[] map = new int[256];
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      map[str.charAt(i)]++;
      max = Math.max(map[str.charAt(i)], max);
    }
    String[] buckets = new String[max + 1]; // creating the merge list
    for (int i = 0; i < map.length; i++) {
      String s = buckets[map[i]];
      if (map[i] > 0) {
        buckets[map[i]] = s == null ? "" + (char) i : s + (char) i; // merging te same frequency chars
      }
    }
    StringBuilder helper = new StringBuilder();
    for (int i = max; i >= 0; i--) {  // reading from behind as we had to put higher frequnecy chars first
      String s2 = buckets[i];
      if (s2 != null && !s2.equals("")) {
        for (int j = 0; j < s2.length(); j++) {
          for (int k = 0; k < i; k++) {
            helper.append(s2.charAt(j));  // adding each char as many times as they have appeared in the oriiganl string
          }
        }
      }
    }
    return helper.toString();
  }
  public static void main(String[] args) {
//    String str = "tree";
//    String str = "zaaactcccfddtddzdeef";
//    String str = "cccaaa";
    String str = "Aabb";
    String res = sortByFrequency(str);
    System.out.println("Str : " + str + " Sorted : " + res);
  }
}
