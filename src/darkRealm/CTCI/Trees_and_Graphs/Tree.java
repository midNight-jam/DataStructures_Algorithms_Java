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
}