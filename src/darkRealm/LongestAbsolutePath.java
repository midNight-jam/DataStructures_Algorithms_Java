package darkRealm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LongestAbsolutePath {

//  #388. Longest Absolute File Path
//  Suppose we abstract our file system by a string in the following manner:
//  The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
//  dir
//      subdir1
//      subdir2
//      file.ext
//  The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
//  The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
//  dir
//      subdir1
//        file1.ext
//        subsubdir1
//      subdir2
//        subsubdir2
//          file2.ext
//  The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty
//  second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
//  We are interested in finding the longest (number of characters) absolute path to a file within our file system.
//  For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its
//  length is 32 (not including the double quotes).
//  Given a string representing the file system in the above format, return the length of the longest absolute path to
//  file in the abstracted file system. If there is no file in the system, return 0.
//  Note:
//  The name of a file contains at least a . and an extension.
//  The name of a directory or sub-directory will not contain a ..
//  Time complexity required: O(n) where n is the size of the input string.
//  Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

  public static int lengthLongestPath(String input) {
    int maxLen = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);  //dummy len
    String[] paths = input.split("\n");
    int level = 0;
    int interimPathLen = 0;
    int fullPath = 0;
    // either we had to use two stack to keep the level and also the length,
    // but if we observe closely stack .size will serve us the level at which we are at
    // thus we only need to put string len in stack and use stack .size for level
    for (String s : paths) {
      level = s.lastIndexOf("\t") + 1;
      interimPathLen = s.length() - level + 1;  /* for removing \t and adding '/' for dir sign in path  at the end*/
      while (stack.size() > level + 1) stack.pop();
      fullPath = stack.peek() + interimPathLen;
      stack.push(fullPath);
      if (s.contains("."))
        maxLen = Math.max(maxLen, fullPath - 1); // because for filename we have to remove the extra '/'
    }
    return maxLen;
  }

  public static int lengthLongestPathBasic(String input) {
    if (input == null || input.length() < 1) return 0;
    String[] arr = input.split("\n");
    int res = Integer.MIN_VALUE;
    Stack<Integer> levelStack = new Stack<>();
    Stack<String> strStack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      String si = arr[i];
      boolean isFile = si.indexOf(".") > -1;
      int index = si.lastIndexOf("\t");
      index++; // if -ve, i.e just root dir, we will take it as level 0
      System.out.println(index);
      int level = index;
      while (levelStack.size() > 0 && levelStack.peek() >= level) {
        levelStack.pop();
        strStack.pop();
      }

      String ns = (strStack.size() > 0 ? strStack.peek() : "") + si.substring(index) + "/";
      // System.out.println(ns);
      if (isFile)
        res = Math.max(res, ns.length());
      strStack.push(ns);
      levelStack.push(level);
    }

    return res == Integer.MIN_VALUE ? 0 : res - 1;
  }

  public static void main(String[] args) {
    String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
//    String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//    String input = "a/aa/aaa/file1.txt";
//    String input = "aaaaaaaaaaaaaaaaaaaaa/sth.png";
    int res = lengthLongestPath(input);
    System.out.println("I : " + input + "\nR : " + res);
  }
}