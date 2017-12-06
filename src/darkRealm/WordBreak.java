package darkRealm;

import java.util.ArrayList;
import java.util.List;

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
  public static boolean wordBreak(String str, List<String> wordDict) {
    if (str == null || str.length() == 0) return true;
    int n = str.length();
    boolean[] partition = new boolean[n + 1];
    partition[0] = true;
    String part = null;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        part = str.substring(j, i);
        if (wordDict.contains(part) && partition[j]) {
          partition[i] = true;
          break;
        }
      }
    }
    return partition[n];
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
