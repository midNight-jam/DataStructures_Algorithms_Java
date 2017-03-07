package PatternsZ.Composite;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Leaf implements Component {
  String msg;
  public Leaf(String str){
    msg = str;
  }
  @Override
  public void operation() {
    System.out.println(msg);
  }

  @Override
  public void addChild(Component c) {
    return;
  }

  @Override
  public void removeChild(Component c) {
    return;
  }

  @Override
  public Component getChild(int i) {
    return null;
  }
}