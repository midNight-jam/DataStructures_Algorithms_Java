package darkRealm;

public class ShortestPalindrome {

//  214. Shortest Palindrome  : TIME COMPLEXITY = O(N^2) brute force
//  Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
//  Find and return the shortest palindrome you can find by performing this transformation.
//
//  Example 1:
//
//  Input: "aacecaaa"
//  Output: "aaacecaaa"
//  Example 2:
//
//  Input: "abcd"
//  Output: "dcbabcd"


  public static String shortestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;
    // intuition is to have the reverse of the string, S : abcxyz, revS : xyzabc
    // split the reverse into two parts starting from left(head) untill we find a second part(tail) such that the
    // original string starts with tail
    // x|yzabc  :: abcxyz   NO
    // xy|zabc  :: abcxyz   NO
    // xyz|abc  :: abcxyz   YES
    // add xyz to the given string so that xyzabcxyz is a palindrome


    StringBuilder sbr = new StringBuilder(s);
    String rev = new String(sbr.reverse());
    if (s.equals(rev)) return s;
    for (int i = 1; i < rev.length(); i++) {
      String head = rev.substring(0, i);
      String tail = rev.substring(i);
      if (s.startsWith(tail)) {
        return head + s;
      }
    }
    return s;
  }


  public static void main(String[] args) {

  }
}
