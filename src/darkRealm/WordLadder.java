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
  * */
  
  //Plain BFS traversal
  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    LinkedList<String> queue = new LinkedList<>();
    int count = 0;
    queue.add(beginWord);
    visited.add(beginWord);

    while (queue.size() > 0) {
      int size = queue.size();
      while(size-- > 0) {
        String headStr = queue.poll();
        if (headStr.equals(endWord))
          return count + 1;

        char[] head = headStr.toCharArray();
        // System.out.println("Head :"+headStr);
        for (int i = 0; i < head.length; i++) {
          char save = head[i];
          for (char ch = 'a'; ch <= 'z'; ch++) {
            head[i] = ch;
            String word = new String(head);

            if (!visited.contains(word) && set.contains(word)) {
              // System.out.println("Word :"+word);
              // System.out.println("Success");
              visited.add(word);
              queue.add(word);
            }
          }
          head[i] = save;
        }
      }

      System.out.println(queue);
      count++;
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

    int res = ladderLength(start, end, dict);
//    List<List<String>> res = LC_Prob_Med2.wordLadderDFS(start, end, dict);
    System.out.println("res : " + res);
  }
}
