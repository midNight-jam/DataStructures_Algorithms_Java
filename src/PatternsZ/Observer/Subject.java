package PatternsZ.Observer;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface Subject {
  void attach(Observer o);

  void detach(Observer o);

  void notifyObserver();
}