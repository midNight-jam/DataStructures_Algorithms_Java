package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    isCycle = false;
    boolean [][] adjList = new boolean[26][26];
    int [] visited = new int[26];
    List<Character> res = new ArrayList<>();
    Arrays.fill(visited, -1); // initial graph has no vertices

    for(String s : words)
      for(char c : s.toCharArray())
        visited[c - 'a'] = 0; // mark the presence of a vertice

    String prev, curr;
    char pc, cc;
    // Create adjacency Matrix
    for(int i = 1; i < words.length; i++){
      prev = words[i-1];
      curr = words[i];
      int len = Math.min(prev.length(), curr.length());

      for(int pi = 0; pi < len; pi++){
        pc = prev.charAt(pi);
        cc = curr.charAt(pi);
        if(pc != cc){
          adjList[pc - 'a'][cc - 'a'] = true; // there is a edge from pc to cc
          break; // break at first mismatch, because only this gives the info that currentChar comes after prevChar
          // for more info on this check the solution of VerifyingAnAlienDictionary
        }
      }
    }

    // fire dfs from all who are not visited
    for(int i = 0; i < 26; i++){
      if(visited[i] == 0)
        dfs(adjList, visited, i, res);

      if(isCycle) // if there is a cycle, we cannot form alienOrder
        return "";
    }



    StringBuilder sbr = new StringBuilder();
    for(char c : res){
      sbr.append(c);
    }

    return sbr.toString();
  }

  private void dfs(boolean [][] adjList, int [] visited, int vi, List<Character> res){
    if(isCycle) return;
    visited[vi] = 1; // mark this node in processing state

    for(int i = 0; i < 26; i++){
      if(adjList[vi][i] == true){
        if(visited[i] == 1){ // the neighbour vertex is already under processing state, its a cycle
          isCycle = true;
          return;
        }
        if(visited[i] == 0){ // the neighbor is not visited yet
          dfs(adjList, visited, i, res);
        }
      }
    }
    visited[vi] = 2; // mark this vertice as finished state
    res.add(0, (char)(vi + 'a')); // prepare the result
  }
}
