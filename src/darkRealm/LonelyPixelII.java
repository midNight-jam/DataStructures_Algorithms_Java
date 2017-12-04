package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixelII {




/*
  #533. Lonely Pixel II
  Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels
  located at some specific row R and column C that align with all the following rules:
  Row R and column C both contain exactly N black pixels.
  For all rows that have a black pixel at column C, they should be exactly the same as row R
  The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
  Example:
  Input:
      [['W', 'B', 'W', 'B', 'B', 'W'],
      ['W', 'B', 'W', 'B', 'B', 'W'],
      ['W', 'B', 'W', 'B', 'B', 'W'],
      ['W', 'W', 'B', 'W', 'B', 'W']]
  N = 3
  Output: 6
  Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
            0    1    2    3    4    5         column index
    0   [ ['W', 'B', 'W', 'B', 'B', 'W'],
    1     ['W', 'B', 'W', 'B', 'B', 'W'],
    2     ['W', 'B', 'W', 'B', 'B', 'W'],
    3     ['W', 'W', 'B', 'W', 'B', 'W']]
  row index

  Take 'B' at row R = 0 and column C = 1 as an example:
  Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
  Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.
  Note:
  The range of width and height of the input 2D array is [1,200].
*/

  public static int findLonelyPixelII(char[][] picture, int N) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
    int[] colsCount = new int[picture[0].length];
    Map<String, Integer> map = new HashMap<>();
    StringBuilder sb;
    int rowCount = 0;
    for (int i = 0; i < picture.length; i++) {
      sb = new StringBuilder();
      rowCount = 0;
      for (int j = 0; j < picture[0].length; j++) {
        if (picture[i][j] == 'B') {
          colsCount[j]++;
          rowCount++;
        }
        sb.append(picture[i][j]);
      }
      if (rowCount == N)
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
    }

    int result = 0;
    for (String key : map.keySet())
      if (map.get(key) == N)
        for (int i = 0; i < key.length(); i++)
          if (key.charAt(i) == 'B' && colsCount[i] == N)
            result += N;

    return result;
  }

  public static void main(String[] args) {

  }
}
