package com.darkRealm.Trees_and_Graphs;

import com.darkRealm.LinkedLists.LinkedList;
import com.darkRealm.Stacks_and_queues.MyQueue;
import org.restlet.ext.rdf.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    *   A) brute force, take inorder traversal and print the adjacent nodes of the data.
    *     Optimal : traverse through the tree
    *     Predecessor : if the node is the left most then it cannot have predecessor, else predecessor is the rightmost
    *     element in the left subtree. And if the node is not the right most and also ot deosnt have left subtree then
    *     we have to check if its the left or right child of its parent. if its the right child of its parent then its parent
    *     is the predecessor
    *     Successor: if the node is the right most then it cannot have Successor, else Successor is the leftmost
    *     element in the right subtree. And if the node is not the right most and also it doesnt have right subtree then
    *     we have to travel upwards to ge its sucecssor, in this case we have to keep going upwards untill the point wherre
    *     we have to take a right turn, at this point the parent & parents left data will be equal. This will be our sucecssor
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

  /*  [Prob 4.7]
  *   Q) build Order :  You are given a list of projects & a list of dependencies (which is a list of pairs ,
  *   where the second project is dependent on the first proj). All of the proj dependencies must be built before the proj.
   *   Find a valid build order, if none return error
   *   @params : projects - a,b,c,d,e,f
   *   @paramsn : dependencies - (a,d), (f,b), (b,d), (f,a), (d,c)
    *  @return : Output - f,e,a,b,d,c - build order
  * */
  public static String buildOrder(String projects, String dependencies) {
    String buildOrder = "";
    String[] projs = projects.split(",");
    HashMap<String, Node> nodes = new HashMap<>();
    for (int i = 0; i < projs.length; i++) {
      Node temp = new Node(projs.length);
      temp.name = projs[i];
      nodes.put(projs[i], temp);
    }
    String[] depends = dependencies.split(" ");

    for (int i = 0; i < depends.length; i++) {
      String parent = Character.toString(depends[i].charAt(1));
      String child = Character.toString(depends[i].charAt(3));

      Node parentNode = nodes.get(parent);
      parentNode.addChild(nodes.get(child));
    }

    Node start = getNodeWhichDoesntHaveParent(projs, nodes);
    Graph graph = new Graph(projs.length);
    graph.start = start;
    graph.processed = projs.length;

//    while(graph.processed!=0){
    while (graph.start != null) {
      graph.modifiedBreadthFirstTraversal();
      graph.start = getNodeWhichDoesntHaveParent(projs, nodes);
      ;
    }

    if (graph.processed == 0) {
      buildOrder = graph.buildOrder;
    } else {
      buildOrder = "Error";
    }
    // get any noed whose incoming edge is zero & process it , if that node is isolated then get another node whose i
    // incoming node is 0
    return buildOrder;
  }

  private static Node getNodeWhichDoesntHaveParent(String[] projs, HashMap<String, Node> nodes) {
    Node node = null;
    for (int i = 0; i < projs.length; i++) {
      Node temp = nodes.get(projs[i]);
      if ((temp.status != Node.Status.Processed) && temp.incomingEdges == 0) {
        return temp;
      }
    }
    return node;
  }

  //TODO
