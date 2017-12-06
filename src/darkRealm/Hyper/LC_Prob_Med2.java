package darkRealm.Hyper;

import java.util.*;

/**
 * Created by Jayam on 2/4/2017.
 */
public class LC_Prob_Med2 {

  /*  [Prob 127] Word Ladder
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


  /* [Prob 126] WordLadderII
  * */
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

  public static List<List<String>> wordLadderII(String start, String end, List<String> wordList) {
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
      if (word.equals(end)) { // we ahve found
        ArrayList<String> list = new ArrayList<String>();
        list.add(trav.word);
        while (trav.prev != null) {
          list.add(0, trav.prev.word);
          trav = trav.prev;
        }
        paths.add(list);
        continue;
      }

      if (preDist < currDist) { // means we have reached here with the min dist thus there is no point in processsing these words again
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


  /*  [Prob 140]
  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
  * construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain
  * duplicate words.
  * Return all such possible sentences.
  * For example, given
  * s = "catsanddog",
  * dict = ["cat", "cats", "and", "sand", "dog"].
  * solution is ["cats and dog", "cat sand dog"].
  * A) we use a hashMap to store the list of words that can be formed via dictionary by using some portion of the original
  * string. For this purpose we break the string from behind & check if the backPortion cab be formed using dictinary,
  * if yes then we send the front remainder for same process if at the end the frontRem can be broken down in to valid word
  * formed via dictionary then those words are returned, this is the portion to pay attention we verify this by checking
  * the returned sub list length, while this subresult is returned & stored in map, we add these
  * results to the previously borken down backPortion and add this sub portion in map. hence while returning from recursion
  * we will fianlly have the results of valid borken words  against the same key from where we can return.
  * */
  public static List<String> wordBreakII(String str, List<String> wordDict) {
    Map<String, List<String>> subResMap = new HashMap<>();
    return wordBreakAll(str, wordDict, subResMap);
  }

  private static List<String> wordBreakAll(String str, List<String> dict, Map<String, List<String>> subResMap) {
    if (subResMap.containsKey(str)) return subResMap.get(str);
    List<String> subList = new ArrayList<>();
    if (dict.contains(str)) subList.add(str);
    String backPart;
    for (int i = 1; i < str.length(); i++) {
      backPart = str.substring(i);
      if (dict.contains(backPart)) {
        String frontRem = str.substring(0, i);
        List<String> backRes = wordBreakAll(frontRem, dict, subResMap);
        if (backRes.size() > 0)
          for (int j = 0; j < backRes.size(); j++)
            subList.add(backRes.get(j) + " " + backPart);
      }
    }
    subResMap.put(str, subList);
    return subResMap.get(str);
  }


  public static String shortestPath(char[][] matrix, char a, char b) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return "";
    int startR, startC;
    startR = startC = 0;
    boolean found = false;
    char toSearch = '\u0000';
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == a || matrix[i][j] == b) {
          startR = i;
          startC = j;
          found = true;
          toSearch = matrix[i][j] == a ? b : a;
          break;
        }
      }
      if (found) break;
    }
    return found ? bfsShortestPath(matrix, startR, startC, toSearch) : "";
  }

  private static String bfsShortestPath(char[][] matrix, int startR, int startC, char toSearch) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int[] rowNeighbours = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] colNeighbours = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    Queue<QueNode> queue = new LinkedList<>();
    queue.add(new QueNode(0, startR, startC, matrix[startR][startC] + ""));
    QueNode trav;
    while (!queue.isEmpty()) {
      trav = queue.remove();
      visited[trav.row][trav.col] = true;
      if (toSearch == matrix[trav.row][trav.col]) {
        return trav.path;
      }
      int eRow, eCol;
      for (int i = 0; i < rowNeighbours.length; i++) {
        eRow = trav.row + rowNeighbours[i];
        eCol = trav.col + colNeighbours[i];
        if (isSafe(matrix, eRow, eCol, visited))
          queue.add(new QueNode(trav.dist + 1, eRow, eCol, trav.path + " " + matrix[eRow][eCol]));
      }
    }
    return "";
  }

  private static boolean isSafe(char[][] matrix, int r, int c, boolean[][] visited) {
    return (r > -1 && r < matrix.length && c > -1 && c < matrix[0].length && !visited[r][c]);
  }

  private static class QueNode {
    int dist;
    int row;
    int col;
    String path;

    QueNode(int l, int r, int c, String p) {
      dist = l;
      row = r;
      col = c;
      path = p;
    }
  }
}