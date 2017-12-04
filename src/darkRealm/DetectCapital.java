package darkRealm;

public class DetectCapital {


  /*
   #520 Detect Capital
    Given a word, you need to judge whether the usage of capitals in it is right or not.
    We define the usage of capitals in a word to be right when one of the following cases holds:
    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital if it has more than one letter, like "Google".
    Otherwise, we define that this word doesn't use capitals in a right way.
    Example 1:
    Input: "USA"
    Output: True
    Example 2:
    Input: "FlaG"
    Output: False
    Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
   */
  public static boolean detectCapitals(String word) {
    if (word == null || word.length() == 0) return false;
    int upCount = 0;
    boolean firstUp = false;
    if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') firstUp = true;
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') upCount++;
      if (!firstUp && upCount > 0) return false;
    }

    if (firstUp && word.length() == upCount + 1) return true;
    return upCount == 0 ? true : false;
  }

  public static void main(String[] args) {
    String w = "USA";
    boolean res = detectCapitals(w);
    System.out.println(res);
  }
}
