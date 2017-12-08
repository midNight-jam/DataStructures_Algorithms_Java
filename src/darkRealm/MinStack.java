package darkRealm;

import java.util.Stack;

public class MinStack {
  /*
  #155. Min Stack
  DescriptionHintsSubmissionsDiscussSolution
  Discuss Pick One
  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  push(x) -- Push element x onto stack.
  pop() -- Removes the element on top of the stack.
  top() -- Get the top element.
  getMin() -- Retrieve the minimum element in the stack.
  Example:
  MinStack minStack = new MinStack();
  minStack.push(-2);
  minStack.push(0);
  minStack.push(-3);
  minStack.getMin();   --> Returns -3.
  minStack.pop();
  minStack.top();      --> Returns 0.
  minStack.getMin();   --> Returns -2.
  */


  Stack<Integer> stack;
  Stack<Integer> minStack;
  int curMin = Integer.MAX_VALUE;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    if (minStack.isEmpty() || minStack.peek() > x)
      curMin = x;
    minStack.push(curMin);
    stack.push(x);
  }

  public void pop() {
    stack.pop();
    minStack.pop();
    curMin = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) {
    int res;
    MinStack minStack = new MinStack();
    minStack.push(-10);
    minStack.push(14);
    res = minStack.getMin();
    res = minStack.getMin();
    minStack.push(-20);
    res = minStack.getMin();
    res = minStack.getMin();
    res = minStack.top();
    res = minStack.getMin();
    minStack.pop();
    minStack.push(10);
    minStack.push(-7);
    res = minStack.getMin();
    minStack.push(-7);
    minStack.pop();
    res = minStack.top();
    res = minStack.getMin();
    minStack.pop();
  }
}