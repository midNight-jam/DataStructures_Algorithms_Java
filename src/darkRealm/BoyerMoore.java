package darkRealm;

import java.util.Arrays;

public class BoyerMoore {

  char[] pattern;
  int[] skipTable;

  public BoyerMoore(String p) {
    pattern = p.toCharArray();
    skipTable = new int[256];
    Arrays.fill(skipTable, -1); // why -1, as we are giong to skip by jth in pattern - skiptable[ithInText], if ithInText
    // is present in pattern, its value in skipTable will -1 and Max(1, j - (-1)) = j+1 will be max
    for (int i = 0; i < pattern.length; i++)
      skipTable[pattern[i]] = i; // store the right most value
  }

  public int searchInText(char[] text) {
    if (text == null || text.length < 1) return -1;
    // we will read pattern from the end/right

    int m = pattern.length;
    int n = text.length;
    int shift;

    for (int i = 0; i + m < n; i += shift) {
      shift = 0;
      for (int patEnd = m - 1; patEnd >= 0; patEnd--) {
        if (text[i + patEnd] != pattern[patEnd]) {
          shift = Math.max(1, patEnd - skipTable[text[i + patEnd]]);
          break; // we shift at first mismatch in pattern
        }
      }
      if (shift == 0)// found
        return i; // start index from where the pattern is matching
    }
    return -1; // as couldnt find
  }

  public static void main(String[] args) {
//    String pattern = "TATGTG";
//    String text = "GCAATGCCTATGTGACC";

    String text = "ABAAABCD";
    String pattern = "AD";

    BoyerMoore bm = new BoyerMoore(pattern);
    int start = bm.searchInText(text.toCharArray());
    if (start > -1) {
      System.out.println("Found @ " + start);
      System.out.println("T : " + text);
      System.out.println("P : " + pattern);
      System.out.println(text.substring(start, start + pattern.length()));
    } else {
      System.out.println("Not Found");
      System.out.println("T : " + text);
      System.out.println("P : " + pattern);
    }
  }
}
