package darkRealm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    Queue<Node> que = new LinkedList<>();
    que.offer(root);
    level(res, que);
    return res;
  }

  private void level(List<List<Integer>> res, Queue<Node> que){
    if(que.size() < 1) return;
    int process = que.size();
    List<Integer> level = new ArrayList<>();
    while(process-- > 0){
      Node p = que.poll();
      level.add(p.val);
      for(int i = 0; i < p.children.size(); i++)
        que.offer(p.children.get(i));
    }
    res.add(level);
    level(res, que);
  }

  public static void main(String[] args) {

  }
}
