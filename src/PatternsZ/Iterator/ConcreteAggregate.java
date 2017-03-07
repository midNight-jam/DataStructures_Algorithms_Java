package PatternsZ.Iterator;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteAggregate implements Aggregate {
  private String[] data;


  public void fetchData() {
    data = new String[]{"aa", "bb", "cc", "dd"};
  }

  @Override
  public Iterator createIterator() {

    return new ConcreteIterator(data);
  }
}