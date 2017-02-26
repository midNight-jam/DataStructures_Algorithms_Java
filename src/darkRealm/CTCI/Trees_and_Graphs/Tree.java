package darkRealm.CTCI.Trees_and_Graphs;

import darkRealm.CTCI.Stacks_and_queues.MyStack;

import java.util.*;

/**
 * Created by Jayam on 12/27/2016.
 */
public class Tree {
  public TNode root;

  public Tree() {
  }

  public Tree(int data) {
    root = new TNode(data);
  }

  public void printInorderTraversal() {
    inOrder(root);
  }

  private void inOrder(TNode node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(" " + node.data);
      inOrder(node.right);
    }
  }

  public void insert(int d) {
    if (root == null) {
      root = new TNode(d);
    } else {
      root.insertInorder(d);
    }
  }

  public TNode getRandomNode() {
    Random random = new Random();
//    int index = random.nextInt(root.size);
    int index = 2;
    return root.getIndexNode(index);
  }

  public List<Integer> inorderTraversalIterative() {
    MyStack<TNode> stack = new MyStack<>();
    List<Integer> inorderTraversalIterative = new ArrayList<>();
    TNode trav = root;
    stack.push(trav);
    while (!stack.isEmpty()) {
      trav = stack.peek();
      // if has left child then push left child in stack
      if (trav.left != null) {
        stack.push(trav.left);
        trav = trav.left;
        continue;
      }
      // if doesnt has a left child then print this nodes, as its inorder correct place has arrived & pop from stack
      else if (trav.left == null) {
        trav = stack.pop();
        System.out.print(" " + trav.data);
        inorderTraversalIterative.add(trav.data);
        if (stack.isEmpty()) {
          return inorderTraversalIterative; //  if stack has became empty its time to return
        }
        while (trav.right == null && !stack.isEmpty()) {  //  Traverse upwards till we have reached a node that has its right child, there we will make a turn
          trav = stack.pop();
          System.out.print(" " + trav.data);
          inorderTraversalIterative.add(trav.data);
        }

        if (trav.right != null) {
          stack.push(trav.right);
        }
      }
    }
    return inorderTraversalIterative;
  }

  /* Storing the pre-order traversal  of the tree
  *  space " " being the delimiter
  * */
  public String serialize(TNode node) {
    StringBuilder sb = new StringBuilder();
    writePreOrderTree(node, sb);
    String res = sb.toString().substring(0, sb.length() - 1);
    return res;
  }

  private void writePreOrderTree(TNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("N ");
      return;
    }
    sb.append(node.data + " ");
    writePreOrderTree(node.left, sb);
    writePreOrderTree(node.right, sb);
  }

  /*Decode the tree from the string
  *  return null when you encounter N (terminator)
  * */
  public TNode deserialize(String srz) {
    if (srz == null || srz.length() < 1) return null;
    LinkedList<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(srz.split(" ")));
    return constructTree(nodes);
  }

  private TNode constructTree(LinkedList<String> nodes) {
    String last = nodes.remove();
    if (last.equals("N")) return null;
    TNode node = new TNode(Integer.valueOf(last));
    node.left = constructTree(nodes);
    node.right = constructTree(nodes);
    return node;
  }

  /*  [Prob 230]  Kth Smallest Element in a BST
   * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
   * Note:
   * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
   * Follow up:
   * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
   * How would you optimize the kthSmallest routine?
   * */
  public TNode getKthSmallestBST(int k) {
    kthNode = null;
    count = 0;
    inOrderDriver(this.root, k);
    return kthNode;
  }

  static TNode kthNode = null;
  static int count = 0;

  private void inOrderDriver(TNode node, int k) {
    if (node == null) return;
    inOrderDriver(node.left, k);
    count++;
    if (count == k) {
      kthNode = node;
      return;
    }
    inOrderDriver(node.right, k);
  }

  public static int uniqueBinarySearchTreesCount(int n) {
    if (n < 1) return 0;
    int[] res = new int[n + 1];
    // DP Solution
    // no of bst  = left Bst * right Bst
    res[0] = res[1] = 1; // only two nodes so only two bst possible, this is our recursion base case
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        res[i] += res[j - 1] * res[i - j];  // no of left bst * no of right bst
      }
    }
    return res[n];
  }

  public static List<TNode> uniqueBstList(int n) {
    if (n < 1) return new ArrayList<>();
    return createTrees(1, n);
  }

  private static List<TNode> createTrees(int start, int end) {
    List<TNode> list = new ArrayList<>();
    if (start > end) {  // terminals of leaf nodes
      list.add(null);
      return list;
    }
    if (start == end) {   // leaf node
      list.add(new TNode(start));
      return list;
    }
    List<TNode> left, right;

    for (int i = start; i <= end; i++) {
      left = createTrees(start, i - 1); // getting all possible left & right subtrees in postorder format
      right = createTrees(i + 1, end);
      // cartesian product of left & right subtrees
      for (TNode lnode : left) {
        for (TNode rnode : right) {
          TNode root = new TNode(i);
          root.left = lnode;
          root.right = rnode;
          list.add(root);
        }
      }
    }
    return list;
  }

  public List<Integer> inorderTraversal(TNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    TNode cur = root;
    Stack<TNode> stack = new Stack<>();
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.data);
      cur = cur.right;
    }
    return list;
  }

  public List<Integer> iterativeLevelOrder(TNode node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) return list;
    Queue<TNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TNode trav = queue.poll();
        System.out.print(" " + trav.data);
        if (trav.left != null) queue.add(trav.left);
        if (trav.right != null) queue.add(trav.right);
      }
      System.out.println();
    }
    return list;
  }

  /* [513] Find Bottom Left Tree Value
  * */
  public static int bottomLeftTreeValue(TNode node) {
    Queue<TNode> queue = new LinkedList<>();
    queue.add(node);
    TNode first = null;
    while (!queue.isEmpty()) {
      int size = queue.size();
      first = null;
      TNode trav;
      for (int i = 0; i < size; i++) {
        trav = queue.poll();
        if (first == null) first = trav;
        if (trav.left != null) queue.add(trav.left);
        if (trav.right != null) queue.add(trav.right);
      }
    }
    return first.data;
  }

  public String antiClockWiseCircumference(TNode node) {
    if (node == null) return "";
    List<List<Integer>> levels = new ArrayList<>();
    Queue<TNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TNode trav = queue.poll();
        list.add(trav.data);
        if (trav.left != null) queue.add(trav.left);
        if (trav.right != null) queue.add(trav.right);
      }
      levels.add(list);
    }
    StringBuilder sbL = new StringBuilder();
    StringBuilder sbR = new StringBuilder();
    for (int i = 1; i < levels.size(); i++) {
      List<Integer> lv = levels.get(i);
      sbL.append(lv.get(0)+" ");
    }
    for (int i = levels.size() - 1; i > 0; i--) {
      List<Integer> lv = levels.get(i);
      sbR.append(lv.get(lv.size() - 1)+" ");
    }

    List<Integer> lastRow = levels.get(levels.size() - 1);
    lastRow = lastRow.subList(1, lastRow.size() - 1);

    return node.data + " " + sbL.toString() + lastRow.toString() + sbR.toString();
  }
}