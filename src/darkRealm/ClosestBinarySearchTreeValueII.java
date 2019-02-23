package darkRealm;

import java.util.*;

public class ClosestBinarySearchTreeValueII {

//  272. Closest Binary Search Tree Value II
//  Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
//
//      Note:
//  Given target value is a floating point.
//  You may assume k is always valid, that is: k ≤ total nodes.
//  You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
//      Example:
//
//  Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
//
//          4
//        / \
//       2   5
//      / \
//     1   3
//
//  Output: [4,3]
//  Follow up:
//  Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class HeapNode {
    TreeNode node;
    double diff;

    HeapNode(TreeNode n, double d) {
      node = n;
      diff = d;
    }
  }

  //Time Complexity : O(N*logK)
  public static List<Integer> closestKValues(TreeNode root, double target, int k) {
    List<Integer> res = new ArrayList<>();
    if (root == null || k < 1) return res;

    Queue<HeapNode> maxHeap = new PriorityQueue<>(new Comparator<HeapNode>() {
      @Override
      public int compare(HeapNode o1, HeapNode o2) {
        if (o1.diff < o2.diff)
          return 1;
        if (o1.diff > o2.diff)
          return -1; // as we are creating max heap
        return 0;
      }
    });

    inorder(root, target, k, maxHeap);

    while (maxHeap.size() > 0)
      res.add(maxHeap.poll().node.val);
    return res;
  }

  private static void inorder(TreeNode root, double target, int k, Queue<HeapNode> maxHeap) {
    if (root == null) return;

    double diff = Math.abs(root.val - target);
    maxHeap.offer(new HeapNode(root, diff));

    if (maxHeap.size() > k)
      maxHeap.poll();

    inorder(root.left, target, k, maxHeap);
    inorder(root.right, target, k, maxHeap);
  }

  public static List<Integer> closestKValuesFaster_IDEARIGHT_BUTNOTCODE(TreeNode root, double target, int k) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Stack<TreeNode> successorStack = new Stack<>();
    initializeSuccessorStack(successorStack, root, target);
    Stack<TreeNode> predecessorStack = new Stack<>();
    initializePredecessorStack(predecessorStack, root, target);

    double sucDiff = Double.MAX_VALUE;
    double predDiff = Double.MAX_VALUE;
    TreeNode succ = null, pred = null;
    while (k-- > 0) {
      if (predecessorStack.size() < 1 && successorStack.size() < 1) break;
      if (predecessorStack.size() < 1) {
        succ = successorStack.pop();
        res.add(succ.val);
      } else if (successorStack.size() < 1) {
        pred = predecessorStack.pop();
        res.add(pred.val);
      } else {
        sucDiff = Math.abs(successorStack.peek().val - target);
        predDiff = Math.abs(predecessorStack.peek().val - target);
        if (sucDiff < predDiff) {
          succ = successorStack.pop();
          res.add(succ.val);
        } else {
          pred = predecessorStack.pop();
          res.add(pred.val);
        }
      }
      if (successorStack.isEmpty())
        nextSuccessor(successorStack, succ);

      if (predecessorStack.isEmpty())
        nextSuccessor(predecessorStack, pred);
    }

    return res;
  }

  private static void initializeSuccessorStack(Stack<TreeNode> sucStack, TreeNode root, double target) {
    while (root != null) {
      if (root.val == target) {
        sucStack.push(root);
        break;
      }
      if (target < root.val) {
        sucStack.push(root);
        root = root.right;
      } else
        root = root.left;
    }
  }

  private static void initializePredecessorStack(Stack<TreeNode> predStack, TreeNode root, double target) {
    while (root != null) {
      if (root.val == target) {
        predStack.push(root);
        break;
      }
      if (target > root.val) {
        predStack.push(root);
        root = root.left;
      } else
        root = root.right;
    }
  }

  private static void nextSuccessor(Stack<TreeNode> sucStack, TreeNode root) {
    if (root == null) return;
    root = root.right;
    while (root != null) {
      sucStack.push(root);
      root = root.left;
    }
  }

  private static void nextPredcessor(Stack<TreeNode> sucStack, TreeNode root) {
    if (root == null) return;
    root = root.left;
    while (root != null) {
      sucStack.push(root);
      root = root.right;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

//    List<Integer> res = closestKValuesFaster_IDEARIGHT_BUTNOTCODE(root, 3.714286, 2);
//    List<Integer> res = closestKValuesFaster_IDEARIGHT_BUTNOTCODE(root, 4.414286, 2);
    List<Integer> res = closestKValues(root, 3.714286, 2);
    System.out.println(res);
  }
}