//  public static String buildOrderNew(String projects, String dependencies) {
//    String buildOrder = "";
//    // first prepare the graph
//    String[] projs = projects.split(",");
//    HashMap<String, Node> nodes = new HashMap<>();
//    for (int i = 0; i < projs.length; i++) {
//      Node temp = new Node(projs.length);
//      temp.name = projs[i];
//      nodes.put(projs[i], temp);
//    }
//    String[] depends = dependencies.split(" ");
//
//    for (int i = 0; i < depends.length; i++) {
//      String parent = Character.toString(depends[i].charAt(1));
//      String child = Character.toString(depends[i].charAt(3));
//
//      Node parentNode = nodes.get(parent);
//      parentNode.addChild(nodes.get(child));
//    }
//
//    //next we fire a DFS from any given node & continue to build the DFS traverse as the build order,
//    // untill we have either exhausted all the nodes from the grpah or we have encountered a Cycle
//    Node start = nodes.get(projs[0]);
//    // peerfrom the DFS from this node
//    while (!allProcessed(nodes)) {
//      // get the first node of the graph & use it to initialize the graph
//
//      Node tempNode = nodes.get(nodes.keySet().toArray()[0]);
//      Graph graph = new Graph(projs.length);
//      graph.start = tempNode;
//      String res = graph.modifiedDepthFirstTraversal();
//      if (res.equals("Error")) {
//        System.out.println("cannot produce a vlid build order");
//        return "Error";
//      }
//      buildOrder += res;
//      // removing the  processed  node
//      nodes.remove(tempNode);
//    }
//    return buildOrder;
//  }
//
//  private static boolean allProcessed(HashMap<String, Node> map) {
//    for (Map.Entry<String, Node> entry : map.entrySet()) {
//      if (entry.getValue().status == Node.Status.NotProcessed) {
//        return false;
//      }
//    }
//    return true;
//  }

  /*  [Prob 4.8]
  *   Q) FIrstCommonAncestor : find the first common ancestor 0f two nodes in a binary tree (NOT A BST)
  *   A)
  *
  *   [approcehd worked but filaed when data had parent child realtins ship]
  *   Will return boolean from recursive functions for each data, & will AND them both (left result * right result),
  *   the first node at which both ANDING gives true result then this is the common ancestor
  *   [Approach no 2] - works but inefficient
  *   look in each sub tree if the node is covered by sub tree or not. If both the nodes are covered by left subtree the
  *   go deep in left subtree, if both the nodes are covered bt right subtree then go in right subtree. Continue, till
  *   you find the nodes in diff subtree and not in common subtree. This node at which you find the node in diff subtree
  *   is the common ancestor
  * */
  public static void findCommonAncestor(Tree tree, int d1, int d2) {
//    TNode commonAncestor = findCommonAncestorAp2(tree.root, d1, d2);
    TNode commonAncestor = commonAncestor(tree.root, d1, d2);
    if (commonAncestor == null)
      System.out.println(" check debug no ancestor");
    else
      System.out.println(" check debug " + commonAncestor.data);
  }

  private static TNode commonAncestor(TNode node, int p, int q) {
    if (node == null) {
      return null;
    }
    if ((node.data == p) && (node.data != q)) {
      return node;
    }
    if ((node.data != p) && (node.data == q)) {
      return node;
    }

    TNode pSubTree = commonAncestor(node.left, p, q);
    TNode qSubTree = commonAncestor(node.right, p, q);

    if ((pSubTree != null) && (pSubTree.data != p) && (pSubTree.data != q)) {
      return pSubTree; // common ancestor found, percolating up
    }

    if ((qSubTree != null) && (qSubTree.data != p) && (qSubTree.data != q)) {
      return qSubTree; // common ancestor found, percolating up
    }

    if ((pSubTree != null) && (qSubTree != null)) {
      return node; // this is the common ancestor
    }
    // this line returns the nonNull subtree
    return pSubTree == null ? qSubTree : pSubTree;
  }

  private static TNode findCommonAncestorAp2(TNode node, int d1, int d2) {
    boolean isPresentInTree = coversAp2(node, d1) && coversAp2(node, d2);
    if (!isPresentInTree) {
      return null;
    }
    return checkAncestorAp2(node, d1, d2);
  }

  private static boolean coversAp2(TNode node, int d) {
    if (node == null) {
      return false;
    }
    if (node.data == d) {
      return true;
    }
    return (coversAp2(node.left, d) || coversAp2(node.right, d));
  }

  private static TNode checkAncestorAp2(TNode node, int d1, int d2) {
    if (node == null || node.data == d1 || node.data == d2) {
      return node;
    }

    boolean d1InLeft = coversAp2(node.left, d1);
    boolean d2InLeft = coversAp2(node.left, d2);

    if (d1InLeft != d2InLeft) {
      return node; // the node found where both d1 & d2 are in diff subtrees
    }

    TNode subTreeTOLookIn = d1InLeft ? node.left : node.right;
    return checkAncestorAp2(subTreeTOLookIn, d1, d2);
  }

  public static boolean checkSubtree(Tree t1, Tree t2) {
    boolean res = checkSubtree(t1.root, t2.root, t2.root);
    System.out.print("res - " + res);
    return res;
  }

  /*[Pro 4.10]
  *  Q) Check Subtree, t1, t2 are 2 vey large binary trees, with T1 bigger than t2. Create an algorithm to determine if
  *  T2 is a subtree of T1
  * A) I created below algo
  * input : T1 & T2 (both are binary trees, given T1 is bigger than T2)
  * output : boolean (True means T2 is a subtree of T1)
  * checkSubtree(T1,T2,T2Root)
  *   if T2 = null then
  *   return true
  *   if T1 = null then
  *   return false
  *   if T1 = T2 then
  *     inLeft = checkSubtree(T1.left,T2.left,T2Root)
  *     inRight = checkSubtree(T1.right,T2.right,T2Root)
  *     if inleft = true & inright = true & T1 = T2Root then
  *       // this is the subtree match root
  *     return inleft & inright
  *   else
  *     belowLeft = checkSubtree(T1.left,T2Root,T2Root)
  *     belowRight = checkSubtree(T1.right,T2Root,T2Root)
  *     return belowLeft || belowRight
  * */

  private static boolean checkSubtree(TNode t1, TNode t2, TNode t2Root) {

    if (t1 == null) {
      return false;
    }

    boolean matchesHere = matchTreeTwo(t1, t2, t2Root);
    if (matchesHere) {
      return true;
    } else {
      boolean matchesInLeft = checkSubtree(t1.left, t2, t2Root);
      if (matchesInLeft) {
        return true;
      }
      boolean matchesInRight = checkSubtree(t1.right, t2, t2Root);
      return matchesInRight;
    }
  }

  private static boolean matchTreeTwo(TNode t1, TNode t2, TNode t2Root) {
    if (t2 == null) {
      return true;
    }
    if (t1 == null) {
      return false;
    }
    if (t1.data == t2.data) {
      boolean leftSubtree = matchTreeTwo(t1.left, t2.left, t2Root);
      boolean rightSubtree = matchTreeTwo(t1.right, t2.right, t2Root);
      // if this is the root & the result true has came percolating up
      if ((leftSubtree && rightSubtree) && (t1.data == t2Root.data)) {
        System.out.println("this is the root of subtree match " + t1.data);
      }
      return leftSubtree && rightSubtree;
    }
    return false;
  }

  /*  [Prob 4.9 substitute]
  *   Q) BST Sequence : A sorted sequence is given in an array. Find the no of BST that can be created from this array
  *  A) The no of tress that can be created for a root is total = NoOfWaysOfLeftSubtree *  NoOfWaysOfRightSubtree
  *  Have used recursion with base cases to get then total ways possible
  * */
  public static int NumberOfBSTSequences(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        System.out.println("not a valid BST array sequence");
        return 0;
      }
    }

    if (arr.length == 0) {
      return 0;
    }

    if (arr.length == 1) {
      return 1;
    }

    if (arr.length == 2) {
      return 2;
    }

    if (arr.length == 3) {
      return 5;
    }

    int total = 0;
    for (int i = 0; i < arr.length; i++) {
      total += calculateWaysBSTSequence(i, arr);
    }
    return total;
  }

  private static int calculateWaysBSTSequence(int rootIndex, int[] arr) {


    int rightSize = arr.length - rootIndex - 1; //accounting for root so -1
    int leftSize = arr.length - rightSize - 1; //accounting for root so -1

    int[] leftSubtree = new int[leftSize];
    for (int i = 0; i < leftSize; i++) {
      leftSubtree[i] = arr[i];
    }
    int leftSubtreeWays = NumberOfBSTSequences(leftSubtree);
    leftSubtreeWays = leftSubtreeWays == 0 ? 1 : leftSubtreeWays;

    int[] rightSubtree = new int[rightSize];
    for (int i = 0; i < rightSize; i++) {
      rightSubtree[i] = arr[rootIndex + 1 + i];
    }

    int rightSubtreeWays = NumberOfBSTSequences(rightSubtree);
    rightSubtreeWays = rightSubtreeWays == 0 ? 1 : rightSubtreeWays;

    int totalWays = leftSubtreeWays * rightSubtreeWays;
    // the total no of ways would be leftSubtreeways * rightSubtreeways
    return totalWays;
  }

  /*  [Prob 4.9]
  *   Q) BST Sequence A BST was created using an array from left to right and inserting elements from left to right. Now
  *   given a BST with distinct elements, print all possible arrays that can generate this BST
  *   A) I couldnt solve this question completly after several attempts, thus applying the solution as given by the
  *   CTCI. The magic salt here was to weave the two seperate linked lists (I failed to imagine use of linked list for
  *   holding elements) and then weaving these separate linked lists to get the combination. This weaving is then
  *   recurcisively called to get all the possible array representation of the given BST. Read below the weaving algo
  *   used from CTCI.
  *   ////////TODO THE CODE BELOW DOESNT WORKS AS EXPECTED HAS BUGS//////////
  * */
  public static ArrayList<LinkedList> possibleBSTArrays(TNode node) {
    ArrayList<LinkedList> result = new ArrayList<>();
    if (node == null) {
      result.add(new LinkedList());
      return result;
    }

    LinkedList prefix = new LinkedList();
    prefix.appendToTail(new com.darkRealm.LinkedLists.Node(node.data));

    ArrayList<LinkedList> leftSubTree = possibleBSTArrays(node.left);
    ArrayList<LinkedList> rightSubTree = possibleBSTArrays(node.right);

    // weave together the list to get all the combinations
    for (LinkedList left :
        leftSubTree) {
      for (LinkedList right :
          rightSubTree) {
        ArrayList<LinkedList> weaved = new ArrayList<>();
        weaveLists(left, right, weaved, prefix);
        result.addAll(weaved);
      }
    }
    return result;
  }

  private static void weaveLists(LinkedList left,
                                 LinkedList right,
                                 ArrayList<LinkedList> weaved,
                                 LinkedList prefix) {
    if (left.size() == 0 || right.size() == 0) {
      LinkedList result = new LinkedList();
      result.addAll(left);
      result.addAll(right);
      result.addAll(prefix);
      return;
    }
    // taking one from head and adding it to prefix & sending for recursion where it will again get short
    // after the recursion has came back we have to add back the removed node
    com.darkRealm.LinkedLists.Node headFirst = left.removeFirst();
    prefix.appendToTail(headFirst);
    weaveLists(left, right, weaved, prefix);
    prefix.removeLast();
    left.appendToHead(headFirst);

    com.darkRealm.LinkedLists.Node headSecond = right.removeFirst();
    prefix.appendToTail(headSecond);
    weaveLists(left, right, weaved, prefix);
    prefix.removeLast();
    right.appendToHead(headSecond);

  }


  /* [Prob 4.12]
  *   Q) paths with sum, given a binary tree in which nodes are conatins an integer value (which mught be positive or
  *   negative). Desingn an algorithm to count the number of paths that sum to a given value. The path does not need to
  *   start or end at the root or a leaf, but it must go downwards (travelling only from parent to child nodes).
  *   A) Approach 1 : Would pass the value at both the left subtree after adding the current nodes value to the sum.
  *     and would call recusively untill the leaf is encountered or the sum is reached. After that will print the path
  *     if the sum matches. And would recursively call the same method with left and right subtree.
  *     [COMPLEXITY - O(N^2)]
  * */

  public static int PathsWithSum(Tree tree, int value) {
    pathSumWays = 0;
    fireCalculatePathSums(tree.root, value);
    return pathSumWays;
  }

  private static void fireCalculatePathSums(TNode node, int value) {
    if (node == null) {
      return;
    }
    calculatePathsWithSum(node, 0, value); // firing for current node
    fireCalculatePathSums(node.left, value);  // firing for left subtree
    fireCalculatePathSums(node.right, value); // firing for right subtree
  }

  static int pathSumWays = 0;

  private static void calculatePathsWithSum(TNode node, int pathSum, int value) {
    if (node == null) {
      return;
    }

    pathSum += node.data;   // adding the current nodes data to the pathSum

    if (pathSum == value) {
      pathSumWays++;
      System.out.println("Reached path sum " + pathSumWays);
    }
    calculatePathsWithSum(node.left, pathSum, value);
    calculatePathsWithSum(node.right, pathSum, value);
  }
}