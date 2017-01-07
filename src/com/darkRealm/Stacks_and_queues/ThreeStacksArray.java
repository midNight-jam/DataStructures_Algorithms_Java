package com.darkRealm.Stacks_and_queues;


import java.util.Arrays;

/**
 * Created by Jayam on 12/27/2016.
 *
 */
public class ThreeStacksArray {
  private int noOFStacks = 3;
  private int stackCapacity;
  private int[] values;
  private int[] sizes;


  ThreeStacksArray(int capacity) {
    stackCapacity = capacity;
    values = new int[stackCapacity * noOFStacks];
    sizes = new int[noOFStacks];
  }

  public boolean isEmpty(int stackNo) {
    return sizes[stackNo-1] == 0 ? true : false;
  }

  public boolean isFull(int stackNum) {
    return sizes[stackNum-1] == stackCapacity ? true : false;
  }

  public int getTopIndex(int stackNo) {
    int offSet = (stackNo - 1) * stackCapacity;
    int size = sizes[stackNo - 1];
    return offSet + size;
  }

  public void push(int stackNo, int element) {
    if (!isFull(stackNo)) {
      insertInStack(stackNo, element);
    } else {
      System.out.println("Stack " + stackNo + " is full ");
    }
  }

  private void insertInStack(int stackNo, int element) {
    int top = getTopIndex(stackNo);
    values[top] = element;
    sizes[stackNo-1]++;
  }

  public int pop(int stackNo) {
    if (!isEmpty(stackNo)) {
      return popElementFromStack(stackNo);
    }
    return Integer.MIN_VALUE;
  }

  private int popElementFromStack(int stackNo) {
    int top = getTopIndex(stackNo);
    int res = values[top-1];
    sizes[stackNo-1]--;
    return res;
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}