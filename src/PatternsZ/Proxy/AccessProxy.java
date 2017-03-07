package PatternsZ.Proxy;

/**
 * Created by Jayam on 3/7/2017.
 */
public class AccessProxy implements SubjectProxy {
  RealSubject rsubj = new RealSubject();

  @Override
  public String readData(String authToken) {
    if (authToken.equals("12345"))
      return rsubj.readData();
    System.out.println("Not authorized");
    return "";
  }

  @Override
  public void writeData(String authToken, String param) {
    if (authToken.equals("9876"))
      rsubj.writeData(param);
    else
      System.out.println("Unauthorized");
  }
}