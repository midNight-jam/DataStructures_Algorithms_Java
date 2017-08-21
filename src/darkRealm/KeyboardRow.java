package darkRealm;

import java.util.*;

public class KeyboardRow {
  /*
  * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
  * keyboard
  * Input: ["Hello", "Alaska", "Dad", "Peace"]
  * Output: ["Alaska", "Dad"]
  */

  public static String[] keyboardRowWords(String[] words) {
    if (words == null || words.length == 0)
      return words;
    Set[] sets = new Set[3];
    Set<Character> set = new HashSet<>();
    set.addAll(new ArrayList<>(Arrays.asList(new Character[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'})));
    sets[0] = set;
    set = new HashSet<>();
    set.addAll(new ArrayList<>(Arrays.asList(new Character[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'})));
    sets[1] = set;
    set = new HashSet<>();
    set.addAll(new ArrayList<>(Arrays.asList(new Character[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'})));
    sets[2] = set;

    List<String> fullRowWords = new ArrayList<>();
    String word;
    for (int i = 0; i < words.length; i++) {
      word = words[i].toLowerCase();
      int row = -1;
      for (int r = 0; r < 3; r++)
        if (sets[r].contains(word.charAt(0))) {
          row = r;
          break;
        }
      int j = 1;
      for (; j < word.length(); j++)
        if (!sets[row].contains(word.charAt(j)))
          break;
      if (j == word.length())
        fullRowWords.add(words[i]);
    }
    String[] res = new String[fullRowWords.size()];
    fullRowWords.toArray(res);
    return res;
  }

  public static void main(String[] args) {
    String[] input = new String[]{"Hello", "Alaska", "Dad", "Peace"};
    String[] output = keyboardRowWords(input);
    System.out.println("Input : " + Arrays.toString(input));
    System.out.println("Output : " + Arrays.toString(output));
  }
}