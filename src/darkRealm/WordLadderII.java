package darkRealm;

import java.util.*;

public class WordLadderII {





/*
  #126. Word Ladder II
  Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
  Only one letter can be changed at a time
  Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
  For example,
  Given:
  beginWord = "hit"
  endWord = "cog"
  wordList = ["hot","dot","dog","lot","log","cog"]
  Return
  [
      ["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]
      ]
  Note:
  Return an empty list if there is no such transformation sequence.
  All words have the same length.
  All words contain only lowercase alphabetic characters.
  You may assume no duplicates in the word list.
  You may assume beginWord and endWord are non-empty and are not the same.
  */

  static class WNode { // a helper node for Djikstrars
    String word;
    int dist;
    WNode prev;

    public WNode(String word, int dist, WNode prev) {
      this.word = word;
      this.dist = dist;
      this.prev = prev;
    }
  }

  public static List<List<String>> findLadders(String start, String end, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    List<List<String>> paths = new ArrayList<>();
    if (!dict.contains(end)) return paths; // if end not in dict then return

    LinkedList<WNode> queue = new LinkedList<>();
    queue.add(new WNode(start, 1, null));// start que with start word & dist as 1

    HashSet<String> visited = new HashSet<>();
    HashSet<String> unvisited = new HashSet<>();
    unvisited.addAll(dict);
    int preDist = 0;

    while (!queue.isEmpty()) {
      WNode trav = queue.remove();
      String word = trav.word;
      int currDist = trav.dist;

      // type this after you have typed the word forming logic
       // if we have reached the end, traverse the list & find all the words in path
      if (word.equals(end)) { // we ahve found
        ArrayList<String> list = new ArrayList<String>();
        list.add(trav.word);
        while (trav.prev != null) {
          list.add(0, trav.prev.word);
          trav = trav.prev;
        }
        paths.add(list);
        continue; // so that we dont try out the new words from here, thus continue
      }

      // means we have reached here with the min dist thus there is no point in processsing these words again
      if (preDist < currDist) {
        unvisited.removeAll(visited);
      }
      preDist = currDist;

      // new word forming logic
      char[] arr = word.toCharArray();
      for (int i = 0; i < arr.length; i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          char temp = arr[i];
          if (arr[i] != c) {
            arr[i] = c;
          }
          String formed = new String(arr);
          if (unvisited.contains(formed)) {
            queue.add(new WNode(formed, trav.dist + 1, trav));
            visited.add(formed);
          }
          arr[i] = temp;
        }
      }
    }
    return paths;
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

    List<List<String>> res = findLadders(start, end, dict);
//    List<List<String>> res = LC_Prob_Med2.wordLadderDFS(start, end, dict);
    System.out.println("res : " + res);
  }
}
