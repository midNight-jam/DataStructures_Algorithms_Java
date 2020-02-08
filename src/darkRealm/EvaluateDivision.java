package darkRealm;


import java.util.*;

public class EvaluateDivision {

//  399. Evaluate Division
//  Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real
//  number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
//
//  Example:
//  Given a / b = 2.0, b / c = 3.0.
//  queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//      return [6.0, 0.5, -1.0, 1.0, -1.0 ].
//
//  The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries,
//  where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
//
//  According to the example above:
//
//  equations = [ ["a", "b"], ["b", "c"] ],
//  values = [2.0, 3.0],
//  queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
//
//
//  The input is always valid. You may assume that evaluating the queries will result in no division by zero and there
//  is no contradiction.


  static double queryRes;

  public static double[] calcEquation(List<List<String>> eqs, double[] vals, List<List<String>> queries) {
    if (eqs == null || vals == null || eqs.size() != vals.length) return new double[0];
    Map<String, Map<String, Double>> adjMap = new HashMap<>();

    for (int i = 0; i < vals.length; i++) {
      String from = eqs.get(i).get(0);
      String to = eqs.get(i).get(1);

      // add the edge
      if (!adjMap.containsKey(from))
        adjMap.put(from, new HashMap<>());
      adjMap.get(from).put(to, vals[i]);

      // add the reverse edge, thus (1.0 / val)
      if (!adjMap.containsKey(to))
        adjMap.put(to, new HashMap<>());
      adjMap.get(to).put(from, (1 / vals[i]));
    }

    double[] res = new double[queries.size()];
    int i = 0;
    Set<String> recStack = new HashSet<>(); // as we have reverse edges, this will help avoid loop
    for (List<String> q : queries) {
      String src = q.get(0);
      String dest = q.get(1);
      queryRes = -1.0; // reset the queryResult
      if (!adjMap.containsKey(src) || !adjMap.containsKey(dest))
        res[i++] = queryRes;
      else {
        dfsHelper(adjMap, dest, src, 1.0, recStack);
        res[i++] = queryRes;
      }
    }

    return res;
  }

  private static void dfsHelper(Map<String, Map<String, Double>> adjMap, String dest, String from, double val, Set<String> recStack) {
    if (dest.equals(from)) {
      queryRes = val;
      return;
    }

    recStack.add(from);
    Map<String, Double> nbors = adjMap.get(from);

    for (String n : nbors.keySet()) {
      if (recStack.contains(n)) continue; // if this nbor is already under call stack
      dfsHelper(adjMap, dest, n, (val * nbors.get(n)), recStack);
    }
    recStack.remove(from);
  }

  public static void main(String[] args) {
    List<List<String>> eqs = new ArrayList<>();
    eqs.add(Arrays.asList(new String[]{"a", "b"}));
    eqs.add(Arrays.asList(new String[]{"b", "c"}));
    double[] vals = new double[]{2.0, 3.0};
    List<List<String>> queries = new ArrayList<>();
    queries.add(Arrays.asList(new String[]{"a", "c"}));

    double[] res = calcEquation(eqs, vals, queries);
    System.out.println(Arrays.toString(res));
  }
}
