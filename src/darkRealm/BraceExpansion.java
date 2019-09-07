package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BraceExpansion {

//  1087. Brace Expansion
//  A string S represents a list of words.
//
//  Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.
//  If there is more than one option, then curly braces delimit the options.
//  For example, "{a,b,c}" represents options ["a", "b", "c"].
//
//  For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
//
//  Return all words that can be formed in this manner, in lexicographical order.
//
//      Example 1:
//  Input: "{a,b}c{d,e}f"
//  Output: ["acdf","acef","bcdf","bcef"]
//
//
//  Example 2:
//  Input: "abcd"
//  Output: ["abcd"]
//
//  Note:
//      1 <= S.length <= 50
//  There are no nested curly brackets.
//  All characters inside a pair of consecutive opening and ending curly brackets are different.

  public static String[] expand(String s) {
    List<String> res = new ArrayList<>();
    helper(0, "", s, res);
    String[] arr = new String[res.size()];
    res.toArray(arr);
    return arr;
  }

  private static void helper(int start, String prefix, String str, List<String> res) {
    if (start >= str.length()) {
      res.add(prefix);
      return;
    }
    // if there is a brace, append the current prefix for each char in this group,
    // as there are no nested curly brace, they only exist in pair, thats why this works
    if (str.charAt(start) == '{') {
      int closingBrace = str.indexOf('}', start);
      String thisGroup = str.substring(start + 1, closingBrace);
      for (char c : thisGroup.toCharArray()) {
        if (c == ',') continue; // skip all the seperators
        helper(closingBrace + 1, prefix + c + "", str, res);
      }
    }
    // if there is no brace, append this char to the current prefix & move ahead
    else
      helper(start + 1, prefix + str.charAt(start), str, res);
  }

  public static void main(String[] args) {
//    String s = "{a,b}c{d,e}f";
    String s = "{x}{a,b}c{d,e}{f}";
//    String s = "abc{d,e}{f}";
//    String s = "a,b,c,d,e";
    String[] res = expand(s);
    System.out.println(Arrays.toString(res));
  }
}
