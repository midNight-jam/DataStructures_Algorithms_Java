package PatternsZ.Command;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface Command {

  void execute();

  void setReceiver(Receiver target);
}