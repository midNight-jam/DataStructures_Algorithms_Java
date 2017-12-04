package darkRealm;

public class FirstUniqueCharacter {

  /*  [Prob 387] First Unique Character in a String
  *   Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
  *   Examples:
  *   s = "leetcode"
  *   return 0.
  *   s = "loveleetcode",
  *   return 2.
  * */
  public static int firstUniqueCharacter(String str) {
    int firstCharIndex = -1;
    if (str == null || str.length() == 0) {
      return firstCharIndex;
    }
    int[] allChars = new int[256];

    for (int i = 0; i < str.length(); i++) {
      allChars[str.charAt(i)]++;
    }
    for (int i = 0; i < str.length(); i++) {
      if (allChars[str.charAt(i)] == 1) {
        firstCharIndex = i;
        break;
      }
    }
    return firstCharIndex;
  }

  public static void main(String[] args) {

  }
}
