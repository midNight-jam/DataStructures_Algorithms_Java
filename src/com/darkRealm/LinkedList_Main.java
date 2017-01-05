package com.darkRealm;

import com.darkRealm.LinkedLists.LinkedList;
import com.darkRealm.LinkedLists.Node;

/**
 * Created by Jayam on 1/4/2017.
 */
public class LinkedList_Main {
  public static void testLinkedListOperations() {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.appendToTail(new Node(3));
    list.appendToHead(new Node(0));
    LinkedList l2 = list.clone();
    list.addAll(l2);
    System.out.println("list - " + list);
  }
}
