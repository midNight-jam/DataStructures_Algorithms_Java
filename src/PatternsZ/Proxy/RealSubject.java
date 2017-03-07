package PatternsZ.Proxy;

/**
 * Created by Jayam on 3/7/2017.
 */
public class RealSubject {
  String data = "DATA101010101";

  public String readData() {
    return data;
  }

  public void writeData(String dat) {
    data = dat;
  }
}