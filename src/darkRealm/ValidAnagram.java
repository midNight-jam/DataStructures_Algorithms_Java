package darkRealm;

public class ValidAnagram {


  /*  #242 Valid Anagram
 *Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note: You may assume the string contains only lowercase alphabets.
 * Follow up:  What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * */
  public static boolean validAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) return false;
    int[] map = new int[256];
    int len = s.length();

    for (int i = 0; i < len; i++)
      map[s.charAt(i)]++;

    char c;
    for (int i = 0; i < len; i++) {
      c = t.charAt(i);
      if (map[c] > 0)
        map[c]--;
      else
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "anagram", t = "nagaram";
//    String s = "", t = "nagaram";
//    String s = "", t = "";
//    String s = "", t = null;
//    String s = "a", t ="a";

    boolean res = validAnagram(s, t);
    System.out.println("Res : " + res + " S : " + s + "  T : " + t);
  }
}
