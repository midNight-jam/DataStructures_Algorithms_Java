package darkRealm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jayam on 4/1/2017.
 */
public class PrimeFactorization {

  public static Map<Long, Integer> primeFactorzation(long n) {
    Map<Long, Integer> facotrs = new HashMap<>();
    for (long f = 2; f * f < n; f++)
      while (n % f == 0) {
        n = n / f;
        facotrs.put(f, facotrs.getOrDefault(f, 0) + 1);
      }

    if (n > 1)
      facotrs.put(n, facotrs.getOrDefault(n, 0) + 1);

    return facotrs;
  }

  public static void main(String[] args) {
    int num = 1234;
    Map<Long, Integer> factors = primeFactorzation(num);
    System.out.println("Nos : " + num + " Factors : " + factors);
  }
}