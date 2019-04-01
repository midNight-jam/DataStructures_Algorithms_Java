package darkRealm;

public class MyCalendarI {
  private class TreeNode {
    int start;
    int end;
    TreeNode left;
    TreeNode right;

    TreeNode(int s, int e) {
      start = s;
      end = e;
    }
  }

  TreeNode root;

  public MyCalendarI() {
    root = null;
  }

  public boolean book(int s, int e) {
    if (s > e) return false;
    if (root == null) {
      root = new TreeNode(s, e);
      return true;
    }
    return insert(root, s, e, null);
  }

  private boolean insert(TreeNode root, int s, int e, TreeNode par) {
    if (root == null) {
      if (e <= par.start)
        par.left = new TreeNode(s, e);
      else
        par.right = new TreeNode(s, e);
      return true;
    }

    if (e <= root.start)
      return insert(root.left, s, e, root);
    else if (s >= root.end)
      return insert(root.right, s, e, root);


    return false;
  }

  public static void main(String[] args) {
    MyCalendarI mc = new MyCalendarI();
    boolean res;
    res = mc.book(10, 20);
    System.out.println(res);
    res = mc.book(15, 25);
    System.out.println(res);
    res = mc.book(20, 30);
    System.out.println(res);
  }
}
