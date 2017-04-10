/**
 * Created by Jayam on 4/1/2017.
 */
public class PalindromeReverse {
  public static boolean palindrome(String str) {
    if (str == null || str.length() == 0) return true;
    int li = 0;
    for (int i = 0; i < str.length() / 2; i++) {
      li = str.length() - i - 1;
      if (str.charAt(i) != str.charAt(li))
        return false;
    }
    return true;
  }

  public static String reverse(String str) {
    char[] arr = str.toCharArray();
    int li  = 0;
    for (int i = 0; i < str.length() / 2; i++) {
      li = str.length() - i -1;
      char temp = arr[i];
      arr[i] = arr[li];
      arr[li] = temp;
    }
    return new String(arr);
  }

  public static void main(String[] args) {
    String str = "ragecar";
    boolean res = palindrome(str);
    String str2 = "AAABBCCDDEE";
    System.out.println(reverse(str2));
  }
}