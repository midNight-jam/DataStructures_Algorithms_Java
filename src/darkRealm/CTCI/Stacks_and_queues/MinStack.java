package darkRealm.CTCI.Stacks_and_queues;

import java.util.logging.Logger;

/**
 * Created by Jayam on 12/20/2016.
 */

/*
* [Prob 3.2]
* A dataStructure to maintain Min element in stack, while supporting all Push()/Pop()/Min() operation in O(1)*/
public class MinStack {
  private final static Logger dLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  private MyStack<Integer> stack;
  private MyStack<Integer> minStack;
  private int min = Integer.MAX_VALUE;

  public MinStack() {
    stack = new MyStack<>();
  }

  public void push(int i) {
    if (i <= min) { // push the old value of min when a new min has arrived
      stack.push(min);
      min = i;
    }
    stack.push(i);
  }

  public int pop() {
    int popped = stack.pop();
    if (popped == min) {  // if pop operation could result in the changing of the current minimum value,
      if (stack.getSize() > 0) { // pop twice and change the current minimum value to the last minimum value.
        min = stack.pop();
      }
    }
    return popped;
  }

  public int getMin() {
    return min;
  }
}