package darkRealm.CTCI.Stacks_and_queues;

import ADT.MyStack;

import java.util.ArrayList;

/**
 * Created by Jayam on 12/26/2016.
 */
public class SetStacks {
  private ArrayList<MyStack<Integer>> allStacks;
  private int threshold;
  private int currentStackCount;

  public SetStacks(int threshold) {
    // take a stask of stacks, will initialize it with one stack
    allStacks = new ArrayList<>();
    allStacks.add(new MyStack<>());
    this.threshold = threshold;
    currentStackCount = 0;
  }

  public void push(int element) {
    MyStack<Integer> currentTopStack = allStacks.get(currentStackCount);
    if (currentTopStack.getSize() == threshold) {// current stack has also reached the threshold so lets push another stack
      allStacks.add(new MyStack<>());
      currentStackCount++;
    }
    currentTopStack = allStacks.get(currentStackCount);
    currentTopStack.push(element);
  }

  public int pop() {
    MyStack<Integer> currentTopStack = allStacks.get(currentStackCount);
    int res = currentTopStack.pop();
    if (currentTopStack.getSize() == 0) { // current stack has gone empty lets remove it
      if (currentStackCount > 0) {
        allStacks.remove(currentStackCount);
        currentStackCount--;
      }
    }
    return res;
  }

  public int popAt(int index) {
    int chosenStack = index / threshold;
    int idx = index % threshold;
    int res = allStacks.get(chosenStack).popAt(idx);
    return res;
  }
}
