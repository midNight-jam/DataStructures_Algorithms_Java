package com.darkRealm.Stacks_and_queues;


/**
 * Created by Jayam on 12/27/2016.
 * INCOMPLETE
 */
public class ThreeStacksArray {
  private int[] array;
  private int totalSize;
  private int[] stackLens;
  private int[] stackBottoms;
  private int[] stackSizes;

  ThreeStacksArray(int size) {
    totalSize = size;
//    array = (T[]) new Object[totalSize];
    array = new int[totalSize];
    stackLens = new int[3];
    stackBottoms = new int[3];
    stackLens[0] = totalSize / 3;
    stackLens[1] = totalSize / 3;
    stackLens[2] = totalSize - (2 * stackLens[0]);
    stackBottoms[0] = 0;
    stackBottoms[1] = stackBottoms[0] + stackLens[0];
    stackBottoms[2] = stackBottoms[1] + stackLens[1];
    stackSizes = new int[3];
  }

  public void pushStack(int stackNo, int elem) {
    if (!isFull()) {
      stackNo = stackNo - 1;
      int nextStack = getNextStack(stackNo);
//      int currnetStackTop = stackSizes[stackNo];
      int currnetStackTop = getStackTop(stackNo);
      int nextStackBottom = stackBottoms[nextStack];
//      int next = currnetStackTop + 1; // default
      // if current stack itself has capacity
      if(isEmpty(stackNo)) {
        array[stackBottoms[stackNo]] = elem;
        ++stackSizes[stackNo];
        return;
      }
      if (currnetStackTop < nextStackBottom) {
//        int next = nextIndex(currnetStackTop);
        int next = currnetStackTop;
        ++stackSizes[stackNo];
        array[next] = elem;
        return;
      }

      //if next stack has space shift it
      int nextToNextStack = getNextStack(nextStack);
//      int nextStackTop = (stackBottoms[nextStack] + stackSizes[nextStack])%totalSize;
      int nextStackTop = getStackTop(nextStack);
      int nextToNextStackBottom = stackBottoms[nextToNextStack];
      if (nextStackTop < nextToNextStackBottom) {
        shiftStack(nextStack);
        int next = nextIndex(stackSizes[stackNo]);
        ++stackSizes[stackNo];
        array[currnetStackTop] = elem;
        return;
      }
      // else shift stack 3 & stack 2
      else {
        shiftStack(2);
        shiftStack(1);
      }
    }
  }


  private int getStackTop(int stackNo) {
    return (stackBottoms[stackNo] + stackSizes[stackNo]) % totalSize;
  }

  private int nextIndex(int i) {
    return (i + 1) % totalSize;
  }

  private boolean isEmpty(int stackNo) {
    return stackBottoms[stackNo] == getStackTop(stackNo);
  }

  private void shiftStack(int stackNo) {
    int stackTop = (stackBottoms[stackNo] + stackSizes[stackNo])%totalSize;;
    int stackBottom = stackBottoms[stackNo];
    while (stackTop >= stackBottom) {
      int nextIndex = (stackTop + 1) % totalSize;
      array[nextIndex] = array[stackTop];
      stackTop--;
    }
    stackBottoms[stackNo] = nextIndex(stackBottom);
  }

  public boolean isFull() {
    int sum = stackSizes[0] + stackSizes[1] + stackSizes[2];
    return sum == totalSize ? true : false;
  }

  private int getNextStack(int stackNo) {
    int nextStack = -1;
    switch (stackNo) {
      case 2:
        nextStack = 0;
        break;
      case 1:
        nextStack = 2;
        break;
      case 0:
        nextStack = 1;
        break;
    }
    return nextStack;
  }
}