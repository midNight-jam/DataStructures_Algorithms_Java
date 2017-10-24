package darkRealm;

import java.util.*;

public class PalindromePairs {

//  #336. Palindrome Pairs
//  Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//  Example 1:
//  Given words = ["bat", "tab", "cat"]
//  Return [[0, 1], [1, 0]]
//  The palindromes are ["battab", "tabbat"]
//  Example 2:
//  Given words = ["abcd", "dcba", "lls", "s", "sssll"]
//  Return [[0, 1], [1, 0], [3, 2], [2, 4]]
//  The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

  public static List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();
    if (words == null || words.length == 0) return res;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++)
      map.put(words[i], i);

    if (map.containsKey("")) {
      for (int i = 0; i < words.length; i++) {
        if (isPalindrome(words[i])) {
          if (i == map.get("")) continue;
          res.add(Arrays.asList(i, map.get("")));
          res.add(Arrays.asList(map.get(""), i));
        }
      }
    }

    for (int i = 0; i < words.length; i++) {
      String rev = getReverse(words[i]);
      // if there is a reverse already present then these both will form palindrome
      if (map.containsKey(rev)) {
        if (i == map.get(rev)) continue;
        res.add(Arrays.asList(i, map.get(rev)));
      }
    }

    for (int i = 0; i < words.length; i++) {
      for (int c = 1; c < words[i].length(); c++) {
        // s1 = abacd, cut1 = aba, cut2  =cd  if map already contains dc(rev of cut2)then s2+s1 will form dcabacd a palindrome
        // s1 = cdaba, cut1 = cd, cut2  = aba  if map already contains dc(rev of cut1) then s1+s2 will form cdabadc a palindrome
        String cut1 = words[i].substring(0, c);
        String cut2 = words[i].substring(c);
        String revCut1 = getReverse(cut1);
        String revCut2 = getReverse(cut2);
        if (isPalindrome(cut1)) {
          if (map.containsKey(revCut2) && map.get(revCut2) != i)
            res.add(Arrays.asList(map.get(revCut2), i)); // s2 + s1
        }
        if (isPalindrome(cut2)) {
          if (map.containsKey(revCut1) && map.get(revCut1) != i) // s1+ s2
            res.add(Arrays.asList(i, map.get(revCut1)));
        }
      }
    }
    return res;
  }

  private static boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j && s.charAt(i) == s.charAt(j)) {
      i++;
      j--;
    }
    return i >= j;
  }

  private static String getReverse(String s){
    return new StringBuilder(s).reverse().toString();
  }

  public static void main(String[] args) {
//    String[] arr = new String[]{"bat", "tab", "cat"};
    String[] arr = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
    System.out.println(Arrays.toString(arr));
    List<List<Integer>> res = palindromePairs(arr);
    for (List<Integer> l : res)
      System.out.println(l);
  }
}
