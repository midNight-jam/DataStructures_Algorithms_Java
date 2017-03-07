package PatternsZ.Iterator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteIterator implements Iterator {

  private List<String> data;
  private int cursor;
  private int max;

  public ConcreteIterator(String[] d) {
    data = Arrays.asList(d);
    cursor = 0;
    max = data.size();
  }

  @Override
  public String first() {
    return data.get(0);
  }

  @Override
  public String next() {
    return data.get(cursor++);
  }

  @Override
  public boolean isDone() {
    return cursor == max;
  }

  @Override
  public String currentItem() {
    return data.get(cursor);
  }
}
