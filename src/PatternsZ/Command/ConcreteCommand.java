package PatternsZ.Command;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteCommand implements Command {
  Receiver theReceiver;

  @Override
  public void execute() {
    theReceiver.doAction();
  }

  @Override
  public void setReceiver(Receiver target) {
    theReceiver = target;
  }
}