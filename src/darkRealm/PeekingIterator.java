package darkRealm;

import java.util.*;

//  #284  Peeking Iterator  ::: Complexity  - Time : O(1)   , Space : O(1)
//  Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
//  support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
//    Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
//    Call next() gets you 1, the first element in the list.
//    Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
//    You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
//    Follow up: How would you extend your design to be generic and work with all types, not just integer?
//
//  P.S - My prev soln got accepted but was shitty, against this one. I cached whole list using iterator and then for every
// peek I restarted from begin & stop from used -1. Shitty!!
public class PeekingIterator implements Iterator<Integer> {
  Iterator<Integer> itr;
  Integer next;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    itr = iterator;
    next = itr.next();
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    int n = next;
    next = itr.hasNext() ? itr.next() : null;
    return n;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[]{3, 6, 5, 4, 0}));
    PeekingIterator pi = new PeekingIterator(nums.iterator());
    System.out.println(pi.hasNext());
    System.out.println(pi.peek());
    System.out.println(pi.next());
    System.out.println(pi.peek());
    System.out.println(pi.peek());
    System.out.println(pi.next());
  }
}