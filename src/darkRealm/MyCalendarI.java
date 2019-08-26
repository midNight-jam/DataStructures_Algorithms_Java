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
  boolean valid;
  
  public MyCalendarI() {
    valid = true;
  }

 public boolean book(int start, int end) {
    valid = true;
    root = insert(root, start, end);
    return valid;
  }
  
  private TreeNode insert(TreeNode root, int start, int end){
    if(root == null)
      return new TreeNode(start, end);
    
    if(end <= root.start)
      root.left = insert(root.left, start, end);
    
    else if(root.end <= start)
      root.right = insert(root.right, start, end);
    
    else
      valid = false;
    
    return root;
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
