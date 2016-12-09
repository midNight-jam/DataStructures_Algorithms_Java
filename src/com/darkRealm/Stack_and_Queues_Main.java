package com.darkRealm;

import com.darkRealm.Stacks_and_queues.MyStack;

/**
 * Created by Jayam on 12/9/2016.
 */
public class Stack_and_Queues_Main {

  public static void testMyStack() {

    MyStack<Integer> myStack = new MyStack();
    myStack.push(11);
    myStack.peek();
    myStack.push(22);
    myStack.peek();
    myStack.push(33);
    myStack.peek();
    myStack.push(44);
    myStack.peek();
    myStack.push(55);
    myStack.peek();

    try {
      //popall
      while (true) {
        Integer i = myStack.pop();
        System.out.println(" i " + i + " peek " + myStack.peek());
      }
    } catch (Exception e) {
      System.out.println(" finished "+e);
    }
  }
}
