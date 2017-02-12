package darkRealm.CTCI;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.Trees_and_Graphs.KevinBaconsGame;
import darkRealm.CTCI.Trees_and_Graphs.TNode;
import darkRealm.CTCI.Trees_and_Graphs.Tree;
import darkRealm.CTCI.Trees_and_Graphs.Trees_and_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jayam on 12/27/2016.
 */
public class Trees_and_Graphs_Main {

  public static void testBFSAndDFS() {
    Trees_and_Graphs.doBFSAndDFS();
  }

  public static void testIsRoutePresentBetweenNodes() {
    Trees_and_Graphs.isRoutePresentBetweenNodes();
  }

  public static void testMinimalHeightTree() {
//    int[] arr = new int[]{2, 5, 7, 10, 19, 20, 25};
    int[] arr = new int[]{2, 3, 4};
//    int[] arr = new int[]{};
    Trees_and_Graphs.createMinimalHeightTree(arr);
  }

  public static void testListOfDepths() {
//    Trees_and_Graphs.listOfDepths();
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.right = new TNode(30);
    tree.root.right.left = new TNode(25);
    tree.root.right.left.left = new TNode(22);
    tree.root.right.left.left.left = new TNode(21);
    tree.root.right.left.right = new TNode(27);
    tree.root.right.right = new TNode(35);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.left = new TNode(5);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);
    List<List<Integer>> res = Trees_and_Graphs.listOfDepths(tree);
    System.out.print(res);
  }

  public static void testMinPathSum() {
//    Tree tree = new Tree();
//    tree.root = new TNode(17);
//    tree.root.left = new TNode(30);
//    tree.root.right = new TNode(25);
//    tree.root.right.left = new TNode(23);
//    tree.root.right.right= new TNode(27);
//    tree.root.right.left.left = new TNode(20);
//    tree.root.right.right.left = new TNode(10);
//    tree.root.left.right = new TNode(3);
//    tree.root.left.left = new TNode(7);
//    tree.root.left.right.left = new TNode(5);
//    tree.root.left.right.left.right = new TNode(25);
//    tree.root.left.left.left = new TNode(1);
//
    Tree tree = new Tree();
    tree.root = new TNode(1);
    tree.root.left = new TNode(1);
    tree.root.left.left = new TNode(1);
    tree.root.left.left.left = new TNode(1);
//    tree.root.left = new TNode(3);
    tree.root.right = new TNode(2);
    tree.root.right.left = new TNode(2);

    Trees_and_Graphs.printMinPathSum(tree);
  }

  public static void testIsBalanced() {
//    Tree tree = Trees_and_Graphs.getSampleTree();

//    Tree tree = new Tree();
//    tree.root = new TNode(17);
//    tree.root.left = new TNode(30);
//    tree.root.right = new TNode(25);
//    tree.root.right.left = new TNode(23);
//    tree.root.right.right= new TNode(27);
//    tree.root.right.left.left = new TNode(20);
//    tree.root.right.right.left = new TNode(10);
//    tree.root.left.right = new TNode(3);
//    tree.root.left.left = new TNode(7);
//    tree.root.left.right.left = new TNode(5);
//    tree.root.left.right.left.right = new TNode(25);
//    tree.root.left.left.left = new TNode(1);

    Tree tree = new Tree();
    tree.root = new TNode(17);
    tree.root.left = new TNode(30);
    tree.root.left.left = new TNode(12);
//    tree.root.right = new TNode(25);
//    tree.root.right.right = new TNode(35);

//    Trees_and_Graphs.isBalanced(tree);
    boolean res = Trees_and_Graphs.checkBalanced(tree);
    System.out.println("IsBalanced : " + res);
  }

  public static void testIsBST() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.right = new TNode(30);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.left = new TNode(5);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);
    Trees_and_Graphs.isBST(tree);
  }

  public static void testPredecessorAndSuccessor() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.left.parent = tree.root;
    tree.root.right = new TNode(30);
    tree.root.right.parent = tree.root;
    tree.root.left.left = new TNode(5);
    tree.root.left.left.parent = tree.root.left;
    tree.root.left.right = new TNode(15);
    tree.root.left.right.parent = tree.root.left;

    tree.root.left.right.right = new TNode(17);
    tree.root.left.right.right.parent = tree.root.left.right;
