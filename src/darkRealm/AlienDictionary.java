package darkRealm;

import java.util.*;

public class AlienDictionary {

// 269. Alien Dictionary
// Share
// There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
// You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
// Derive the order of letters in this language.

// Example 1:

// Input:
// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]

// Output: "wertf"
// Example 2:

// Input:
// [
//   "z",
//   "x"
// ]

// Output: "zx"
// Example 3:

// Input:
// [
//   "z",
//   "x",
//   "z"
// ] 

// Output: "" 

// Explanation: The order is invalid, so return "".
// Note:

// You may assume all letters are in lowercase.
// You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.

  boolean isCycle;

  // NOTE: the alienOrder doesnt has to be exact
  // Input : ["wrt", "wrz",   "er",  "ett",  "rftt"]
  // Output : "wfertz"
  // Expected : fwertz"
  // its still valid because f+w both appear before the rest of dependent nodes, just like in graph with isolate nodes / more than 1 node as a start node

  public String alienOrder(String[] words) {
    if (words == null || words.length < 1) return "";
    Map<Character, List<Character>> adjList = new HashMap<>();
    boolean[] done = new boolean[26];
    boolean[] recStack = new boolean[26];

    for (String w : words)
      for (char c : w.toCharArray())
        if (!adjList.containsKey(c)) {
          adjList.put(c, new ArrayList<>());
        }


    String prev, curr;
    int pi, ci;
    int pc, cc;
    for (int i = 1; i < words.length; i++) {
      prev = words[i - 1];
      curr = words[i];
      pi = ci = 0;
      while (pi < prev.length() || ci < curr.length()) {
        pc = pi < prev.length() ? prev.charAt(pi) : -1;
        cc = ci < curr.length() ? curr.charAt(ci) : -1;
        if (pc != cc) {
          char cpc = (char) pc;
          char ccc = (char) cc;
          if (adjList.containsKey(cpc))
            adjList.get(cpc).add(ccc);
          break;
        }

        pi++;
        ci++;
      }
    }

    List<Character> res = new ArrayList<>();
    boolean valid = true;
    for (char k : adjList.keySet()) {
      if (done[k - 'a']) continue;
      valid &= dfs(k, res, adjList, done, recStack);
      if (!valid) return "";
    }
    //to
    StringBuilder sbr = new StringBuilder();
    for (char c : res)
      sbr.append(c);
    String rr = sbr.toString();
    System.out.println(rr);
    return rr;
  }

  static private boolean dfs(char v, List<Character> res, Map<Character, List<Character>> adjList, boolean[] done, boolean[] recStack) {
    if (recStack[v - 'a']) return false;
    recStack[v - 'a'] = true;
    List<Character> nbors = adjList.get(v);
    for (char n : nbors) {
      if (done[n - 'a']) continue;
      boolean valid = dfs(n, res, adjList, done, recStack);
      if (!valid) return false;
    }

    recStack[v - 'a'] = false;
    done[v - 'a'] = true;
    res.add(0, v);
    return true;
  }
}
