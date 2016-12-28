package com.darkRealm.Trees_and_Graphs;

import com.darkRealm.Stacks_and_queues.MyQueue;

import java.util.ArrayList;

/**
 * Created by Jayam on 12/28/2016.
 */
public class Trees_and_Graphs {

  private static Graph getSampleGraph() {
    int vertices = 6;
    Graph graph = new Graph(vertices);
    Node vertex0 = new Node(vertices);
    vertex0.name = "0";
    graph.start = vertex0;
    Node vertex1 = new Node(vertices);
    vertex1.name = "1";
    graph.start.childs[1] = vertex1;

    Node vertex5 = new Node(vertices);
    vertex5.name = "5";
    graph.start.childs[5] = vertex5;

    Node vertex4 = new Node(vertices);
    vertex4.name = "4";
    graph.start.childs[4] = vertex4;

    vertex1.childs[4] = vertex4;

    Node vertex2 = new Node(vertices);
    vertex2.name = "2";
    vertex2.childs[1] = vertex1;

    Node vertex3 = new Node(vertices);
    vertex3.name = "3";
    vertex3.childs[2] = vertex2;
    vertex3.childs[4] = vertex4;
    vertex1.childs[3] = vertex3;

    graph.allVertices[0] = vertex0;
    graph.allVertices[1] = vertex1;
    graph.allVertices[2] = vertex2;
    graph.allVertices[3] = vertex3;
    graph.allVertices[4] = vertex4;
    graph.allVertices[5] = vertex5;
    return graph;
  }

  private static Tree getSampleTree() {
    Tree tree = createMinimalHeightTree(new int[]{2, 5, 7, 10, 19, 20, 25});
    return tree;
  }

  public static void doBFSAndDFS() {
    Graph graph = getSampleGraph();
    graph.BreadthFirstTraversal();
    graph.DepthFirstTraversal();
  }

  public static void isRoutePresentBetweenNodes() {
    Graph graph = getSampleGraph();
    Node p = graph.allVertices[0];
    Node q = graph.allVertices[0];
    System.out.println("Route Present - " + graph.isRouteBetween(p, q));
  }

  /*  [Prob 4.2 ]
  *   Q) Minimal tree, given a sorted increasing order array with unique integers, write a method to create a BST with
  *   minimal height.
  *   A) would take the mid of array as root & recursively divide the other two halfs to get left & right subRoot
  *   @params : arr - array of integers  to construct a minimal height BInary Search Tree with
  *   @return : TRee - the tree obj that is created after reading from the array
  * */
  public static Tree createMinimalHeightTree(int[] arr) {
    Tree tree = new Tree();
    tree.root = getRoot(arr, 0, arr.length - 1);
    return tree;
  }

  private static TNode getRoot(int[] arr, int left, int right) {
    if (right < left) {
      return null;
    }
    int mid = (left + right) / 2;
    TNode root = new TNode(arr[mid]);
    root.left = getRoot(arr, left, mid - 1);
    root.right = getRoot(arr, mid + 1, right);
    return root;
  }

  /*  [Prob 4.3]
  *   Q) List of Depths : given a binary tree, design an algo which creates a linkedlist of all the nodes at each depth
  *   So you will have D no of lists if D is the depth of the tree
  *   A) Will traverse the tree recursively and for each time when sending the call for subtree will increment the level
  *   counter & send, this levelCounter will be used to fetch the list for that level & insert the node in the list
  * */
  public static void listOfDepths() {
    ArrayList<MyQueue<TNode>> levels = new ArrayList<>();
    Tree tree = getSampleTree();
    collateByLevel(tree.root, 0, levels);
    // print all the lists (per level wise) to see the output
    for (int i = 0; i < levels.size(); i++) {
      MyQueue<TNode> level = levels.get(i);
      System.out.println("Level no - " + i);
      while (!level.isEmpty()) {
        System.out.print(level.deque().data + " ");
      }
      System.out.println();
    }
  }

  private static void collateByLevel(TNode node, int levelNo, ArrayList<MyQueue<TNode>> levels) {
    // base condition
    if (node == null) {
      return;
    }
    // if this level's Queue is not already present then create and add
    if (levels.size() < levelNo + 1) {
      levels.add(new MyQueue<>());
    }
    // Enqueue this node in its level queue
    MyQueue<TNode> levelList = levels.get(levelNo);
    levelList.enqueue(node);

    // call for left & right sub tree with incrementing a level
    collateByLevel(node.left, levelNo + 1, levels);
    collateByLevel(node.right, levelNo + 1, levels);
  }

  /*  [Prob 4.4]
  *   Q) Check Balanced : check if the given binary tree is balanced or not. Balance is such that the hieghts of two
  *   subtrees of any node never differ by more than one ie, balance can be -1, 0, +1
  *   A) Would get height of left & right subtree, and diff them to see if the diff is cmoing to a balanced value
  *   if not then the tree is noBalanced, if yes would continue, percolate up check same on the parent
  *   But this above method is not very efficient & takes O(NlogN) complexity
  *   Thus for optimazation, we try to use the return result of getHeight, now if the node that we are processing
  *   turns out to be imbalanced we will return an error. But our methods return type is int so we cant return a code.
  *   Thus, instead we return an error code Integer.MIN_VALUE, and we have to aslo check if the subtree hieght returned
  *   the error code, if yes we have to percolate up the error.
  *   @params : Tree -  the tree to check the balance
  *   @returns : Boolean  - result if the tree is balanced or not
  * */
  public static boolean isBalanced() {
    Tree tree = getSampleTree();
    tree.root.left.left.left = new TNode(1);
    tree.root.left.left.left.left = new TNode(0);
    tree.root.left.left.left.left.left = new TNode(-1);
    int res = getHeight(tree.root);
    boolean isBalanced = res == Integer.MIN_VALUE ? false : true;
    System.out.println("Is tree balanced - " + isBalanced);
    return isBalanced;
  }

  private static int getHeight(TNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = getHeight(node.left);
    if (leftHeight == Integer.MIN_VALUE) {  // percolate up the error
      return Integer.MIN_VALUE;
    }

    int rightHeight = getHeight(node.right);
    if (rightHeight == Integer.MIN_VALUE) { // percolate up the error
      return Integer.MIN_VALUE;
    }

    int diff = leftHeight - rightHeight;
    if (diff >= -1 && diff <= 1) {  // if the height diff is valid/balanced then return the bigger among them
      return 1 + Math.max(leftHeight, rightHeight);
    }
    return Integer.MIN_VALUE; // else the height diff is invalid so return Error
  }
}