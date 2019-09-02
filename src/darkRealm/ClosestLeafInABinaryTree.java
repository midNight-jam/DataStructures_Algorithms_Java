package darkRealm;

import java.util.*;

public class ClosestLeafInABinaryTree {

//  742. Closest Leaf in a Binary Tree
//  Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf
//  node to target k in the tree.
//
//  Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree.
//  Also, a node is called a leaf if it has no children.
//
//  In the following examples, the input tree is represented in flattened form row by row. The actual root tree given
//  will be a TreeNode object.
//
//  Example 1:
//
//  Input:
//  root = [1, 3, 2], k = 1
//  Diagram of binary tree:
//      1
//      / \
//      3   2
//
//  Output: 2 (or 3)
//
//  Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
//  Example 2:
//
//  Input:
//  root = [1], k = 1
//  Output: 1
//
//  Explanation: The nearest leaf node is the root node itself.
//      Example 3:
//
//  Input:
//  root = [1,2,3,4,null,null,null,5,null,6], k = 2
//  Diagram of binary tree:
//      1
//      / \
//      2   3
//      /
//      4
//      /
//      5
//      /
//      6
//
//  Output: 3
//  Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
//  Note:
//  root represents a binary tree with at least 1 node and at most 1000 nodes.
//  Every node has a unique node.val in range [1, 1000].
//  There exists some node in the given binary tree for which node.val == k.


  /*
   * My solution uses a custom post order, though it works, its not intuitive & lengthy, plus hard to come up in short time
   * There is another way of solving this with treating tree as undirected graph & firing BFS, will do that too.
   * */

  static TreeNode start;

  public static int findClosestLeaf(TreeNode root, int k) {
    if (root == null) return -1;

    Map<Integer, List<TreeNode>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    buildAdjMap(root, null, k, map);

    Queue<TreeNode> que = new LinkedList<>();
    que.offer(start);

    while (que.size() > 0) {
      int p = que.size();
      while (p-- > 0) {
        TreeNode trav = que.poll();
        visited.add(trav.val);
        if (trav.left == null && trav.right == null)
          return trav.val; // this is the first leaf

        List<TreeNode> nbors = map.get(trav.val);
        for (TreeNode n : nbors) {
          if (visited.contains(n.val)) continue;
          que.offer(n);
        }
      }
    }

    return -1;
  }


  // Traverse the tree & build the adjacency map
  private static void buildAdjMap(TreeNode root, TreeNode par, int k, Map<Integer, List<TreeNode>> map) {
    if (root.val == k)
      start = root;

    map.put(root.val, new ArrayList<>());

    if (par != null)
      map.get(root.val).add(par);

    if (root.left != null) {
      map.get(root.val).add(root.left);
      buildAdjMap(root.left, root, k, map);
    }

    if (root.right != null) {
      map.get(root.val).add(root.right);
      buildAdjMap(root.right, root, k, map);
    }
  }


  /*
   * WARNING! DONT SEE BELOW CODE.
   */
  private static class Data {
    TreeNode leaf;
    int dist;

    Data(TreeNode l, int d) {
      leaf = l;
      dist = d;
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int minD;
  static TreeNode leaf;

  public static int findClosestLeafCUSTOMPOSTORDERSHITCODE(TreeNode root, int k) {
    if (root == null) return -1;
    minD = Integer.MAX_VALUE;
    leaf = null;
    Data data = helper(root, k, new Data(null, Integer.MAX_VALUE));
    System.out.println("Final DAta : root  : " + data.leaf.val + "  dist : " + data.dist);
    return minD;
  }

  private static Data helper(TreeNode root, int k, Data parData) {
    if (root == null) return null;
    boolean isLeaf = root.left == null && root.right == null;
    Data myData = isLeaf ? new Data(root, 0) : new Data(null, Integer.MAX_VALUE);
    // gather info from childs first
    Data leftData = helper(root.left, k, null);
    Data rightData = helper(root.right, k, null);

    if (root.val == k) {
      if (myData.leaf != null && myData.dist + 1 < minD) {
        minD = myData.dist + 1;
        leaf = root;
      }

      if (parData != null && parData.leaf != null && parData.dist + 1 < minD) {
        minD = parData.dist + 1;
        leaf = parData.leaf;
      }

      if (leftData != null && leftData.leaf != null && leftData.dist + 1 < minD) {
        minD = leftData.dist + 1;
        leaf = leftData.leaf;
      }

      if (rightData != null && rightData.leaf != null && rightData.dist + 1 < minD) {
        minD = rightData.dist + 1;
        leaf = rightData.leaf;
      }
    }

    // now send the data to left or right subtree again
    if (leftData != null && rightData != null && leftData.dist < rightData.dist)
      helper(root.right, k, new Data(leftData.leaf, leftData.dist + 1));
    if (leftData != null && rightData != null && leftData.dist > rightData.dist)
      helper(root.left, k, new Data(rightData.leaf, rightData.dist + 1));


    // return the minDist data
    Data returnData = new Data(null, Integer.MAX_VALUE);
    if (leftData != null && leftData.leaf != null && leftData.dist < returnData.dist)
      returnData = leftData;
    if (rightData != null && rightData.leaf != null && rightData.dist < returnData.dist)
      returnData = rightData;
    if (myData.dist < returnData.dist)
      returnData = myData;

    returnData.dist++;
    return returnData;
  }


  public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//    int res = findClosestLeaf(root, 1);
//    System.out.println(res);

//    TreeNode root = new TreeNode(1);
//    int res = findClosestLeaf(root, 1);
//    System.out.println(res);

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(8);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.left.left = new TreeNode(6);
    root.left.left.left.left = new TreeNode(7);
    int res = findClosestLeaf(root, 2);
    System.out.println(res);
  }
}
