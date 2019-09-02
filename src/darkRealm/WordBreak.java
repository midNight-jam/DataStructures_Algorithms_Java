package darkRealm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  /*
    #139 Word Break
  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
  * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
  * contain duplicate words.
  * For example, given
  * s = "leetcode",
  * dict = ["leet", "code"].
  * Return true because "leetcode" can be segmented as "leet code".
  * A) we slide a window and try to see if the current chars in a window for a string that is in dictionary.
  * We also keep this intermediate result saved in a boolean array to propogate the result forward when we increase the
  * sliding window size. if (Iam) "I" and "am" can be formed using dictionary while breaking the string we satore the
  * result that string of length 3 can be formed using dictionary, similarly if the result for the length of the string
  * is also true mean the whole string can be formed using the dictionary while doing some partitions at places.
  * */
  public static boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || wordDict == null) return false;
    Set<String> dict = new HashSet<>(wordDict);
    // This is a DP Problem
    int N = s.length();
    boolean[] dp = new boolean[N + 1];
    dp[0] = true; // empty string can or no string is base case & already possible
    String subString;
    for (int end = 1; end <= N; end++) {
      for (int start = 0; start < end; start++) {
        subString = s.substring(start, end);
        boolean subStringPossible = dict.contains(subString);
        boolean isPortionBeforeSubstringPossible = dp[start]; // why we are checking for just start & not start - 1, remember this array is N+1 :P
        if (subStringPossible && isPortionBeforeSubstringPossible) {
          dp[end] = true;
        }
      }
    }
    return dp[N];
  }

  public static void main(String[] args) {

//    String str = "leetcoder";
//    List<String> dict = new ArrayList<>();
//    dict.add("leet");
//    dict.add("code");
//    dict.add("coder");

    String str = "catsanddog";
    List<String> dict = new ArrayList<>();
    dict.add("cat");
    dict.add("sand");
    dict.add("dog");
//    String str = "Iamace";
//    List<String> dict = new ArrayList<>();
//    dict.add("I");
//    dict.add("a");
//    dict.add("am");
//    dict.add("ace");
//
//    String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//    String str = "aaaabaaaaaa";
//    List<String> dict = new ArrayList<>();
//    dict.add("b");
//    dict.add("a");
//    dict.add("aa");
//    dict.add("aaa");
//    dict.add("aaaa");
//    dict.add("aaaaa");
//    dict.add("aaaaaa");
//    dict.add("aaaaaaa");
//    dict.add("aaaaaaaa");
//    dict.add("aaaaaaaaa");
//    dict.add("aaaaaaaaaa");
//
//    String str = "bb";
//    List<String> dict = new ArrayList<>();
//    dict.add("b");
//    dict.add("a");
//    dict.add("bbb");
//    dict.add("bbbb");
    Long start = System.currentTimeMillis();
    boolean res = wordBreak(str, dict);
    System.out.println(" " + (System.currentTimeMillis() - start));
    System.out.println(" Res : " + res + " str : " + str + " Dict : " + dict);
  }
}
