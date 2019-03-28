package darkRealm;

import java.util.*;

public class CloneGraph {

  private static class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int v) {
      val = v;
    }

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  static Map<Integer, Node> map;

  public static Node cloneGraph(Node node) {
    map = new HashMap<>();
    helper(node);
    return map.get(node.val);
  }


  private static Node helper(Node node) {
    if (node == null) return null;

    // this is where we prevent infinite recursion
    if (map.containsKey(node.val))
      return map.get(node.val); // new node

    Node newNode = new Node(node.val);
    List<Node> nbrs = new ArrayList<>();

    map.put(node.val, newNode); // update map before going for dfs, this will prevent stack overflow

    // for all neighbors get the new node
    for (Node n : node.neighbors)
      nbrs.add(helper(n));

    newNode.neighbors = nbrs;
    return newNode;
  }

  public static void main(String[] args) {
    Node one = new Node(1, new ArrayList<>());
    Node two = new Node(2, new ArrayList<>());
    Node three = new Node(3, new ArrayList<>());
    Node four = new Node(4, new ArrayList<>());
    one.neighbors.add(two);
    one.neighbors.add(four);

    two.neighbors.add(three);
    two.neighbors.add(one);

    three.neighbors.add(two);
    three.neighbors.add(four);

    four.neighbors.add(three);
    four.neighbors.add(one);

    Node res = cloneGraph(one);
    System.out.println(res.val);
  }
}
