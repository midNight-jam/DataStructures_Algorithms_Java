package darkRealm;

import java.util.Arrays;
import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {


//  255. Verify Preorder Sequence in Binary Search Tree
//  Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//
//  You may assume each number in the sequence is unique.
//  Consider the following binary search tree:
//
//        5
//       / \
//      2   6
//     / \
//    1   3
//  Example 1:
//
//  Input: [5,2,6,1,3]
//  Output: false
//  Example 2:
//
//  Input: [5,2,1,3,6]
//  Output: true

  public static boolean verifyPreorder(int[] preorder) {
    Stack<Integer> stack = new Stack<>();
    int low = Integer.MIN_VALUE, root;
    for (int i = 0; i < preorder.length; i++) {
      root = preorder[i];

      // if in right subtree we find a value smaller than root return false.
      if (root < low)
        return false;

      // pop out the left subtree if we are moving right, as the last value in the stack will be the root,
      // we dont have to maintain the largestMin (closest smalerr no) to determine the low.
      while (stack.size() > 0 && stack.peek() < root)
        low = stack.pop();

      stack.push(root);
    }
    return true;
  }

  public boolean verifyPreorderConstantSpace(int[] preorder) {
    // Idea is to use the input array itself as the stack.
    // Similar to pop, we traverse back in the array and the actual pop happens when we override the values in input arr
    int low = Integer.MIN_VALUE, root;
    int si = -1;
    for(int i = 0; i < preorder.length; i++){
      root = preorder[i];

      if(root < low)
        return false;

      while(si >= 0 && preorder[si] < root){
        low = preorder[si];
        si--;
      }

      preorder[++si] = root;
    }
    return true;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{5, 2, 1, 3, 6};
//    int[] arr = new int[]{5, 2, 6, 1, 3};
//    int[] arr = new int[]{5, 2, 6, 3};
//    int[] arr = new int[]{5, 2, 6, 1};
//    int[] arr = new int[]{5, 2, 6};
    int[] arr = new int[]{6, 5, 4, 5, 6, 7, 6};
//    int[] arr = new int[]{5, 6};
//    int[] arr = new int[]{5, 6,7,8,9};
//    int[] arr = new int[]{5, 6, 7, 8, 9, 0};
//    int[] arr = new int[]{5, 2};
//    int[] arr = new int[]{5};
//    int[] arr = new int[]{};
//    int[] arr = new int[]{1,1,1};

    boolean res = verifyPreorder(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(res);
  }
}
