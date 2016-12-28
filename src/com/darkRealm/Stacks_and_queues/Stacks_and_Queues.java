package com.darkRealm.Stacks_and_queues;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jayam on 12/7/2016.
 */
public class Stacks_and_Queues {
  private final static Logger dLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  static {
    dLogger.setLevel(Level.INFO);
    dLogger.info("logger initialized  for " + Stacks_and_Queues.class);
  }


  /*  [Prob 3.5]
  * Q) To sort a stack such that samllest items are on top.
  *     Constraint is we can use only another additional temporary stack not any array.
  * A) Use 2 stack, use push & oping between 2 stacks sch that the 2nd stack is sorted in reverse order,
  *   & at the end empty the sorted temp stack in to the original stack, this will fill it in the reverse order
  *   thus making smallest element appear on the top
  *
  * @param    a MyStack object that has to be sorted, of type Integer
  * @return   same MyStack object but now sorted in ascending order
  * */
  public static MyStack SortStack(MyStack stack) {
    MyStack<Integer> minStack = new MyStack();
    int minStackWindow = 0;
    int temp, minPeek;
    while (!stack.isEmpty()) {
      int element = (int) stack.pop();
      if (minStack.isEmpty()) {
        minStack.push(element);
        dLogger.info("First insertion in minStack " + element);
      } else {
        if (element >= minStack.peek()) {
          minStack.push(element);
          dLogger.info("pushing in minStack as element " + element + " >= " + minStack.peek() + " minPeek ");
        } else { // shall empty min stack in the original stack, insert the smaller element and then push all the elements.
          while (!minStack.isEmpty() && element < minStack.peek()) { // pull all elements out of stack that will be greater than the upcoming element
            minPeek = minStack.peek();
            temp = minStack.pop();
            stack.push(temp);
            minStackWindow++;
            dLogger.info("popoing from minStack was element " + element + " < " + minPeek + " minPeek ");
          }

          // now we are ready to push the poped out element in the minStack
          minStack.push(element);
          dLogger.info("pushing the popped element into minStack as all bigger pooped out " + element);

          // now lets pull out all the minStack Elements that we pushed on to the main Stack
          while (minStackWindow > 0) {
            temp = (int) stack.pop();
            minStack.push(temp);
            minStackWindow--;
          }
        }
      }
    }

    // as the main Stack isEmptied we can pull out the elements from the minStack and push on to the main Stack (reverse)
    dLogger.info("refilling from the minStack for reverse order");
    while (!minStack.isEmpty()) {
      temp = minStack.pop();
      stack.push(temp);
    }
    return stack;
  }




  /*  [Prob 3.3]
  *   Q) Implement a set of stacks, Create a new Stack when previous one had exceeded some threshold. Set of Stacks should
  *   be composed of several stacks and should create a new stack once the previous one exceeds capacity. Pop & Push
  *   should behave identically to a single stack. implement a function popAt(index), which performs a pop on a specific
  *   sub stack.
  *   A) Have created a new class SetStacks for this purpose, for popAt, have not implemented using roll over, instead
  *   have decide the tradeoff to be with stacks of unequal size
  * */

  public static void setOfStacks() {
    SetStacks setStacks = new SetStacks(3);
    setStacks.push(11);
    setStacks.push(12);
    setStacks.push(13);
    setStacks.push(21);
    int res = setStacks.popAt(1);
    System.out.print(res);

//    int temp = setStacks.pop();
//    temp = setStacks.pop();
//    temp = setStacks.pop();
//    temp = setStacks.pop();
  }

  /*  [Prob 3.1]
  * Q) Describe how you could use a single array to implement 3 Stacks
  * A) will have to keep track of capacity of each stack & shift them when required,
  * when shifting a stack reduce its capacity with 1.
  * TODO
  * @return  void
  * @param  void
  * */
  public static void threeStackInArray(){
    ThreeStacksArray threeStacks = new ThreeStacksArray(10);
    threeStacks.pushStack(1,11);
    threeStacks.pushStack(1,12);
    threeStacks.pushStack(1,13);
    threeStacks.pushStack(2,21);
    threeStacks.pushStack(1,14);
  }

}