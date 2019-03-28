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

//  133. Clone Graph
//  Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in
//  the graph contains a val (int) and a list (List[Node]) of its neighbors.
//
//      Example:
//  Input:
//  {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},
//  {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
//
//  Explanation:
//  Node 1's value is 1, and it has two neighbors: Node 2 and 4.
//  Node 2's value is 2, and it has two neighbors: Node 1 and 3.
//  Node 3's value is 3, and it has two neighbors: Node 2 and 4.
//  Node 4's value is 4, and it has two neighbors: Node 1 and 3.
//
//  Note:
//
//  The number of nodes will be between 1 and 100.
//  The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
//  Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
//  You must return the copy of the given node as a reference to the cloned graph.

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