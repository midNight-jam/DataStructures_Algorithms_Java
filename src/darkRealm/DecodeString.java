package darkRealm;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

//  #394. Decode String
//  Given an encoded string, return it's decoded string.
//  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
//  exactly k times. Note that k is guaranteed to be a positive integer.
//  You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//  Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
//  repeat numbers, k. For example, there won't be input like 3a or 2[4].
//  Examples:
//  s = "3[a]2[bc]", return "aaabcbc".
//  s = "3[a2[c]]", return "accaccacc".
//  s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

  public static String decodeString(String s) {
    if (s == null || s.length() == 0) return "";
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<String> strStack = new ArrayDeque<>();
    StringBuilder res = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {  // integer
        int n = 0;
        while (Character.isDigit(s.charAt(i))) {
          n = n * 10;
          n = n + s.charAt(i) - '0';
          i++;
        }
        countStack.push(n);
      }
      else if (s.charAt(i) == '[') {
        strStack.push(res.toString());
        res = new StringBuilder();
        i++;
      }
      else if (s.charAt(i) == ']') {
        int count = countStack.pop();
        StringBuilder part = new StringBuilder(strStack.pop());
        while (count-- != 0) part.append(res.toString());
        res = part;
        i++;
      }
      else {
        res.append(s.charAt(i) + "");
        i++;
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    String str = "1[a]bc2[de]";
    String res = decodeString(str);
    System.out.println("S : " + str);
    System.out.println("R : " + res);
  }
}