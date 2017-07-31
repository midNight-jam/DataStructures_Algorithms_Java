/**
 * Created by Jayam on 4/27/2017.
 */
public class TinyUrl {

  public static String idToShortURL(int n) {
    // Map to store 62 possible characters
    char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    StringBuilder shorturl = new StringBuilder();

    // Convert given integer id to a base 62 number
    long un = 0;
    if (n < 0)
      un = (long)Integer.MAX_VALUE + Math.abs(n);
    else
      un = n;

    while (un > 0) {
      // use above map to store actual character
      // in short url
      shorturl.append(map[(int) (un % 62)]);
      un = un / 62;
    }

    // Reverse shortURL to complete base conversion
//    reverse(shorturl.begin(), shorturl.end());
    String res = shorturl.reverse().toString();
    return res;
  }

  public static long shortURLtoID(String shortURL) {
    long id = 0; // initialize result

    // A simple base conversion logic
    for (int i = 0; i < shortURL.length(); i++) {
      if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
        id = id * 62 + shortURL.charAt(i) - 'a';
      if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
        id = id * 62 + shortURL.charAt(i) - 'A' + 26;
      if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
        id = id * 62 + shortURL.charAt(i) - '0' + 52;
    }
    return id;
  }

  public static void main(String[] args) {
    String str = "abc";
    String shortUrl = idToShortURL(str.hashCode());
    long res = shortURLtoID(shortUrl);
//    System.out.println("Str : " + str + " Short : " + shortUrl + " id : " + res);
//    System.out.println("Str hash: " + str.hashCode());

    shortUrl = idToShortURL(-1);
    res = shortURLtoID(shortUrl);
    System.out.println(" Short : " + shortUrl + " id : " + res);
    System.out.println("Str hash: " + str.hashCode());

    shortUrl = idToShortURL(1);
    res = shortURLtoID(shortUrl);
    System.out.println(" Short : " + shortUrl + " id : " + res);
    System.out.println("Str hash: " + str.hashCode());
  }
}