package PatternsZ.ChainOfResponsibility;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteHandler1 implements Handler {
  private Handler successor = null;
  String myLabel;

  public ConcreteHandler1() {
    myLabel = "CH1";
  }

  @Override
  public void handleRequest(String str) {
    if (str.equals(myLabel)) {
      System.out.println("ConcreteHandler1 is Handling the msg  " + str);
    } else {
      if (successor != null)
        successor.handleRequest(str);
    }
  }

  @Override
  public void setSuccessor(Handler next) {
    successor = next;
  }
}