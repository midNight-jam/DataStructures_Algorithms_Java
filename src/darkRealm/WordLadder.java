package darkRealm;

import java.util.*;

public class WordLadder {


  /*
    #127 Word Ladder
  *   Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
  *   sequence from beginWord to endWord, such that:
  *   Only one letter can be changed at a time.
  *   Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
  *   For example,
  *   Given:
  *   beginWord = "hit"
  *   endWord = "cog"
  *   wordList = ["hot","dot","dog","lot","log","cog"]
  *   As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
  *   return its length 5.
  *
  *   A) Would use Bidirectinal BFS while keeping the nodes of the most recent levels from both the ends will terminate
  *   when we find any one word os found in most recent dist from other side.
  *   Complexity N/2 * maxBreadth(the nodes on the dist) wordLength * 26
  * */
  public static int wordLadder(String start, String end, List<String> dictionary) {
    if (!dictionary.contains(end)) return 0;
    Set<String> words = new HashSet<>(dictionary);
    Set<String> startSet = new HashSet<>(), endSet = new HashSet<>(), next = null;
    int pathLen = 1;
    // add start & end words to their sets
    startSet.add(start);
    endSet.add(end);
    words.remove(start);
    words.remove(end);
    while (!startSet.isEmpty()) {
      next = new HashSet<>();
      for (String word : startSet) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
          char old = wordArr[i];
          for (char c = 'a'; c <= 'z'; c++) {
            wordArr[i] = c;
            String formed = new String(wordArr);
            if (endSet.contains(formed))
              return pathLen + 1;
            if (words.contains(formed)) {
              next.add(formed);
              words.remove(formed);
            }
          }
          wordArr[i] = old;
        }
      }
      startSet = next.size() < endSet.size() ? next : endSet;
      endSet = startSet.size() < endSet.size() ? endSet : next;
      pathLen++;
    }
    return 0;
  }

  public static void main(String[] args) {

    List<String> dict = new ArrayList<>();

//    String[] arr = new String[]{"hot", "cog", "dot", "dog", "hit", "lot", "log"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "hit";
//    String end = "cog";


    String[] arr = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    dict.addAll(Arrays.asList(arr));
    String start = "hit";
    String end = "cog";


//    String[] arr = new String[]{"hot", "dot", "dog", "lot", "log"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "hit";
//    String end ="cog";
//
//    String[] arr = new String[]{"a","b","c"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "a";
//    String end = "c";

    int res = wordLadder(start, end, dict);
//    List<List<String>> res = LC_Prob_Med2.wordLadderDFS(start, end, dict);
    System.out.println("res : " + res);
  }
}
