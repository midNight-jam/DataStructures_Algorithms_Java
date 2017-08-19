/**
 * Created by Jayam on 4/13/2017.
 */
public class LaceWork {
  public static String phoneNumber(String str) {
    if (str == null || str.length() == 0) return str;
    str = str.trim().replaceAll("-| ", "");

    int len = str.length();
    if (len <= 3) return str;

    StringBuilder sb = new StringBuilder();
    int ptr = 0;
    if (len % 3 == 1) {
      for (int chunks = len / 3 - 1; chunks != 0; chunks--, ptr += 3)
        sb.append(str.substring(ptr, ptr + 3) + "-");
      sb.append(str.substring(ptr, ptr + 2) + "-");
      ptr += 2;
      sb.append(str.substring(ptr));
      return sb.toString();
    }

    for (ptr = 0; ptr < str.length() - len % 3; ptr += 3)
      sb.append(str.substring(ptr, ptr + 3) + "-");
    sb.append(str.substring(ptr));
    return len % 3 == 0 ? sb.toString().substring(0, sb.length() - 1) : sb.toString();
  }

  public static void main(String[] args) {
//    String input = "00-44 48 5555 83-6";
//    String input = "00-44 48 5555 83-66";
//    String input = "004448555583";
    String input = "0 - 22 1985-324";
    String res = phoneNumber(input);
    System.out.println(" Input : " + input);
    System.out.println(" result : " + res);
  }
}