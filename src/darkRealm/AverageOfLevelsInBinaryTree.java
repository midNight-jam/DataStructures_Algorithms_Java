package darkRealm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

//  Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//
//      Example 1:
//  Input:
//      3
//      / \
//      9  20
//      /  \
//      15   7
//  Output: [3, 14.5, 11]
//  Explanation:
//  The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> que = new LinkedList();
    int toProcess, N;
    que.offer(root);
    double sum;
    while(!que.isEmpty()){
      N = toProcess = que.size();
      sum = 0.0;
      while(toProcess-- > 0){
        TreeNode trav = que.poll();
        sum += trav.val;
        if(trav.left != null)
          que.offer(trav.left);
        if(trav.right != null)
          que.offer(trav.right);
      }

      res.add(sum / N);
    }

    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    List<Double> res = averageOfLevels(root);
    System.out.println("Res : " + res.toString());
  }
}