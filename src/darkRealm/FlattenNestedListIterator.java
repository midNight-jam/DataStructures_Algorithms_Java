package darkRealm;

import java.util.*;

public class FlattenNestedListIterator {

//  #341. Flatten Nested List Iterator
//  Given a nested list of integers, implement an iterator to flatten it.
//  Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//      Example 1:
//  Given the list [[1,1],2,[1,1]],
//  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//  Example 2:
//  Given the list [1,[4,[6]]],
//  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

  public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public static class NestedInt implements NestedInteger {
    Integer val;

    public NestedInt(int v) {
      val = v;
    }

    public boolean isInteger() {
      return true;
    }

    public Integer getInteger() {
      return val;
    }

    public List<NestedInteger> getList() {
      return null;
    }
  }

  public static class NestedList implements NestedInteger {
    List<NestedInteger> val;

    public NestedList() {
      val = new ArrayList<>();
    }

    public boolean isInteger() {
      return false;
    }

    public Integer getInteger() {
      return null;
    }

    public List<NestedInteger> getList() {
      return val;
    }
  }

  public static class NestedIteratorOLD implements Iterator<Integer> {
    Stack<ListIterator<NestedInteger>> stack;

    public NestedIteratorOLD(List<NestedInteger> nestedList) {
      stack = new Stack<>();
      stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
      hasNext();
      return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
      while (!stack.isEmpty()) {
        ListIterator<NestedInteger> nit = stack.peek();
        if (!nit.hasNext()) stack.pop();
        else {
          nit = stack.peek();
          NestedInteger n = nit.next();
          if (n.isInteger()) {
            nit.previous();// resuming the top of stack to have integer, so next() works
            return true;
          }
          stack.push(n.getList().listIterator()); // pushing the list iterator on stack
        }
      }
      return false;
    }
  }

  public static class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
      stack = new Stack<>();
      pushEachOfListToStack(nestedList);
    }

    private void pushEachOfListToStack(List<NestedInteger> nestedList){
      for(int i = nestedList.size() - 1; i >= 0; i--){
        stack.push(nestedList.get(i));
      }
    }

    @Override
    public Integer next() {
      return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
      while(stack.size() > 0){
        NestedInteger ni = stack.peek();
        if(ni.isInteger())
          return true;
        stack.pop(); // remove the nested list from stack, as we are going to push each element now
        pushEachOfListToStack(ni.getList());
      }
      return false;
    }
  }

  public static void main(String[] args) {
//    List<NestedInteger> nlist = new ArrayList<>();
//    NestedList nli = new NestedList();
//    nli.getList().add(new NestedInt(1));
//
//    NestedList nli2 = new NestedList();
//    nli2.getList().add(new NestedInt(11));
//    nli2.getList().add(new NestedInt(22));
//    nli.getList().add(nli2);
//    nli.getList().add(new NestedInt(2));
//
//    nlist.add(new NestedInt(0));
//    nlist.add(nli);
//    nlist.add(new NestedInt(3));

//    List<NestedInteger> nlist = new ArrayList<>();
//    NestedList nli = new NestedList();
//    nli.getList().add(new NestedInt(1));
//    nli.getList().add(new NestedInt(1));
//    nlist.add(nli);
//    nlist.add(new NestedInt(2));
//    nlist.add(nli);


    List<NestedInteger> nlist = new ArrayList<>();
    NestedInteger nli = new NestedList();
    nlist.add(nli);
    NestedIterator nit = new NestedIterator(nlist);

    while (nit.hasNext()) {
      System.out.println(nit.next());
    }

  }
}