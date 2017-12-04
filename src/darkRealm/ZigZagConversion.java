package darkRealm;

public class ZigZagConversion {

  /*  #6 ZigZag Conversion
    * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    * (you may want to display this pattern in a fixed font for better legibility)
    * P   A   H   N
    * A P L S I I G
    * Y   I   R
    * And then read line by line: "PAHNAPLSIIGYIR"
    * Write the code that will take a string and make this conversion given a number of rows:
    * string convert(string text, int nRows);
    * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
    * */
  public static String zigZagConversion(String str, int numRows) {
    StringBuilder[] zigZag = new StringBuilder[numRows];
    for (int i = 0; i < zigZag.length; i++) {
      zigZag[i] = new StringBuilder();
    }
    char c;
    int up = 0;
    int down = -1;
    boolean upwards = true;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (upwards && up < zigZag.length) {
        zigZag[up].append(c);
        up++;
      } else if (down > 0 && !upwards) {
        zigZag[down].append(c);
        down--;
      }
      if (up == numRows && upwards) {
        upwards = !upwards;
        down = zigZag.length - 2;
        if (down <= 0) {
          down = 0;
          upwards = !upwards;
          up = 0;
        }
      } else if (down == 0 && !upwards) {
        upwards = !upwards;
        up = 0;
      }
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < zigZag.length; i++) {
      res.append(zigZag[i]);
    }

    return res.toString();
  }

  public static void main(String[] args) {
    String str = "paypalishiring";
    int k = 4;

    String res = zigZagConversion(str, k);
    System.out.print("str : " + str + " Level : " + k);
    System.out.print("  res : " + res);
  }
}
