package darkRealm.CTCI;

import darkRealm.CTCI.Stacks_and_queues.AnimalShelter;
import darkRealm.CTCI.Stacks_and_queues.MinStack;
import darkRealm.CTCI.Stacks_and_queues.MyStack;
import darkRealm.CTCI.Stacks_and_queues.Stacks_and_Queues;

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

  public static void testSortStack() {
    MyStack<Integer> myStack = new MyStack<>();
    myStack.push(2);
    myStack.push(1);
    myStack.push(4);
    myStack.push(0);
    myStack.push(3);
    myStack.push(1);
    myStack.push(5);

    MyStack<Integer> sorted = Stacks_and_Queues.SortStack(myStack);

    System.out.println("Will be displauypig  the stack here");
  }

  public static void testSetStacks() {
    Stacks_and_Queues.setOfStacks();
  }

  public static void testThreeStacks() {
    Stacks_and_Queues.threeStackInArray();
  }

  public static void testRoundArray() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    Stacks_and_Queues.roundedArray(arr);
    System.out.println(" " + arr[0]);
  }

  public static void testAnimalShelter() {
    AnimalShelter animalShelter = new AnimalShelter();
    animalShelter.enequeue("Cat1");
    animalShelter.enequeue("Dog1");
    animalShelter.enequeue("Dog2");
    animalShelter.enequeue("Cat2");
    animalShelter.enequeue("Cat3");
    animalShelter.enequeue("Dog3");
    animalShelter.enequeue("Cat4");
    System.out.println(" " + animalShelter);
    AnimalShelter.ANode res = animalShelter.dequeueAny();
    System.out.print(res);
    res = animalShelter.dequeCat();
    System.out.print(res);
  }
}