//    tree.root.left.left.left = new TNode(3);
//    tree.root.left.left.right = new TNode(7);
    Trees_and_Graphs.printPredecessorAndSucessor(tree, 17);
  }

  public static void testCommonAncestor() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.right = new TNode(30);
    tree.root.right.left = new TNode(25);
    tree.root.right.right = new TNode(40);
    tree.root.left.left = new TNode(5);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);
//    Trees_and_Graphs.findCommonAncestor(tree, 3, 17);
//    TNode res = Trees_and_Graphs.findCommonAncestor(tree.root, 3, 40);
//    TNode res = Trees_and_Graphs.findCommonAncestor(tree.root, 10, 17);
//    TNode res = Trees_and_Graphs.findCommonAncestor(tree.root, 10, 18);
    TNode res = Trees_and_Graphs.findCommonAncestor(tree.root, 19, 18);
    System.out.println("RES : " + res.data);
  }

  public static void testCheckSubtree() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(15);
    tree.root.right = new TNode(30);
    tree.root.right.left = new TNode(25);
    tree.root.right.right = new TNode(40);
    tree.root.left.left = new TNode(5);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.left = new TNode(13);
    tree.root.left.right.left.right = new TNode(14);
    tree.root.left.right.left.left = new TNode(11);
    tree.root.left.right.left.left.left = new TNode(9);
    tree.root.left.right.left.left.right = new TNode(12);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.right.right.left = new TNode(16);
    tree.root.left.right.right.right = new TNode(19);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);

    Tree t2 = new Tree();
    t2.root = new TNode(15);
    t2.root.left = new TNode(13);
    t2.root.right = new TNode(17);
    t2.root.left.left = new TNode(11);

    Tree t3 = new Tree();
