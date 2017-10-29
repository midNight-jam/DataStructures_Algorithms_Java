package darkRealm;

import java.util.Arrays;

public class ReverseWordsInStringII {

//  #186. Reverse Words in a String II
//  Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
//  The input string does not contain leading or trailing spaces and the words are always separated by a single space.
//  For example,
//  Given s = "the sky is blue",
//  return "blue is sky the".

  public static void reverseWords(char[] str) {
    // reverse whole string, then reverse each word
    if(str == null || str.length == 0) return;
    reverse(str, 0, str.length - 1);
    int start = 0;
    for(int i = 0; i < str.length; i++)
      if(str[i] == ' '){
        reverse(str, start , i - 1);
        start = i + 1;
      }

    reverse(str, start, str.length - 1);
  }

  private static void reverse(char[] str, int l, int r){
    char c;
    while(l < r){
      c = str[l];
      str[l] = str[r];
      str[r] = c;
      l++;
      r--;
    }
  }

  public static void main(String[] args) {
    char [] str = "the sky is blue".toCharArray();
    System.out.println(Arrays.toString(str));
    reverseWords(str);
    System.out.println(Arrays.toString(str));
  }
}
