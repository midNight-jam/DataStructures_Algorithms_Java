package com.darkRealm.Stacks_and_queues;

import java.util.EmptyStackException;

/**
 * Created by Jayam on 12/7/2016.
 */
public class MyStack<T> {

  private StackNode<T> top;

  public void push(T item) {
    StackNode<T> temp = new StackNode<T>(item);
    temp.next = top;
    top = temp;
  }

  public T pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    T item = top.data;
    top = top.next;
    return item;
  }

  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  private static class StackNode<T> {

    private T data;

    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }
}