//    t3.root = new TNode(7);

    Trees_and_Graphs.checkSubtree(tree, t2);
  }


  public static void testInsertNode() {
    Tree tree = new Tree(20);
    tree.insert(30);
    tree.insert(10);
    tree.insert(25);
    tree.insert(15);
    tree.insert(5);
    tree.insert(3);
    tree.insert(7);
    tree.insert(25);
    tree.insert(40);
    tree.insert(13);
    tree.insert(17);
    TNode node = tree.getRandomNode();
    System.out.println("res - " + node.data);
  }

  public static void testBuildOrder() {
    String projs = "a,b,c,d,e,f";
    String dependencies = "(a,d), (f,b), (b,d), (f,a), (d,c), (e,f)";
    String res = Trees_and_Graphs.buildOrder(projs, dependencies);
//    String res = Trees_and_Graphs.buildOrderNew(projs,dependencies);
    System.out.println("build order res - " + res);
  }

  public static void testNumberOfBSTSequences() {
//    int [] arr = new int[]{}; //0
//    int [] arr = new int[]{1}; //1
//    int [] arr = new int[]{1,2}; //2
//    int [] arr = new int[]{1,2,3}; //5
//    int [] arr = new int[]{1,2,3,4}; // 14
//    int [] arr = new int[]{1,2,3,4,5}; //42
//    int [] arr = new int[]{1,2,3,4,5,6}; // 132
//    int [] arr = new int[]{1,2,3,4,5,6,7}; // 429
//    int [] arr = new int[]{1,2,3,4,5,6,7,8}; // 1430
//    int [] arr = new int[]{1,2,3,4,5,6,7,8,9}; // 4862
    int[] arr = new int[]{1, 2, 3, 4, 6, 5, 7, 8, 9}; // should fail not sorted
    int res = Trees_and_Graphs.NumberOfBSTSequences(arr);
    System.out.println("the ways of BST seq - " + res);
  }

  public static void testPossibleBSTArrays() {
    Tree tree = new Tree();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
//    tree.insert(5);
//    tree.insert(6);
//    tree.insert(7);
    ArrayList<LinkedList> res = Trees_and_Graphs.possibleBSTArrays(tree.root);
    for (LinkedList r : res
        ) {
      System.out.println(r);
    }
  }

  public static void testPathsWithSum() {
    Tree tree = new Tree();
    tree.insert(0);
    tree.insert(1);
    tree.root.right.left = new TNode(-1);
    tree.root.right.right = new TNode(-2);
    tree.root.right.right.left = new TNode(1);
//    int res = Trees_and_Graphs.PathsWithSum(tree,0);
    int res = Trees_and_Graphs.PathsWithSumFaster(tree, 0);
    System.out.println("res - " + res);
//
  }

  public static void testInorderTraversalIterative() {
    Tree tree = new Tree();
//    tree.insert(2);
//    tree.insert(1);
//    tree.insert(1);
//    tree.insert(4);

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(6);
    tree.insert(13);
    tree.insert(25);
    tree.insert(1);
    tree.insert(4);
    tree.insert(8);
    tree.insert(14);
    tree.insert(18);

    Trees_and_Graphs.inorderTraversalIterative(tree);
  }

  public static void testAdjacencyGraph() {
    KevinBaconsGame adjMap = new KevinBaconsGame();
    adjMap.addActor("Kevin Bacon");
    adjMap.addActor("Kevin Costner");
    adjMap.addEdge("Kevin Bacon", "Kevin Costner", "JFK", 1991);

    adjMap.addActor("Keanu Reeves");
    adjMap.addActor("Al Pacino");
    adjMap.addEdge("Keanu Reeves", "Al Pacino", "The Devil's Advocate", 1997);
    //Christopher Walken
    adjMap.addActor("Christopher Walken");
    adjMap.addEdge("Christopher Walken", "Al Pacino", "Gigli", 2003);

    //Courtney Love
    adjMap.addActor("Courtney Love");
    adjMap.addEdge("Christopher Walken", "Courtney Love", "Basquiat", 1996);

    adjMap.addActor("Courtney Love");
    adjMap.addEdge("Kevin Bacon", "Courtney Love", "Trapped", 2002);

    adjMap.addActor("Clint Howard");
    adjMap.addEdge("Clint Howard", "Keanu Reeves", "Parenthood", 1989);
    adjMap.addEdge("Clint Howard", "Kevin Bacon", "My Dog Skip", 2000);

    HashMap<Integer, ArrayList<String>> res = adjMap.discoverKevinBaconUniverse("Keanu Reeves");

    System.out.println(" BNo | Actors ");
    for (Integer key :
        res.keySet()) {
//      System.out.println(" " + key + " actors : " + res.get(key).size());
      System.out.print(" " + key);
      ArrayList<String> actors = res.get(key);
      System.out.print("     (" + actors.size() + ") ");
      for (int i = 0; i < actors.size(); i++) {
        System.out.print("  " + actors.get(i));
      }
      System.out.println("");
    }

    int actorBaconNo = adjMap.getBaconNumber("Keanu Reeves");
    System.out.println("Christopher Walken has bacon No " + actorBaconNo + " Kevin Bacon");

  }

  public static void testRightSideView() {
    Tree tree = new Tree();
    tree.root = new TNode(1);
    tree.root.left = new TNode(2);
    tree.root.left.left = new TNode(1);
    tree.root.left.left.left = new TNode(1);
    tree.root.right = new TNode(3);
    tree.root.right.left = new TNode(4);
    List<Integer> right = Trees_and_Graphs.rightSideView(null);
    System.out.println(" Right : " + right);
  }

  public static void testPathsOfTree() {
    Tree tree = new Tree();
    tree.root = new TNode(1);
    tree.root.left = new TNode(2);
    tree.root.left.left = new TNode(1);
    tree.root.left.left.left = new TNode(1);
    tree.root.right = new TNode(3);
    tree.root.right.left = new TNode(4);
    List<String> paths = Trees_and_Graphs.pathsOfTree(tree);
    System.out.println(" Paths : " + paths);
  }

  public static void testMinHeight() {
    Tree tree = new Tree();
    tree.root = new TNode(1);
    tree.root.left = new TNode(2);
    tree.root.left.left = new TNode(1);
    tree.root.left.left.left = new TNode(1);
    tree.root.right = new TNode(3);
    tree.root.right.left = new TNode(4);
    int min = Trees_and_Graphs.findMinimumDepth(tree);
    System.out.println(min);
  }
}