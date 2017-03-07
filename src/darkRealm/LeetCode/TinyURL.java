package darkRealm.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Jayam on 3/6/2017.
 */
public class TinyURL {
  Map<String, String> shortToLong = new HashMap<>();
  Map<String, String> longToShort = new HashMap<>();

  TinyURL() {
    shortToLong.put(".", ".");
  }

  String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  public String decode(String shortUrl) {
    if (shortToLong.containsKey(shortUrl)) return shortToLong.get(shortUrl);
    return shortUrl;
  }

  public String encode(String longUrl) {
    if (longToShort.containsKey(longUrl)) return longToShort.get(longUrl);
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    String shortUrl = ".";
    while (shortToLong.containsKey(shortUrl)) {
      for (int i = 0; i < 6; i++) {
        int index = rand.nextInt(chars.length());
        sb.append(chars.charAt(index));
      }
      shortUrl = sb.toString();
    }
    shortToLong.put(shortUrl, longUrl);
    longToShort.put(longUrl, shortUrl);
    return shortUrl;
  }
}