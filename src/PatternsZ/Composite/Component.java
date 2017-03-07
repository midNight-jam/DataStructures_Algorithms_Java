package PatternsZ.Composite;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface Component {
  void operation();

  void addChild(Component c);

  void removeChild(Component c);

  Component getChild(int i);
}
