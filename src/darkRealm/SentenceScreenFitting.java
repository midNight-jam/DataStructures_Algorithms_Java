package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class SentenceScreenFitting {
// #418. Sentence Screen Fitting
//  Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given
//  sentence can be fitted on the screen.
//  Note:
//  A word cannot be split into two lines.
//  The order of words in the sentence must remain unchanged.
//  Two consecutive words in a line must be separated by a single space.
//  Total words in the sentence won't exceed 100.
//  Length of each word is greater than 0 and won't exceed 10.
//      1 ≤ rows, cols ≤ 20,000.
//  Example 1:
//  Input:
//  rows = 2, cols = 8, sentence = ["hello", "world"]
//  Output:
//      1
//  Explanation:
//  hello---
//  world---
//  The character '-' signifies an empty space on the screen.
//      Example 2:
//  Input:
//  rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
//  Output:
//      2
//  Explanation:
//  a-bcd-
//  e-a---
//  bcd-e-
//  The character '-' signifies an empty space on the screen.
//      Example 3:
//  Input:
//  rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
//  Output:
//      1
//  Explanation:
//  I-had
//      apple
//  pie-I
//  had--
//  The character '-' signifies an empty space on the screen.

  public static int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int start = 0, l = s.length();
    for (int i = 0; i < rows; i++) {
      start += cols;  // add these many chars to the current line
      char c = s.charAt(start % l);
      if (c == ' ')
        start++; // as we are on space we can try to occupy another word also in the same line
      else { // we are right now in midlle of a word and have to roll back till we get the space
        while (start > 0 && s.charAt((start - 1) % l) != ' ') // minus one beacuse we want to stop at the begining of the word
          start--;
      }
    }
    return start / s.length(); // how many times we got the string consumed
  }

  public static int wordsTyping_MLE(String[] sentence, int rows, int cols) {
    List<String> list = new ArrayList<>();
    StringBuilder sbr = new StringBuilder();
    int times = 0;
    while (list.size() < rows) {
      int i = 0;
      for (; i < sentence.length; i++) {
        if (!(sbr.length() + sentence[i].length() <= cols)) {
          while (sbr.length() < cols)
            sbr.append("-");
          list.add(sbr.toString());
          if (list.size() == rows) break;
          sbr = new StringBuilder();
        }

        sbr.append(sentence[i]);
        if (sbr.length() < cols) sbr.append("-");
      }
      if (i == sentence.length)
        times++;
    }
    System.out.println("t : " + times);
    return times;
  }

  public static int wordsTyping_TLE(String[] sentence, int rows, int cols) {
    StringBuilder sbr = new StringBuilder();
    int times = 0;
    int lines = 0;
    while (lines < rows) {
      int i = 0;
      for (; i < sentence.length; i++) {
        if (!(sbr.length() + sentence[i].length() <= cols)) {
          lines++;
          if (lines == rows) break;
          sbr = new StringBuilder();
        }

        sbr.append(sentence[i]);
        if (sbr.length() < cols) sbr.append("-");
      }
      if (i == sentence.length)
        times++;
    }
    System.out.println("t : " + times);
    return times;
  }

  public static void main(String[] args) {
//    int rows = 2, cols = 8;
//    String[] sentence = new String[]{"hello", "world"};
//    int rows = 3, cols = 6;
//    String[] sentence = new String[]{"a", "bcd", "e"};
//    int rows = 4, cols = 5;
//    String[] sentence = new String[]{"I", "had", "apple", "pie"};
//    List<String> lines = wordsTyping(sentence, rows, cols);

    int rows = 1000, cols = 9001;
    String[] sentence = new String[]{"try", "to", "be", "better"};
//    int res = wordsTyping(sentence, rows, cols);
    int res = wordsTyping_TLE(sentence, rows, cols);
    System.out.println(res);
  }
}