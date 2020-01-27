package darkRealm;

import java.util.Stack;

public class ReverseOfVowels {

//  345. Reverse Vowels of a String
//  Write a function that takes a string as input and reverse only the vowels of a string.
//      Example 1:
//  Given s = "hello", return "holle".
//  Example 2:
//  Given s = "leetcode", return "leotcede".
//  Note:
//  The vowels does not include the letter "y".

  public static String reverseVowels(String s) {
    if (null == s || 0 == s.length()) return s;
    char[] sarr = s.toCharArray();
    int i = 0, j = sarr.length - 1;
    while (i < j) {
      while (i < sarr.length && !isVowel(sarr[i])) i++;
      while (j > -1 && !isVowel(sarr[j])) j--;
      if (i < j) {
        char t = sarr[i];
        sarr[i++] = sarr[j];
        sarr[j--] = t;
      }
    }
    return new String(sarr);
  }

  public static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
  }


  public static String reverseVowelsBasic(String s) {
    if (s == null || s.length() < 1) return s;
    Stack<Character> stack = new Stack<>();
    char c;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (!isVowel(c))
        continue;
      stack.push(c);
    }

    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      c = s.charAt(i);
      if (!isVowel(c))
        arr[i] = c;
      else
        arr[i] = stack.pop();
    }

    return new String(arr);
  }

  public static void main(String[] args) {
//    String s = "hello";
    String s = "leEtcOde";
    System.out.println("S : " + s);
    s = reverseVowels(s);
    System.out.println("R : " + s);
  }
}
