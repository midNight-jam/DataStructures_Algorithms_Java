package darkRealm.CTCI.Trees_and_Graphs;

import ADT.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jayam on 12/28/2016.
 */
public class Trees_and_Graphs {

  public static Graph getSampleGraph() {
    int vertices = 6;
    Graph graph = new Graph(vertices);
    GNode vertex0 = new GNode(vertices);
    vertex0.name = "0";
    graph.start = vertex0;
    GNode vertex1 = new GNode(vertices);
    vertex1.name = "1";
    graph.start.childs[1] = vertex1;

    GNode vertex5 = new GNode(vertices);
    vertex5.name = "5";
    graph.start.childs[5] = vertex5;

    GNode vertex4 = new GNode(vertices);
    vertex4.name = "4";
    graph.start.childs[4] = vertex4;

    vertex1.childs[4] = vertex4;

    GNode vertex2 = new GNode(vertices);
    vertex2.name = "2";
    vertex2.childs[1] = vertex1;

    GNode vertex3 = new GNode(vertices);
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
//    graph.BreadthFirstTraversal();
    graph.DepthFirstTraversal();
  }

  public static void isRoutePresentBetweenNodes() {
    Graph graph = getSampleGraph();
    GNode p = graph.allVertices[0];
    GNode q = graph.allVertices[2];
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
  public static List<List<Integer>> listOfDepths(Tree tree) {
    TNode root = tree.root;
    List<List<Integer>> levels = new ArrayList<>();
    collateByLevel(root, 0, levels);
    return levels;
  }

  private static void collateByLevel(TNode node, int level, List<List<Integer>> levels) {
    if (node == null) {
      return;
    }
    if (levels.size() < level + 1) {
      levels.add(new ArrayList<>());
    }
    List<Integer> thisLevel = levels.get(level);
    thisLevel.add(node.data);
    collateByLevel(node.left, level + 1, levels);
    collateByLevel(node.right, level + 1, levels);
  }

  public static boolean checkBalanced(Tree tree) {
    int res = nodeHeightDiff(tree.root);
    return res != Integer.MIN_VALUE;
  }

  private static int nodeHeightDiff(TNode node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = nodeHeightDiff(node.left);
    if (leftHeight == Integer.MIN_VALUE) {
      return leftHeight;
    }
    int rightHeight = nodeHeightDiff(node.right);
    if (rightHeight == Integer.MIN_VALUE) {
      return rightHeight;
    }
    int diff = leftHeight - rightHeight;
    if (diff < -1 || diff > 1) {
      return Integer.MIN_VALUE;
    }
    return 1 + Math.max(leftHeight, rightHeight);
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
    boolean res = checkBST(tree.root, Long.MIN_VALUE, Long.MAX_VALUE);
    System.out.println("IsBST - " + res);
    return res;
  }

  private static boolean checkBST(TNode node, long min, long max) {
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
    HashMap<String, GNode> nodes = new HashMap<>();
    for (int i = 0; i < projs.length; i++) {
      GNode temp = new GNode(projs.length);
      temp.name = projs[i];
      nodes.put(projs[i], temp);
    }
    String[] depends = dependencies.split(" ");

    for (int i = 0; i < depends.length; i++) {
      String parent = Character.toString(depends[i].charAt(1));
      String child = Character.toString(depends[i].charAt(3));

      GNode parentGNode = nodes.get(parent);
      parentGNode.addChild(nodes.get(child));
    }

    GNode start = getNodeWhichDoesntHaveParent(projs, nodes);
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

  private static GNode getNodeWhichDoesntHaveParent(String[] projs, HashMap<String, GNode> nodes) {
    for (int i = 0; i < projs.length; i++) {
      GNode temp = nodes.get(projs[i]);
      if ((temp.status != GNode.Status.Processed) && temp.incomingEdges == 0)
        return temp;

    }
    return null;
  }

  //TODO
//  public static String buildOrderNew(String projects, String dependencies) {
//    String buildOrder = "";
//    // first prepare the graph
//    String[] projs = projects.split(",");
//    HashMap<String, LLNode> nodes = new HashMap<>();
//    for (int i = 0; i < projs.length; i++) {
//      LLNode temp = new LLNode(projs.length);
//      temp.name = projs[i];
//      nodes.put(projs[i], temp);
//    }
//    String[] depends = dependencies.split(" ");
//
//    for (int i = 0; i < depends.length; i++) {
//      String parent = Character.toString(depends[i].charAt(1));
//      String child = Character.toString(depends[i].charAt(3));
//
//      LLNode parentNode = nodes.get(parent);
//      parentNode.addChild(nodes.get(child));
//    }
//
//    //next we fire a DFS from any given node & continue to build the DFS traverse as the build order,
//    // untill we have either exhausted all the nodes from the grpah or we have encountered a Cycle
//    LLNode start = nodes.get(projs[0]);
//    // peerfrom the DFS from this node
//    while (!allProcessed(nodes)) {
//      // get the first node of the graph & use it to initialize the graph
//
//      LLNode tempNode = nodes.get(nodes.keySet().toArray()[0]);
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
//  private static boolean allProcessed(HashMap<String, LLNode> map) {
//    for (Map.Entry<String, LLNode> entry : map.entrySet()) {
//      if (entry.getValue().status == LLNode.Status.NotProcessed) {
//        return false;
//      }
//    }
//    return true;
//  }

  /*  [Prob 4.8]
  *   Q) FIrstCommonAncestor : find the first common ancestor 0f two nodes in a binary tree (NOT A BST)
  *   A)
  *   [Approach no 3] - percolate up the result, as the question said 2 nodes in the tree means both are present
  *   if we have reached the end or have found the data return that node
  *   at any nde we check if we are getting data(not null) from both the left & right then that node is the common ancestor
  *   In case of two node being par & child, parent node will be returned which is a always the common ancestor amon 2 nodes
  * */
  public static TNode findCommonAncestor(TNode root, TNode  p, TNode q) {
    if (root == null || root == p || root == q) return root;
    TNode left = findCommonAncestor(root.left, p, q);
    TNode right = findCommonAncestor(root.right, p, q);
    if (left == null) return right;
    if (right == null) return left;
    return root; // this is the node at which result has came from both left & right
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

  /* [Prob 4.12] There is another approach below, which is faster O(N), have a look at that too.
  *   Q) paths with sum, given a binary tree in which nodes are conatins an integer value (which mught be positive or
  *   negative). Desingn an algorithm to count the number of paths that sum to a given value. The path does not need to
  *   start or end at the root or a leaf, but it must go downwards (travelling only from parent to child nodes).
  *   A) Approach 1 : Would pass the value at both the left subtree after adding the current nodes value to the sum.
  *     and would call recusively untill the leaf is encountered or the sum is reached. After that will print the path
  *     if the sum matches. And would recursively call the same method with left and right subtree.
  *     [COMPLEXITY - O(N*LogN)] ( but N^2 in worst case beacuse of skewed )
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


  /* [Prob 4.12] Faster O(N)
 *   Q) paths with sum, given a binary tree in which nodes are conatins an integer value (which mught be positive or
 *   negative). Desingn an algorithm to count the number of paths that sum to a given value. The path does not need to
 *   start or end at the root or a leaf, but it must go downwards (travelling only from parent to child nodes).
 *   A) This approach uses a technique described in CTCI. It is expalined via an array concept, have implemented that
 *   also in  the array & strings class. The logic is to have an array that keeps the running Sum till this point say RSx
 *   for xth element. And we are also given the target sum lets say Ts. According to the formula RSx = RSy -Ts (how is
 *   this derived not sure/ out of scope for now), we get RSy = RSx -Ts, we will require this RSy for the nest step.
 *   Now we have to create a hashmap MAP_RS that will store all the runninsums as keys and the number of times they appeared
 *   in the running sum array. Now comes the actual possible ways part
    *   For each y: get the RSy
    *   Look up the RSy in the MAP_RS
    *   if found then add the value of RSy from MAP_RS to the totalWays
 *     [COMPLEXITY - O(N)]
 * */
  public static int PathsWithSumFaster(Tree tree, int targetSum) {
    pathsSumCount = 0;
    HashMap<Integer, Integer> mapRS = new HashMap<>();
    calulatePathsWithSumFaster(tree.root, 0, targetSum, mapRS);
    return pathsSumCount;
  }

  static int pathsSumCount;

  private static void calulatePathsWithSumFaster(TNode node, int runningSum,
                                                 int targetSum, HashMap<Integer, Integer> mapRS) {
    if (node == null) {
      return;
    }

    runningSum += node.data;
    if (mapRS.containsKey(runningSum)) {
      mapRS.put(runningSum, mapRS.get(runningSum));
    } else {
      mapRS.put(runningSum, 1);
    }
    int rsY = runningSum - targetSum;
    if (mapRS.containsKey(rsY)) {
      pathsSumCount += mapRS.get(rsY);
    }
    calulatePathsWithSumFaster(node.left, runningSum, targetSum, mapRS);
    calulatePathsWithSumFaster(node.right, runningSum, targetSum, mapRS);
  }

  /* [Prob]
  *   Q) print the inorder traversal with iterative method, not recursive.
  *   Constraint O(N) complexity, O(H) space, H - height of tree
  *   A)
  *   0: push root in stack
  *   1 : while Stack not empty
  *   1.1 Peek from stack to the top element
  *   1.2 if element has left child push left child on stack & continue to loop
  *   1.3 else if eleement doesnt have left child, pop from stack & print ,
  *   also check if from this pop stack is empty or not.
  *   1.4	If emty return
  *   1.5 while element.right ==null  keep poping from stack & print
  *   1.6 if eleement.right not equal to null push in stack
  *   time Complexity  - [O(N)]
  *   space Complexity  - [O(H)] h is the height of the tree
  * */
  public static void inorderTraversalIterative(Tree tree) {
    MyStack<TNode> stack = new MyStack<>();
    TNode trav = tree.root;
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
        if (stack.isEmpty()) {
          return; //  if stack has became empty its time to return
        }
        while (trav.right == null && !stack.isEmpty()) {  //  Traverse upwards till we have reached a node that has its right child, there we will make a turn
          trav = stack.pop();
          System.out.print(" " + trav.data);
        }

        if (trav.right != null) {
          stack.push(trav.right);
        }
      }
    }
  }

  /*  [Prob] : Print Minimum path sum from root to leaf in binary tree
  *   Q) find the min path sum from root to leaf & print, if two paths are minimum print the shorter one.
  * */
  public static void printMinPathSum(Tree tree) {
    if (tree == null) {
      return;
    }
    List<Integer> levels = new ArrayList<>();
    findMinPath(tree.root, 0, levels, 0);
    System.out.println("Sum : " + min + "  " + minPath);
  }

  static int minPathLength = Integer.MAX_VALUE;
  static List<Integer> minPath;

  private static void findMinPath(TNode node, int sum, List<Integer> levels, int level) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      if (sum + node.data <= min) {
        min = sum + node.data;
        levels.add(level, node.data);
        if (levels.size() < minPathLength) {
          minPath = new ArrayList<>(levels.subList(0, level + 1));
        }
        return;
      }
    }
    levels.add(level, node.data);
    findMinPath(node.left, sum + node.data, levels, level + 1);
    findMinPath(node.right, sum + node.data, levels, level + 1);
  }

  static int min = Integer.MAX_VALUE;

  public static int getMinPathSum(Tree tree) {
    if (tree == null) {
      return 0;
    }
    min = Integer.MAX_VALUE;
    minPathSum(tree.root, 0);
    System.out.println("Sum : " + min + "  " + minPath);
    return min;
  }

  private static void minPathSum(TNode node, int sum) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      if (sum + node.data <= min) {
        min = sum + node.data;
        return;
      }
    }
    minPathSum(node.left, sum + node.data);
    minPathSum(node.right, sum + node.data);
  }

  /* [Prob] print paths from root to leaf
  * */
  public static List<String> pathsOfTree(Tree tree) {
    if (tree == null) {
      return new ArrayList<>();
    }
    String path = "";
    List<String> paths = new ArrayList<>();
    traverseTree(tree.root, path, paths);
    return paths;
  }

  private static void traverseTree(TNode node, String path, List<String> paths) {
    if (node.left == null && node.right == null) {
      paths.add(path + node.data);
      return;
    }
    if (node.left != null)
      traverseTree(node.left, path + node.data + " -> ", paths);
    if (node.right != null)
      traverseTree(node.right, path + node.data + " -> ", paths);
  }

  /*  [Prob] find min depth
  * */
  public static int findMinimumDepth(Tree tree) {
    if (tree == null) {
      return 0;
    }
    return getMinHeight(tree.root);
  }

  private static int getMinHeight(TNode node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return 1;
    }
    int left = 0;
    if (node.left != null) {
      left = getMinHeight(node.left);
    }
    int right = 0;
    if (node.right != null) {
      right = getMinHeight(node.right);
    }
    return Math.min(left, right) + 1;
  }

  /* [Prob 199] Binary Tree Right Side View
  * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
  * ordered from top to bottom.
  * For example:
  * Given the following binary tree,
         1            <---
       /   \
      2     3         <---
       \     \
        5     4       <---
      You should return [1, 3, 4].
  * */
  public static List<Integer> rightSideView(Tree tree) {
    if (tree == null) {
      return null;
    }
    List<Integer> rightSide = new ArrayList<>();
    mostRight(tree.root, 0, rightSide);
    return rightSide;
  }

  private static void mostRight(TNode node, int level, List<Integer> rightSide) {
    if (node == null) {
      return;
    }
    if (rightSide.size() < level + 1) {
      rightSide.add(level, node.data);
    }
    mostRight(node.right, level + 1, rightSide);
    mostRight(node.left, level + 1, rightSide);
  }

  /* [Prob 508] Most Frequent Subtree Sum
 *  Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
  * as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
  * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest
  * frequency in any order.
  * Examples 1
  * Input:
     5
    /  \
   2   -3
   return [2, -3, 4], since all the values happen only once, return all of them in any order.
   Examples 2
   Input:

     5
    /  \
   2   -5
   return [2], since 2 happens twice, however -5 only occur once.
 * */
  public static int[] findFrequentTreeSum(TNode node) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    postOrderSum(node, map);
    List<Integer> res = new ArrayList<>();
    for (Integer key :
        map.keySet()) {
      if (map.get(key) > max) {
        max = map.get(key);
      }
    }

    for (Integer key :
        map.keySet()) {
      if (map.get(key) == max) {
        res.add(key);
      }
    }
    int[] finalRes = new int[res.size()];
    for (int i = 0; i < finalRes.length; i++) {
      finalRes[i] = res.get(i);
    }
    return finalRes;
  }

  private static int postOrderSum(TNode node, HashMap<Integer, Integer> map) {
    if (node == null) {
      return 0;
    }
    int sum = postOrderSum(node.left, map) + postOrderSum(node.right, map) + node.data;
    if (map.containsKey(sum)) {
      map.put(sum, map.get(sum) + 1);
    } else {
      map.put(sum, 1);
    }
    return sum;
  }

  /*  [Prob] subtreeSum if sum can be found by any subtree in the tree
  * */
  public static boolean subTreeSum(Tree tree, int sum) {
    TNode node = tree.root;
    getSum(node, sum);
    return foundSum;
  }

  static boolean foundSum = false;
  static TNode foundNode = null;

  private static int getSum(TNode node, int sum) {
    if (node == null) return 0;

    int left = getSum(node.left, sum);

    int right = getSum(node.right, sum);
    int sumHere = node.data + left + right;
    if (left + node.data == sum || right + node.data == sum || sumHere == sum) {
      foundSum = true;
      foundNode = node;
    }

    return node.data + left + right;
  }

  public static void doDijkstras() {
    int graph[][] = new int[][]{
        {0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

    Graph.dijkstra(graph, 0);
  }
}