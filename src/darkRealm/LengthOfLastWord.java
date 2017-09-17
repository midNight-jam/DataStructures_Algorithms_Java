package darkRealm;

public class LengthOfLastWord {

  public static int lengthOfLastWord(String s) {
    String [] arr = s.split(" ");
    return arr.length > 0 ? arr[arr.length - 1].length() : 0;
  }

  public static void main(String[] args) {
    String str = "Hello World";
    int res = lengthOfLastWord(str);
    System.out.println("S : " + str + "\nR : " + res);
  }
}