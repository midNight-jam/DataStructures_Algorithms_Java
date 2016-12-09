package com.darkRealm.Stacks_and_queues;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * Created by Jayam on 12/8/2016.
 */
public class MyQueue<T> {

  private MyQueueNode head, tail;

  MyQueue() {
    head = tail = null;
  }

  public void enqueue(T item) {
    if (head == null) {
      head = new MyQueueNode(item);
      tail = head;
      return;
    }
    MyQueueNode temp = new MyQueueNode<T>(item);
    tail.next = temp;
    tail = temp;
  }


  private static class MyQueueNode<T> {
    private T data;
    private MyQueueNode next;

    public MyQueueNode(T item) {
      this.data = item;
    }
  }
}