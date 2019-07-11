package darkRealm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort {

  private static List<Integer> topologicalSort(int[][] adjList) {
    List<Integer> res = new ArrayList<>();
    if (adjList == null || adjList.length < 1 || adjList[0].length < 1) return res;
    int V = adjList.length;
    boolean[] visited = new boolean[V];
    for(int i = 0; i < V; i++){
      if(!visited[i]){ // if there is any vertex that is not visited, then start dfs from it
        helper(adjList, visited, res, i);
      }
    }
    return res;
  }

  private static void helper(int[][] adjList, boolean[] visited, List<Integer> res, int vi) {
    visited[vi] = true;
    int vertices = adjList[0].length;
    for (int i = 0; i < vertices; i++) {
      // there is an outgoing edge to this vertex & the vertex is not visited, process it
      if (adjList[vi][i] == 1 && visited[i] == false) {
        helper(adjList, visited, res, i);
      }
    }
    // insert the current processing node at the head of the list
    res.add(0, vi);
  }

  public static void main(String[] args) {

//    Scanner s = new Scanner(System.in);
//    String name = s.nextLine();                 // Reading input from STDIN
//    System.out.println("Hi, " + name + ".");
//
//    String [] ips = name.split(" ");
//    int V = Integer.parseInt(ips[0]);
//    int lines = Integer.parseInt(ips[1]);
//    int to, from;
//    int[][] adjList = new int[V + 1][V + 1];
//
//    while(lines > 0){
//      name = s.nextLine();
//      ips = name.split(" ");
//      from =   Integer.parseInt(ips[0]);
//      to =   Integer.parseInt(ips[1]);
//      adjList[from][to] = 1;
//      lines--;
//    }

    int[][] adjList = new int[][]{
      // 0  1  2  3  4  5
        {0, 1, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
    };

//    int[][] adjList = new int[][]{
//      // 0  1  2  3  4  5
//        {0, 0, 0, 0, 0, 0}, //0
//        {0, 0, 0, 0, 0, 0}, //1
//        {0, 0, 0, 1, 0, 0}, //2
//        {0, 1, 0, 0, 0, 0}, //3
//        {1, 1, 0, 0, 0, 0}, //4
//        {1, 0, 1, 0, 0, 0}, //5
//    };

    List<Integer> res = topologicalSort(adjList);
    for(int r : res)
      System.out.print(r +" ");
  }
}
