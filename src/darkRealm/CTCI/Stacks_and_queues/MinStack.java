package darkRealm.CTCI.Stacks_and_queues;

import java.util.Stack;

/**
 * Created by Jayam on 12/20/2016.
 */

/*
* [Prob 3.2]
* A dataStructure to maintain Min element in stack, while supporting all Push()/Pop()/Min() operation in O(1)*/
public class MinStack {
  private Stack<Integer> stack;
  private int min = Integer.MAX_VALUE;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int i) {
    if (i < min) {
      stack.push(min);
      min = i;
    }
    stack.push(i);
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    if (stack.peek() == min) {
      int pop = stack.pop();
      min = stack.pop();
      return pop;
    }
    return stack.pop();
  }

  public int getMin() {
    return min;
  }
}