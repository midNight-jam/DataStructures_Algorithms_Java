package darkRealm.CTCI.Trees_and_Graphs;

/**
 * Created by Jayam on 1/22/2017.
 */
public class RankTree {
  public RTNode root;

  public void insert(int data) {
    if (root == null) {
      root = new RTNode(data);
      return;
    }
    insert(root, data);
  }

  private void insert(RTNode node, int data) {
    if (node.left == null && data <= node.data) {
      node.leftChilds++;
      node.left = new RTNode(data);
      return;
    }
    if (node.right == null && data > node.data) {
      node.rightChilds++;
      node.right = new RTNode(data);
      return;
    }
    if (data <= node.data) {
      node.leftChilds++;
      insert(node.left, data);
    } else {
      node.rightChilds++;
      insert(node.right, data);
    }
  }

  // asumming K is present in tree
  public int getRank(int k) {
    RTNode node = root;
    int rank = 0;
    while (node.data != k || node != null) {
      if (k > node.data) {
        rank += node.leftChilds + 1;
        node = node.right;
      } else if (k < node.data) {
        node = node.left;
      } else if (k == node.data) {
        rank+=node.leftChilds;
        break;
      }
    }
    return node == null ? -1 : rank;
  }
}