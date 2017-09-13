package darkRealm;

public class IsomorphicString {

//  Given two strings s and t, determine if they are isomorphic.
//  Two strings are isomorphic if the characters in s can be replaced to get t.
//  All occurrences of a character must be replaced with another character while preserving the order of characters.
//  No two characters may map to the same character but a character may map to itself.
//  For example,
//  Given "egg", "add", return true.
//  Given "foo", "bar", return false.
//  Given "paper", "title", return true.
//  Note:
//  You may assume both s and t have the same length.

  public static boolean isIsomorphic(String s, String t) {
    int[] arr = new int[256];
    int[] brr = new int[256];
    for (int i = 0; i < 256; i++)
      arr[i] = brr[i] = -1;
    char ch, ch2;
    for (int i = 0; i < s.length(); i++) {
      ch = s.charAt(i);
      ch2 = t.charAt(i);
      if (arr[ch] == -1 && brr[ch2] == -1) {
        arr[ch] = ch2;
        brr[ch2] = ch;
      }
      else if (brr[ch2] == -1 || arr[ch] == -1 || arr[ch] != arr[brr[ch2]] ||
          brr[ch2] != brr[arr[ch]]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
//    String s = "egg";
//    String t = "add";

//    String s = "foo";
//    String t = "bar";

//    String s = "paper";
//    String t = "title";

    String s = "13";
    String t = "42";


//    String s = "ab";
//    String t = "aa";

//    String s = "ab";
//    String t = "ca";


//    String s = "ca";
//    String t = "ab";

    boolean res = isIsomorphic(s, t);
    System.out.println("S : " + s);
    System.out.println("S : " + t);
    System.out.println("R : " + res);
  }
}