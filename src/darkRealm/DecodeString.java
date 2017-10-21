package darkRealm;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

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