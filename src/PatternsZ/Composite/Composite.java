package PatternsZ.Composite;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Composite implements Component {
  java.util.LinkedList<Component> childs;
  String msg;

  public Composite(String str) {
    msg = str;
    childs = new java.util.LinkedList<>();
  }

  @Override
  public void operation() {
    for (Component c : childs)
      c.operation();
    System.out.println(msg);
    return;
  }

  @Override
  public void addChild(Component c) {
    childs.add(c);
  }

  @Override
  public void removeChild(Component c) {
    childs.remove(c);
  }

  @Override
  public Component getChild(int i) {
    return childs.get(i);
  }
}