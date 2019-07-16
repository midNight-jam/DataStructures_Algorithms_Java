package darkRealm;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

//  987. Vertical Order Traversal of a Binary Tree
//  Given a binary tree, return the vertical order traversal of its nodes values.
//
//  For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1)
//  and (X+1, Y-1).
//
//  Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we
//  report the values of the nodes in order from top to bottom (decreasing Y coordinates).
//
//  If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
//
//  Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
//
//
//
//  Example 1:
//
//  Input: [3,9,20,null,null,15,7]
//  Output: [[9],[3,15],[20],[7]]
//  Explanation:
//  Without loss of generality, we can assume the root node is at position (0, 0):
//  Then, the node with value 9 occurs at position (-1, -1);
//  The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
//  The node with value 20 occurs at position (1, -1);
//  The node with value 7 occurs at position (2, -2).
//  Example 2:
//
//  Input: [1,2,3,4,5,6,7]
//  Output: [[4],[2],[1,5,6],[3],[7]]
//  Explanation:
//  The node with value 5 and the node with value 6 have the same position according to the given scheme.
//      However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
//
//
//  Note:
//
//  The tree will have between 1 and 1000 nodes.
//  Each node's value will be between 0 and 1000.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<TreeNode> que = new LinkedList<>();
    que.offer(root);
    Queue<Integer> colQue = new LinkedList<>();
    colQue.offer(0);
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    while (que.size() > 0) {
      int take = que.size();
      Map<Integer, List<Integer>> tempMap = new HashMap<>();
      while (take > 0) {
        TreeNode trav = que.poll();
        int colIndex = colQue.poll();

        min = Math.min(min, colIndex);
        max = Math.max(max, colIndex);

        if (!tempMap.containsKey(colIndex))
          tempMap.put(colIndex, new ArrayList<>());
        tempMap.get(colIndex).add(trav.val);

        if (trav.right != null) {
          que.offer(trav.right);
          colQue.offer(colIndex + 1);
        }
        if (trav.left != null) {
          que.offer(trav.left);
          colQue.offer(colIndex - 1);
        }

        take--;
      }
      // Sort each col index in this iteration & add it to final res, I honestly dont know why we require this :/
      for (int k : tempMap.keySet()) {
        if (!map.containsKey(k))
          map.put(k, new ArrayList<>());
        List<Integer> temp = tempMap.get(k);
        Collections.sort(temp);
        map.get(k).addAll(temp);
      }
    }

    for (int i = min; i <= max; i++) {
      if (!map.containsKey(i)) continue;
      List<Integer> col = map.get(i);
      res.add(col);
    }

    return res;
  }

  public static void main(String[] args) {

  }
}
