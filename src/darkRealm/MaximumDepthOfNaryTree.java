package darkRealm;

import java.util.List;

public class MaximumDepthOfNaryTree {

  //    559. Maximum Depth of N-ary Tree
//    Given a n-ary tree, find its maximum depth.
//    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//    For example, given a 3-ary tree:
//    We should return its max depth, which is 3.
//    Note:
//    The depth of the tree is at most 1000.
//    The total number of nodes is at most 5000.

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  int depth;

  public int maxDepth(Node root) {
    depth = 0;
    dfs(root, 1);
    return depth;
  }

  private void dfs(Node root, int d) {
    if (root == null) return;
    if (d > depth) depth = d;
    for (int i = 0; i < root.children.size(); i++)
      dfs(root.children.get(i), d + 1);
  }

  public static void main(String[] args) {
  }
}
