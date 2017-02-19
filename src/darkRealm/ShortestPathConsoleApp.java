package darkRealm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Jayam on 2/18/2017.
 */
public class ShortestPathConsoleApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(" enter No of rows ");
    int r = Integer.parseInt(sc.nextLine());
    System.out.println(" enter No of cols ");
    int c = Integer.parseInt(sc.nextLine());
    System.out.println(" enter First char ");
    char s = sc.nextLine().charAt(0);

    System.out.println(" enter Second char ");
    char e = sc.nextLine().charAt(0);

    System.out.println(" Enter space seprated " + r + " rows with " + c + " chars");
    char[][] matrix = new char[r][c];
    String line;
    String[] arr;


    for (int i = 0; i < r; i++) {
      System.out.println(" enter row #" + i);
      line = sc.nextLine();
      arr = line.split(" ");
      for (int j = 0; j < c; j++) {
        matrix[i][j] = arr[j].charAt(0);
      }
    }
    String shortestPath = shortestPath(matrix, s, e);
    System.out.println("Shortest path between " + s + " - " + e + " is : " + shortestPath);
  }

  public static String shortestPath(char[][] matrix, char a, char b) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return "";
    int startR, startC;
    startR = startC = 0;
    boolean found = false;
    char toSearch = '\u0000';
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == a || matrix[i][j] == b) {
          startR = i;
          startC = j;
          found = true;
          toSearch = matrix[i][j] == a ? b : a;
          break;
        }
      }
      if (found) break;
    }
    return found ? bfsShortestPath(matrix, startR, startC, toSearch) : "";
  }

  private static String bfsShortestPath(char[][] matrix, int startR, int startC, char toSearch) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int[] rowNeighbours = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] colNeighbours = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    Queue<QueNode> queue = new LinkedList<>();
    queue.add(new QueNode(0, startR, startC, matrix[startR][startC] + ""));
    QueNode trav;
    while (!queue.isEmpty()) {
      trav = queue.remove();
      visited[trav.row][trav.col] = true;
      if (toSearch == matrix[trav.row][trav.col]) {
        return trav.path;
      }
      int eRow, eCol;
      for (int i = 0; i < rowNeighbours.length; i++) {
        eRow = trav.row + rowNeighbours[i];
        eCol = trav.col + colNeighbours[i];
        if (isSafe(matrix, eRow, eCol, visited))
          queue.add(new QueNode(trav.dist + 1, eRow, eCol, trav.path + " " + matrix[eRow][eCol]));
      }
    }
    return "";
  }

  private static boolean isSafe(char[][] matrix, int r, int c, boolean[][] visited) {
    return (r > -1 && r < matrix.length && c > -1 && c < matrix[0].length && !visited[r][c]);
  }

  private static class QueNode {
    int dist;
    int row;
    int col;
    String path;

    QueNode(int l, int r, int c, String p) {
      dist = l;
      row = r;
      col = c;
      path = p;
    }
  }
}