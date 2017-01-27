package darkRealm.CTCI.Trie;

/**
 * Created by Jayam on 9/5/2016.
 */
public class Trie {

    public TrieNode _root;
    private final int _childsSize = 26;

    public Trie() {
        _root = new TrieNode();
    }

    public void insert(String str) {
        str = str.toLowerCase();
        TrieNode trav = _root;
        int indexOfChar = -1;
        char currentChar;
        // find current char in nodes, if present proceed further if null then add char & move ahead
        int i;
        for (i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            indexOfChar = getIndexForChar(currentChar);

            if (trav._childs[indexOfChar] == null) {    // if encountered null, grow tree from here.
                trav._childs[indexOfChar] = new TrieNode();
            }
            trav = trav._childs[indexOfChar]; // move ahead in path
        }

        // why we are assigning value here, & not at creation of new node.
        // because it could happen that created node was for intermediate traverse, & thats why  after creating whole
        // path, now we are assigning the value.
        if (i == str.length()) {
            trav.setValue(str);
        }
    }

    private int getIndexForChar(char c) {
        return c - 'a';
    }

    public boolean search(String str) {
        str = str.toLowerCase();
        // traverse whole string, if u reached null & string is still pending,
        // this means string is not present in trie. If u reached value & string is exhausted,
        // then search is complete & match is found

        TrieNode trav = _root;
        int i = 0;
        int indexOfChar = -1;
        char currentChar;
        // either we have traversed the string or we have encountered a null, means trie has ended on the branch
        for (; i < str.length(); i++) {
            currentChar = str.charAt(i);
            indexOfChar = getIndexForChar(currentChar);
            if (trav._childs[indexOfChar] == null) {
                return false;
            }
            trav = trav._childs[indexOfChar];
        }
        if (i == str.length() && trav._value.equals(str)) {
            return true;
        }
        return false;
    }

    public void doPrint() {
        print(_root);
    }

    private void print(TrieNode trav) {
        if (trav != null) {
            if (trav._value != "") {
                System.out.println("Value : " + trav._value);
            }
            for (int i = 0; i < _childsSize; i++) {
                print(trav._childs[i]);
            }
        }
    }
}
