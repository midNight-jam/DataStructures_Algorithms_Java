package ADT;

import java.util.EmptyStackException;

/**
 * Created by Jayam on 12/7/2016.
 */
public class MyStack<T> {

  private StackNode<T> top;
  private int size;

  public void push(T item) {
    StackNode<T> temp = new StackNode<T>(item);
    temp.next = top;
    top = temp;
    size++;
  }

  public T pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    T item = top.data;
    top = top.next;
    size--;
    return item;
  }

  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public int getSize() {
    return size;
  }

  public T popAt(int i) {
    T res = null;
    if (i >= 0 && i <= getSize()) {
      int size = getSize();
      int elementsToPop = size - i -1;
      MyStack<T> tempStack = new MyStack<T>();
      T temp;
      while (elementsToPop != 0) {
        temp = pop();
        tempStack.push(temp);
        elementsToPop--;
      }
      res = pop();
      while (!tempStack.isEmpty()) {
        temp = tempStack.pop();
        push(temp);
      }
    }
    return res;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    StackNode<T> trav = top;
    stringBuilder.append("top"+ "\n"+"___\n");
    while (trav != null) {
      stringBuilder.append("|"+trav.data + "|\n");
      trav = trav.next;
    }
    stringBuilder.append("===");
    return stringBuilder.toString();
  }

  private static class StackNode<T> {

    private T data;

    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }
}