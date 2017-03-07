package PatternsZ.Proxy;

/**
 * Created by Jayam on 3/7/2017.
 */
public class CachingProxy implements SubjectProxy {

  RealSubject rsubj = new RealSubject();
  boolean cacheExpired = false;
  String cachedData;

  @Override
  public String readData(String param) {
    if (cachedData != null && !cacheExpired)
      return cachedData;

    cachedData = rsubj.readData();
    cacheExpired = false;
    return cachedData;
  }

  @Override
  public void writeData(String authToken, String param) {
    rsubj.writeData(param);
    cachedData = param;
    cacheExpired = false;
  }
}