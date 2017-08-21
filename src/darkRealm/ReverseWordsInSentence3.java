package darkRealm;

public class ReverseWordsInSentence3 {
  /*
  * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
  * Example 1:
  * Input: "Let's take LeetCode contest"
  * Output: "s'teL ekat edoCteeL tsetnoc"
  * */
  public static String reverseWordsSentence(String str) {
    if (str == null || 0 == str.length())
      return str;
    StringBuilder sbr = new StringBuilder();
    String[] strs = str.split(" ");
    for (int i = 0; i < strs.length; i++)
      sbr.append(new StringBuilder(strs[i]).reverse().toString() + " ");
    return sbr.toString().trim();
  }

  public static void main(String[] args) {
    String str = "Let's take leetcode contest";
    String res = reverseWordsSentence(str);
    System.out.println("Str : " + str + "\nRes : " + res);
  }
}