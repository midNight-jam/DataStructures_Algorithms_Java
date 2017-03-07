package PatternsZ.Proxy;

/**
 * Created by Jayam on 3/7/2017.
 */
public interface SubjectProxy {
  String readData(String param);

  void writeData(String authToken, String param);
}
