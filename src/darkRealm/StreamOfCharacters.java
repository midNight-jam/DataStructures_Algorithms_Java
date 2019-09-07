package darkRealm;

import java.util.LinkedList;

public class StreamOfCharacters {

//  1032. Stream of Characters
//  Implement the StreamChecker class as follows:
//
//  StreamChecker(words): Constructor, init the data structure with the given words.
//  query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to
//  newest, including this letter just queried) spell one of the words in the given list.
//
//  Example:
//
//  StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
//streamChecker.query('a');          // return false
//streamChecker.query('b');          // return false
//streamChecker.query('c');          // return false
//streamChecker.query('d');          // return true, because 'cd' is in the wordlist
//streamChecker.query('e');          // return false
//streamChecker.query('f');          // return true, because 'f' is in the wordlist
//streamChecker.query('g');          // return false
//streamChecker.query('h');          // return false
//streamChecker.query('i');          // return false
//streamChecker.query('j');          // return false
//streamChecker.query('k');          // return false
//streamChecker.query('l');          // return true, because 'kl' is in the wordlist
//
//
//  Note:
//
//      1 <= words.length <= 2000
//      1 <= words[i].length <= 2000
//  Words will only consist of lowercase English letters.
//  Queries will only consist of lowercase English letters.
//  The number of queries is at most 40000.

  class TrieNode {
    char c;
    boolean word;
    TrieNode[] childs;

    TrieNode(char cc) {
      c = cc;
      childs = new TrieNode[26];
    }
  }

  TrieNode root;
  LinkedList<Character> list;

  public StreamOfCharacters(String[] words) {
    root = new TrieNode((char) 0);
    list = new LinkedList<>();
    for (String w : words) {
      char[] arr = w.toCharArray();
      TrieNode trav = root;
      for (int i = arr.length - 1; i > -1; i--) {
        if (trav.childs[arr[i] - 'a'] == null)
          trav.childs[arr[i] - 'a'] = new TrieNode(arr[i]);
        trav = trav.childs[arr[i] - 'a'];
      }
      trav.word = true;
    }
  }

  /*
  * Idea is to create the trie by reversing the dict words & also query the trie in reverse order, for this we insert
  * at head of the list.
  * */
  public boolean query(char c) {
    list.add(0, c);
    TrieNode trav = root;
    for (int i = 0; i < list.size(); i++) {
      char qc = list.get(i);
      if (trav.childs[qc - 'a'] != null) {
        trav = trav.childs[qc - 'a'];
        if (trav.word)
          return true;
      } else break;
    }
    return false;
  }

  public static void main(String[] args) {
    String[] words = new String[]{"cd", "f", "kl"};
    StreamOfCharacters streamChecker = new StreamOfCharacters(words);
    System.out.println(streamChecker.query('a'));          // return false
    System.out.println(streamChecker.query('b'));          // return false
    System.out.println(streamChecker.query('c'));          // return false
    System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
    System.out.println(streamChecker.query('e'));          // return false
    System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
    System.out.println(streamChecker.query('g'));          // return false
    System.out.println(streamChecker.query('h'));          // return false
    System.out.println(streamChecker.query('i'));          // return false
    System.out.println(streamChecker.query('j'));          // return false
    System.out.println(streamChecker.query('k'));          // return false
    System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
  }
}
