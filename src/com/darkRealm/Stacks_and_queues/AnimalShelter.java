package com.darkRealm.Stacks_and_queues;

import java.util.Date;

/**
 * Created by Jayam on 1/7/2017.
 * [Prob 3.6]
 * Q) Create a system for an animal shelter where people can get the oldest animal or a oldest prefred animal
 * A) have to maintain 2 seperate queues with timestamp on each nodes data to check who arrived first.
 *    dequeAny method does this, it peeks the head of both the list & returns the node which is older
 *    dequeCat / dog will perform dequeue from their respoective queues.
 * */
public class AnimalShelter {

  CatQueue<ANode> catQue;
  DogQueue<ANode> dogQue;

  public AnimalShelter() {
    catQue = new CatQueue();
    dogQue = new DogQueue();
  }


  public ANode dequeueAny() {
    long catOldest = Long.MAX_VALUE;
    long dogOldest = Long.MAX_VALUE;
    ANode oldest = null;
    if (!catQue.isEmpty()) {
      ANode catH = (ANode) catQue.peekHead();
      catOldest = catH.timeStamp;
    }

    if (!dogQue.isEmpty()) {
      ANode dogH = (ANode) dogQue.peekHead();
      dogOldest = dogH.timeStamp;
    }
    if (catOldest < dogOldest) {
      return dequeCat();
    } else {
      return dequeDog();
    }
  }

  public ANode dequeDog() {
    if (!dogQue.isEmpty()) {
      return (ANode) dogQue.deque();
    }
    return null;
  }

  public ANode dequeCat() {
    if (!catQue.isEmpty()) {
      return (ANode) catQue.deque();
    }
    return null;
  }

  public void enequeue(String animal) {
    ANode aNode = new ANode(animal);
    if (animal.contains("Cat")) {
      catQue.enqueue(aNode);
    } else if (animal.contains("Dog")) {
      dogQue.enqueue(aNode);
    }
  }

  public class ANode {
    long timeStamp;
    String animal;

    ANode(String a) {
      this.animal = a;
      timeStamp = System.currentTimeMillis();
    }
  }

  private class CatQueue<T> extends MyQueue {

  }

  private class DogQueue<T> extends MyQueue {

  }
}