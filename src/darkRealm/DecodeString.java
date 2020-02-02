package darkRealm;

import java.util.Stack;

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
    if (s == null || s.length() == 0) return s;
    Stack<Integer> countStack = new Stack<>();
    Stack<String> strStack = new Stack<>();
    StringBuilder res = new StringBuilder();
    int index = 0;
    while (index < s.length()) {
      if (Character.isDigit(s.charAt(index))) {  // integer
        int n = 0;
        while (Character.isDigit(s.charAt(index))) {
          n = n * 10;
          n = n + s.charAt(index) - '0';
          index++;
        }
        countStack.push(n);
      } else if (s.charAt(index) == '[') {
        // put the current result in to the stack & reset as we are going to create a new string because of opening '['
        strStack.push(res.toString());
        res = new StringBuilder(); // reset
        index++;
      } else if (s.charAt(index) == ']') {
        int count = countStack.pop();
        // append to the old result, thus we are starting by using the last result as a initial point
        StringBuilder oldResult = new StringBuilder(strStack.pop());
        // append the current result to the old result
        while (count-- != 0) oldResult.append(res.toString());
        res = oldResult;
        index++;
      } else {
        res.append(s.charAt(index) + "");
        index++;
      }
    }
    return res.toString();
  }


  public static void main(String[] args) {
    String str = "10[az]bc2[de]";
    String res = decodeString(str);
    System.out.println("S : " + str);
    System.out.println("R : " + res);
  }
}