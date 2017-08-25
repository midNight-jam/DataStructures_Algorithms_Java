package darkRealm.Hyper;

/**
 * Created by Jayam on 7/30/2017.
 * Q) Implement StrStr functionality of C language
 *  The function returns the first index of the given search string it finds in target or  -1 if the string is not found
 * A) Iterate over the haystack and have a inner loop that will check for needle char by char, if we reach the end of
 * needle then we have found the match, if we exceed the length of haystack then we return -1, if the char at needle and
 * haystack donot match then we break and move ahead in the haystack.
 */
public class StrStr {
  private static int jStrStr(String haystack, String needle) {
    if (haystack.length() < needle.length()) return -1;
    for (int pa = 0; ; pa++) {
      for (int pb = 0; ; pb++) {
        if (pb == needle.length()) return pa;
        if (pa + pb >= haystack.length()) return -1;
        if (haystack.charAt(pa + pb) != needle.charAt(pb)) break;
      }
    }
  }

  public static void main(String[] args) {
    String search = "Point";
    String content = "TutorialsPoint";
//    String search = "";
//    String content = "";
    int res = jStrStr(content, search);
    System.out.println("Content : " + content + "\nSearch : " + search + "\nFound here : " + res);
  }
}