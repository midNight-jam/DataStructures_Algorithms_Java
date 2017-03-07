package PatternsZ.Command;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface Invoker {
  void setCommand(Command cmd);

  void invoke();
}
