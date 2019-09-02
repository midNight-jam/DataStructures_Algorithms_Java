package darkRealm;

import java.util.Arrays;
import java.util.Scanner;

public class TravellingSalesPersonDPQuadratic {


  /*
   * https://www.hackerearth.com/practice/algorithms/graphs/hamiltonian-path/tutorial/
   * */


  // TIME COMPLEXITY :  O(2^n * n^2)
  public static boolean isTSPPossible(boolean[][] adjList, int vertices) {
    int N = vertices;
    int allPossiblePermutationOfVertices = (int) Math.pow(2, N);
    boolean[][] dp = new boolean[N][allPossiblePermutationOfVertices];

    // it is possible to reach each node by self
    for (int i = 0; i < N; i++) {
      int self = (1 << i);
      dp[i][self] = true;
    }

    // for each permutation : 2 ^ N
    for (int j = 0; j < allPossiblePermutationOfVertices; j++) {
      // for each vertex : N
      for (int i = 0; i < N; i++) {
        // if jth bit is set in i (if i & j are neighbor)
        if (dp[i][1 << j] == true) {

          for (int k = 0; k < N; k++) {
            // if kth bit is also set in i & it is possible to reach i from k without j in path i.e S-{j}
            // i XOR 2j represents the subset S-{j} and the cell dp[k][ i XOR 2j ] represents whether there is a path
            // that visits each vertex in the subset S-{j} exactly once and ends at k.
            if (j != k && adjList[k][j] && dp[i][1 << k] == true && dp[k][(i ^ (1 << j))]) {
              dp[i][j] = true;
            }
          }
        }
      }
    }

    //Finally  iterates over all the vertices 0 to n-1 and check if the cell dp[i][2^n-1] is true or not
    for (int i = 0; i < N; i++)
      if (dp[i][allPossiblePermutationOfVertices - 1])
        return true;

    return false;
  }

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    String input = s.nextLine();                // Reading input from STDIN
    System.out.println("Hi, " + input + ".");    // Writing output to STDOUT
    String[] inputs = input.split(" ");
    int vertices = Integer.parseInt(inputs[0]);
    int edges = Integer.parseInt(inputs[1]);
    boolean[][] adjList = new boolean[vertices][vertices];
    for (int i = 0; i < edges; i++) {
      input = s.nextLine();                 // Reading input from STDIN
      inputs = input.split(" ");
      int from = Integer.parseInt(inputs[0]);
      int to = Integer.parseInt(inputs[1]);
      adjList[from][to] = true;
    }


    for (boolean[] b : adjList)
      System.out.println(Arrays.toString(b));
    //Scanner

    boolean res = isTSPPossible(adjList, vertices);
  }
}
