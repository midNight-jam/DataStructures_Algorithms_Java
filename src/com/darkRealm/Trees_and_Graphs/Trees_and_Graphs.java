package com.darkRealm.Trees_and_Graphs;

import com.darkRealm.Stacks_and_queues.MyQueue;

import java.sql.SQLSyntaxErrorException;
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

  public static Tree getSampleTree() {
    Tree tree = createMinimalHeightTree(new int[]{6, 5, 7, 10, 19, 20, 21});
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
  *   Thus for "optimazation", we try to use the return result of getHeight, now if the node that we are processing
  *   turns out to be imbalanced we will return an error. But our methods return type is int so we cant return a code.
  *   Thus, instead we return an error code Integer.MIN_VALUE, and we have to aslo check if the subtree hieght returned
  *   the error code, if yes we have to percolate up the error.
  *   @params : Tree -  the tree to check the balance
  *   @returns : Boolean  - result if the tree is balanced or not
  * */
  public static boolean isBalanced(Tree tree) {
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

  /*  [Prob 4.5]
  *   Q) Validate a BST implement a function to check if a binary tree is a BST
  *   A) woudl get the inorder done & check if it is sorted.
  *   If Sorted the tree is a valid BST else not
  *   FLAWED : But this above method is inefficient because even if the tree became invalid we will only know it after the
  *   inorder completes, instead we can break with an error code & percolate up the error to notify tree is not BST
  *   Opitmal Method : To check if any node is falling between a range or not, why because in the above methd a left
  *   subtree can easily hold a bigger values thus we are taking the ranges.
  *   if we go in the left subtree then we update hte max vlaue with that of the parent, If we move in the left subtree
  *   we update the min value with that of the parent. And, If  at any instant the value is not in range we return false
  * */
  public static boolean isBST(Tree tree) {
    boolean res = checkBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    System.out.println("IsBST - " + res);
    return res;
  }

  private static boolean checkBST(TNode node, int min, int max) {
    if (node == null) { // is a leaf node or no node base case
      return true;
    }
    if ((node.data > min) && (node.data < max)) { // data is within the range
      boolean leftBST = checkBST(node.left, min, node.data);
      if (leftBST) {  // if leftSubtree is Valid lets check right
        boolean rightBST = checkBST(node.right, node.data, max);
        return rightBST;  //  this shall be the result, if right was also valid BST
      } else {
        return false; // left itself is not a BST, no point in processing thus terminating
      }
    }
    return false;
  }

  /*
  *   Q) JUST PRINT NOT OPTIMAL, write a method to find the "NEXT" node i.e sucessor of a given node in a BST, Similarly predecessor
  *   A) would go with InOrderTRaversal while updating the two var's pre & suc to keep track of which was my pre.
  *     when the data is found, would enable a flag so that we exit by just after acessing the next node in Inorder (sucessor)
  * */
  public static void printPredecessorAndSucessorOLD(Tree tree, int data) {
    findPredAndSucd(tree.root, data);
    System.out.println("Pre " + predecessor + "  Suc " + successor);
  }

  private static void findPredAndSucd(TNode node, int data) {
    if (node == null) {
      return;
    }
    if (node.data == data) {
      updatePrec(node.left);
      updateSucc(node.right);
      return;
    }
    findPredAndSucd(node.left, data);
    findPredAndSucd(node.right, data);
  }

  private static int predecessor;

  private static void updatePrec(TNode node) {
    if (node == null) {
      return;
    }
    updatePrec(node.left);
//    System.out.println("Prec "+node.data);
    predecessor = node.data;
    updatePrec(node.right);
  }

  private static int successor = Integer.MIN_VALUE;

  private static void updateSucc(TNode node) {
    if (node == null) {
      return;
    }
    updateSucc(node.left);
//    System.out.println("Succc "+node.data);
    if (successor == Integer.MIN_VALUE)
      successor = node.data;
    updateSucc(node.right);
  }

  /*  [Prob 4.6]
    *   Q) Sucessor, write a method to find the "NEXT" node i.e sucessor of a given node in a BST, Similarly predecessor
    *   A) would go with InOrderTRaversal while updating the two var's pre & suc to keep track of which was my pre.
    *     when the data is found, would enable a flag so that we exit by just after acessing the next node in Inorder (sucessor)
    * */
  public static void printPredecessorAndSucessor(Tree tree, int data) {
    TNode node = tree.root;
    while (node != null && (node.data != data)) {
      if (data > node.data) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    TNode pred = findPredecessor(node);
    TNode succ = findSuccessor(node);
    System.out.println("stop debug to see the above values");
  }

  private static TNode findPredecessor(TNode node) {
    TNode trav = node;
    // if node has the left subtree, then return the rightmost in the left subtree
    if (trav.left != null) {
      trav = trav.left;
      while (trav.right != null) {
        trav = trav.right;
      }
      return trav;
    } else {
      // if node doesnt have the left subtree, then we have to check two things with parent, first is the node left child
      // of the prent, if yes, then we have reached the left most & it cannot have a predecessor. BUt, if the node is
      // the right child of parent then its predeccosr will be the \parent it self
      TNode par = trav.parent;
      if (par.right.data == trav.data) {
        return par;
      }
      // left most case
      if (par.left.data == trav.data) {
        return null;
      }
    }
    return null;
  }

  private static TNode findSuccessor(TNode node) {
    TNode trav = node;
    if (trav.right != null) { // node has right subtree so return left most in the right subtree
      trav = trav.right;
      while (trav.left != null) {
        trav = trav.left;
      }
      return trav;
    } else {
      TNode par = trav.parent;
      // if node doesnt has a right sbutree, then we have to travel upwards to find the node
      // where we are on left side instead of right, finding this end is required because as soon as we gon in the right
      // side, that element will be the succesor of this node.
      while ((par != null)) {
        if ((par.left != null) && (trav.data == par.left.data)) {
          break;
        }
        trav = par;
        par = trav.parent;
      }
      return par;
    }
  }
}