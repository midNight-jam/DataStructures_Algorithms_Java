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
      map[(int) str.charAt(i)]++;
      max = Math.max((int) map[str.charAt(i)], max);
    }

    String[] buckets = new String[max + 1]; // creating the merge list
    StringBuilder freqHelper = new StringBuilder();

    for (int i = 0; i < map.length; i++)
      if (map[i] > 0) {
        String s = buckets[map[i]];
        freqHelper.setLength(0); // clear the buffer
        s = (s == null) ? "" : s;
        for (int j = 0; j < map[i]; j++)
          freqHelper.append((char) i);

        freqHelper.append(s);// merging te same frequency chars
        buckets[map[i]] = freqHelper.toString();
      }

    StringBuilder res = new StringBuilder();

    for (int i = buckets.length - 1; i > 0; i--)
      if (buckets[i] != null)
        res.append(buckets[i]);

    return res.toString();
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
