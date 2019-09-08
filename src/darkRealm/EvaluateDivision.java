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


  Map<String, Map<String, Double>> map;

  public double[] calcEquation(List<List<String>> eqs, double[] vals, List<List<String>> quers) {
    if (eqs == null || eqs.size() < 1 || vals == null || vals.length < 1 || quers == null || quers.size() < 1)
      return new double[0];

    map = new HashMap<>();

    for (int i = 0; i < vals.length; i++) {
      String from = eqs.get(i).get(0);
      String to = eqs.get(i).get(1);
      if (!map.containsKey(from))
        map.put(from, new HashMap<>());
      if (!map.containsKey(to))
        map.put(to, new HashMap<>());
      map.get(from).put(to, vals[i]);
      map.get(to).put(from, 1.0 / vals[i]);
    }

    double[] res = new double[quers.size()];

    for (int i = 0; i < quers.size(); i++) {
      String src = quers.get(i).get(0);
      String dest = quers.get(i).get(1);
      if (!map.containsKey(src) || !map.containsKey(dest)) {
        res[i] = -1.0;
        continue;
      }
      if (src.equals(dest)) {
        res[i] = 1.0;
        continue;
      }
      res[i] = getCost(src, dest);
    }

    return res;
  }

  private double getCost(String src, String dest) {
    Set<String> visited = new HashSet<>();
    Queue<String> path = new LinkedList<>();
    Queue<Double> vals = new LinkedList<>();
    path.offer(src);
    vals.offer(1.0);

    while (path.size() > 0) {
      int p = path.size();
      while (p-- > 0) {
        String h = path.poll();
        double v = vals.poll();
        visited.add(h);
        if (h.equals(dest)) return v;
        Map<String, Double> nbors = map.get(h);
        for (String n : nbors.keySet()) {
          if (visited.contains(n)) continue;
          path.offer(n);
          vals.offer(v * nbors.get(n));
        }
      }
    }
    return -1.0;
  }

  public static void main(String[] args) {

  }
}
