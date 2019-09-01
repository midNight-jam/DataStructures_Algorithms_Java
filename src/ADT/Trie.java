package ADT;

/**
 * Created by Jayam on 9/5/2016.
 */
public class Trie {

//  208. Implement Trie (Prefix Tree)
//  Implement a trie with insert, search, and startsWith methods.
//
//      Example:
//
//  Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");
//trie.search("app");     // returns true
//  Note:
//
//  You may assume that all inputs are consist of lowercase letters a-z.
//  All inputs are guaranteed to be non-empty strings.


  class TrieNode {
    char val;
    TrieNode[] childs;
    boolean completeWord;

    TrieNode(char c) {
      val = c;
      childs = new TrieNode[26];
    }
  }

  TrieNode root;

  public Trie() {
    root = new TrieNode((char) 0);
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    if (word == null || word.length() < 1) return;
    TrieNode trav = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int pos = c - 'a';
      if (trav.childs[pos] == null) {
        trav.childs[pos] = new TrieNode(c);
      }
      trav = trav.childs[pos];
    }
    trav.completeWord = true;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    if (word == null || word.length() < 1) return false;
    TrieNode trav = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int pos = c - 'a';
      if (trav.childs[pos] == null) return false;
      trav = trav.childs[pos];
    }
    return trav.completeWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    if (prefix == null || prefix.length() < 1) return false;
    TrieNode trav = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      int pos = c - 'a';
      if (trav.childs[pos] == null) return false;
      trav = trav.childs[pos];
    }
    return trav != null;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }
}
