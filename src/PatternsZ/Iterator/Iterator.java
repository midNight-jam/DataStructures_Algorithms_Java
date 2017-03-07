package PatternsZ.Iterator;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface Iterator {
  String first();
  String next();
  boolean isDone();
  String currentItem();
}
