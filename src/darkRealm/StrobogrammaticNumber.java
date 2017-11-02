package darkRealm;

public class StrobogrammaticNumber {

  public static boolean isStrobogrammatic(String num) {
    if (num == null || num.length() == 0) return false;
    char[] arr = num.toCharArray();
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      if (!isValid(arr[low]) || !isValid(arr[high])) return false;
      if (getOpposite(arr[low]) != arr[high]) return false;
      low++;
      high--;
    }
    return true;
  }

  private static char getOpposite(char c) {
    if (c == '0' || c == '1' || c == '8') return c;
    return c == '6' ? '9' : '6';
  }

  private static boolean isValid(char c) {
    return (c == '0' || c == '1' || c == '6' || c == '8' || c == '9');
  }

  public static void main(String[] args) {
    String num = "61019";
    boolean res = isStrobogrammatic(num);
    System.out.println("N : " + num);
    System.out.println("B : " + res);
  }
}