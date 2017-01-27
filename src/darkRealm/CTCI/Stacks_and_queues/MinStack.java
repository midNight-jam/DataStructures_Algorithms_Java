package darkRealm.CTCI.Stacks_and_queues;
import java.util.logging.Level;
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

  public MinStack() {
    stack = new MyStack<>();
    minStack = new MyStack<>();
    dLogger.setLevel(Level.INFO);
    dLogger.info("logger initialized  for " + this.getClass().getName());
  }

  public void push(int i) {
    stack.push(i);
    if (minStack.isEmpty()) {
      minStack.push(i);
      dLogger.info("1st element in min Stack " + i);
    } else {
      int currentMin = minStack.peek();
      if (i <= currentMin) {
        minStack.push(i);
        dLogger.info("new element " + i + " <= peek of min Stack " + peekCurrentMin());
      }
    }
  }

  public int pop() {
    int popped = stack.pop();
    if (popped == minStack.peek()) {
      dLogger.info("popped element " + popped + " <= to peek of min Stack " + peekCurrentMin());
      minStack.pop();
    }
    return popped;
  }

  public int peekCurrentMin() {
    int currentMin = minStack.peek();
    return currentMin;
  }
}