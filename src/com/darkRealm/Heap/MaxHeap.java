package com.darkRealm.Heap;

import java.util.Arrays;

/**
 * Created by Jayam on 12/28/2016.
 */
public class MaxHeap {
  //Max heap
  private int[] heap;
  private int heapCount;

  public MaxHeap(int size) {
    heap = new int[size + 1];
    heapCount = 0;
  }

  public void insert(int data) {
    if (heapCount == heap.length-1) {
      doubleSize();
    }
    //insert the new item to the last of heap (end of the array) and SIFT UP
    int pos = ++heapCount;
    heap[heapCount] = data;
    // checking for greater than beacuse its a MAX Heap
    while ((pos > 1) && data > heap[pos / 2]) {
      heap[pos] = heap[pos / 2];  // bringing the parent down to make room for new data
      pos = pos / 2;  // moving to another parent
    }
    heap[pos] = data; // final postion for new data
  }

  public int fetchTop() {
    int res = heap[1];
    int ptr, left, right;
    ptr = 1;
    left = 2 * ptr;
    right = left + 1;
    heap[1] = heap[heapCount];  // get the last element on top
    int last = heap[heapCount];  // get the last element on top
    // percolate down
    while (right <= heapCount) {
      // take the max among two childs & then SiftDown the parent
      // SiftDown left subtree
      if (heap[left] < heap[right]) {
        heap[ptr] = heap[right];
        ptr = right;
      }
      // SiftDown right subtree
      if (heap[right] < heap[left]) {
        heap[ptr] = heap[left];
        ptr = left;
      }
      left = 2 * ptr;
      right = left + 1;
    }
    heap[ptr] = last;
    heapCount--;  // drop the last element
    return res;
  }

  public boolean isEmpty() {
    return heapCount == 0;
  }

  private void doubleSize() {
    heap = Arrays.copyOf(heap, heap.length * 2);
  }
}