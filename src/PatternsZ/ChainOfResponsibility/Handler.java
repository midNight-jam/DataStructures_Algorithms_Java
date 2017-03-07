package PatternsZ.ChainOfResponsibility;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface Handler {
  void handleRequest(String str);
  void setSuccessor(Handler h);
}
