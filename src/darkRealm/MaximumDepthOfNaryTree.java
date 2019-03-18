package darkRealm;

import java.util.List;
import java.util.Stack;

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


  class Helper {
    int depth;
    Node node;
    Helper(Node n, int d){
      depth = d;
      node = n;
    }
  }

  public int maxDepthIterative(Node root, int d) {
    depth = 0;
    if(root == null) return depth;

    Stack<Helper> stack = new Stack<>();
    Helper trav = new Helper(root, 1);
    stack.push(trav);

    while(stack.size() > 0){
      trav = stack.pop();
      if(trav.depth > depth) depth = trav.depth;
      // why from behind, because this is a stack what i insert after will be on top of what is present in stack
      //      1
      //   /  |   \
      //  2   3    4
      // after processing 1 we will have stack [4,3,2]
      // P.S. Well! starting from front also works, just found out -_-
      for(int i = trav.node.children.size() - 1; i >= 0; i--){
        stack.push(new Helper(trav.node.children.get(i), trav.depth + 1));
      }
    }
    return depth;
  }



  // Conventional recursive method also, dont do this in interview plz. Go for iterative
  int depth;

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
