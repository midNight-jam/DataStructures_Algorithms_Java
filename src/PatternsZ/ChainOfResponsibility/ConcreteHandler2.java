package PatternsZ.ChainOfResponsibility;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteHandler2 implements Handler {
  Handler successor;
  String myLabel;

  public ConcreteHandler2() {
    myLabel = "CH2";
  }

  @Override
  public void handleRequest(String str) {
    if (str.equals(myLabel)) {
      System.out.println("ConcreteHandler2 is Handling the msg  " + str);
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