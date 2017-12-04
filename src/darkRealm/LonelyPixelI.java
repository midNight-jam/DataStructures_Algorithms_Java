package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixelI {


/*
   #531. Lonely Pixel I
  Given a picture consisting of black and white pixels, find the number of black lonely pixels.
  The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
  A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't
  have any other black pixels.
  Example:
  Input:
      [['W', 'W', 'B'],
      ['W', 'B', 'W'],
      ['B', 'W', 'W']]
  Output: 3
  Explanation: All the three 'B's are black lonely pixels.
  Note:
  The range of width and height of the input 2D array is [1,500].
 */


  public int findLonelyPixel(char[][] picture) {
    if (picture == null || picture.length == 0 ||
        picture[0].length == 0) return -1;

    int rows[] = new int[picture.length];
    int cols[] = new int[picture[0].length];
    int count = 0;
    for (int y = 0; y < picture.length; y++) {
      for (int x = 0; x < picture[0].length; x++) {
        if (picture[y][x] == 'W') continue;
        rows[y]++;
        cols[x]++;
      }
    }

    for (int y = 0; y < picture.length; y++) {
      for (int x = 0; x < picture[0].length; x++) {
        if (picture[y][x] == 'W') continue;
        if (rows[y] == 1 && cols[x] == 1) count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {

  }
}
