package darkRealm;

import java.util.Stack;

public class SimplifyPath {

//  #71. Simplify Path
//  Given an absolute path for a file (Unix-style), simplify it.
//  For example,
//      path = "/home/", => "/home"
//  path = "/a/./b/../../c/", => "/c"
//  click to show corner cases.
//  Corner Cases:
//  Did you consider the case where path = "/../"?
//      In this case, you should return "/".
//  Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//  In this case, you should ignore redundant slashes and return "/home/foo".

  public static String simplifyPath(String path) {
    if (path == null || path.length() == 0) return path;
    Stack<String> stack = new Stack<>();
    stack.push("/");
    String[] paths = path.split("/");
    String prev;
    for (int i = 0; i < paths.length; i++)
      if (paths[i].length() == 0 || paths[i].equals(".")) continue;
      else if (paths[i].equals("..") && stack.size() > 1)
        stack.pop();
      else if (!paths[i].equals("..")) {
        prev = stack.peek();
        prev += paths[i] + "/";
        stack.push(prev);
      }

    String res = stack.peek();
    return res.length() > 1 ? res.substring(0, res.length() - 1) : res;
  }

  public static void main(String[] args) {
//    String path = "/.";
//    String path = "/...";
//    String path = "/..";
//    String path = "/..hidden";
//    String path = "/../";
//    String path = "../../../";
//    String path = "//../...//../././././././/...../home//foo";
    String path = "/a/./b/../../c/";
    String res = simplifyPath(path);
    System.out.println("P : " + path);
    System.out.println("R : " + res);
  }
}
