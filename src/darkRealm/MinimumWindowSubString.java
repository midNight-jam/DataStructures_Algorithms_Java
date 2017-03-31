package darkRealm;

/**
 * Created by Jayam on 3/31/2017.
 */
public class MinimumWindowSubString {

  public static String minimumWindowSubString(String S, String T) {
    int[] TMap = new int[256];
    for (int i = 0; i < T.length(); i++)
      TMap[T.charAt(i)]++;

    int counter = T.length();
    int minLen = Integer.MAX_VALUE;
    int start = 0, end = 0, minStart = 0;
    while (end < S.length()) {

      if (TMap[S.charAt(end)] > 0)
        counter--; // Map has this character & it is consumed

      TMap[S.charAt(end)]--;
      while (counter == 0) {// window has machted
        if (end - start < minLen) { // boiler min len check
          minLen = end - start + 1;
          minStart = start;
        }
        TMap[S.charAt(start)]++; // reviving the char that we used
        if (TMap[S.charAt(start)] > 0)
          counter++; // reviving the counter
        start++;
      }
      end++;
    }

    if (minStart + minLen > S.length())
      return "";

    return S.substring(minStart,  minStart + minLen);
  }

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    String res = minimumWindowSubString(s, t);
    System.out.println(res);
  }
}