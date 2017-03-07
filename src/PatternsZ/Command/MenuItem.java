package PatternsZ.Command;

/**
 * Created by Jayam on 3/7/2017.
 */
public class MenuItem implements Invoker {
  private Command command;

  @Override
  public void setCommand(Command cmd) {
    command = cmd;
  }

  @Override
  public void invoke() {
    command.execute();
  }
}
