package ADT;

/**
 * Created by Jayam on 9/5/2016.
 */
public class TrieNode {

    String _value;
    public TrieNode[] _childs;

    TrieNode() {
        _value = "";
        int noOfAlphabets = 26;
        _childs = new TrieNode[noOfAlphabets];
    }

    public void setValue(String val) {
        _value = val;
    }

    public String getValue() {
        return _value;
    }
}
