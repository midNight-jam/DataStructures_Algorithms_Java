package com.darkRealm;

import com.darkRealm.Stacks_and_queues.MinStack;
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
      System.out.println(" finished " + e);
    }
  }

  public static void testMinStack() {
    MinStack minStack = new MinStack();
    minStack.push(9);
    minStack.push(5);
    System.out.println("Current min " + minStack.peekCurrentMin());
    minStack.push(3);
    System.out.println("Current min " + minStack.peekCurrentMin());
    minStack.push(7);
    minStack.push(2);
    minStack.push(6);
    System.out.println("Current min " + minStack.peekCurrentMin());
    minStack.push(1);
    System.out.println("Current min " + minStack.peekCurrentMin());
    minStack.push(4);
    minStack.push(0);
    System.out.println("Current min " + minStack.peekCurrentMin());
    minStack.push(11);
    System.out.println("Current min " + minStack.peekCurrentMin());

    minStack.pop();
    System.out.println("Current min " + minStack.peekCurrentMin());

    minStack.pop();
    System.out.println("Current min " + minStack.peekCurrentMin());

    minStack.pop();
    System.out.println("Current min " + minStack.peekCurrentMin());

    minStack.pop();
    System.out.println("Current min " + minStack.peekCurrentMin());

    minStack.pop();
    System.out.println("Current min " + minStack.peekCurrentMin());

    minStack.pop();
    System.out.println("Current min " + minStack.peekCurrentMin());

  }
}