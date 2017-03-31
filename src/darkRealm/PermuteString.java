package darkRealm;

/**
 * Created by Jayam on 3/30/2017.
 */
public class PermuteString {

  private static void permutation(String str) {
    permute(str, "");
  }

  private static void permute(String str, String prefix) {
    if (str.length() == 0) {
      System.out.println(prefix);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      String rem = str.substring(0, i) + str.substring(i + 1);
      permute(rem, prefix + str.charAt(i) + "");
    }
  }

  public static void main(String[] args) {
    permutation("abcd");
  }
}