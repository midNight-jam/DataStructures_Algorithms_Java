package darkRealm;

public class VerifyingAnAlienDictionary {

//  953. Verifying an Alien Dictionary
//  In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
//  The order of the alphabet is some permutation of lowercase letters.
//
//  Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
//  if the given words are sorted lexicographicaly in this alien language.
//
//  Example 1:
//
//  Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//  Output: true
//  Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//      Example 2:
//
//  Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//  Output: false
//  Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//      Example 3:
//
//  Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//  Output: false
//  Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
//  lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is
//  less than any other character (More info).
//
//  Note:
//
//      1 <= words.length <= 100
//      1 <= words[i].length <= 20
//  order.length == 26
//  All characters in words[i] and order are english lowercase letters.

  public static boolean isAlienSorted(String[] words, String order) {
    int[] map = new int[26];

    for (int i = 0; i < order.length(); i++) {
      char c = order.charAt(i);
      map[c - 'a'] = i;
    }

    String prev;
    String curr;
    int pi, ci;
    int c, p;

    for (int i = 1; i < words.length; i++) {
      prev = words[i - 1];
      curr = words[i];
      pi = ci = 0;
      while (pi < prev.length() || ci < curr.length()) {
        p = pi < prev.length() ? map[prev.charAt(pi) - 'a'] : -1;
        c = ci < curr.length() ? map[curr.charAt(ci) - 'a'] : -1;
        if (p > c)
          return false;
        else if (p == c) {  // if same char, move ahead to next char in the strings
          pi++;
          ci++;
        } else break; // p < c means the prev string is smaller then the curr string, thus move to next string
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    String[] arr = new String[]{"hello", "leetcode"};
//    String dict = "hlabcdefgijkmnopqrstuvwxyz";
//    String[] arr = new String[]{"word","world","row"};
//    String dict = "worldabcefghijkmnpqstuvxyz";
//    String[] arr = new String[]{"apple","app"};
    String[] arr = new String[]{"apple"};
    String dict = "abcdefghijklmnopqrstuvwxyz";
    boolean res = isAlienSorted(arr, dict);
    System.out.println(res);
  }
}
