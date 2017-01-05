package com.darkRealm.LinkedLists;

/**
 * Created by Jayam on 1/4/2017.
 */
public class LinkedList {
  Node head;
  Node tail;
  int size;

  public void appendToTail(Node d) {
    if(d==null){
      return;
    }
    if (head == null) {
      head = new Node(d.data);
      tail = head;
      size++;
      return;
    }
    tail.next = new Node(d.data);
    tail = tail.next;
    size++;
  }

  public void add(int d) {
    appendToTail(new Node(d));
  }

  public void appendToHead(Node d) {
    if (head == null) {
      head = new Node(d.data);
      tail = head;
      size++;
      return;
    }
    Node temp = new Node(d.data);
    temp.next = head;
    head = temp;
    size++;
  }

  public Node removeFirst() {
    if (size() > 0) {
      Node temp = head;
      head = head.next;
      size--;
      return temp;
    }
    return null;
  }

  public Node removeLast() {
    Node trav = head;
    while (trav.next.next != null) {
      trav = trav.next;
    }
    Node temp = trav;
    tail = trav;
    size--;
    return temp;
  }

  public int size() {
    return size;
  }

  public LinkedList clone() {
    Node travA = this.head;
    LinkedList clone = new LinkedList();
    while (travA != null) {
      clone.add(travA.data);
      travA = travA.next;
    }
    return clone;
  }

  public void addAll(LinkedList list) {
    Node trav = list.head;
    while (trav != null) {
      if(this.tail==null){
        this.tail = new Node(trav.data);
      }
      else {
        this.tail.next = new Node(trav.data);
      }
      this.tail = this.tail.next;
      trav = trav.next;
    }
  }
}