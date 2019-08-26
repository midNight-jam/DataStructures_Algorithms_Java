package darkRealm;

import java.util.*;

public class ReconstructItinerary {

//  332. Reconstruct Itinerary
//  Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
//  itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//  Note:
//
//  If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
//  read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//  All airports are represented by three capital letters (IATA code).
//  You may assume all tickets form at least one valid itinerary.
//      Example 1:
//
//  Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//  Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
//  Example 2:
//
//  Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//  Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//  Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//  But it is larger in lexical order.


  public static List<String> findItinerary(List<List<String>> tkts) {
    List<String> res = new ArrayList<>();
    if (tkts == null || tkts.size() < 1) return res;

    // Sort the flights by the destination first then source

    Collections.sort(tkts, new Comparator() {
      public int compare(Object o1, Object o2) {
        List<String> f1 = (List<String>) o1;
        List<String> f2 = (List<String>) o2;
        String fa = f1.get(0);
        String fb = f2.get(0);

        String ta = f1.get(1);
        String tb = f2.get(1);

        return (!ta.equals(tb)) ? ta.compareTo(tb) : fa.compareTo(fb);
      }
    });

    // using a linked list which will behave as que will not give concurrent modificatoin exception
    Map<String, LinkedList<String>> adjList = new HashMap<>();
    for (List<String> t : tkts) {
      String from = t.get(0);
      String to = t.get(1);
      if (!adjList.containsKey(from))
        adjList.put(from, new LinkedList());
      adjList.get(from).add(to);
    }


    helper("JFK", adjList, res);
    System.out.println(res);
    return res;
  }

  private static void helper(String from, Map<String, LinkedList<String>> adjList, List<String> res) {
    Queue<String> nbors = adjList.containsKey(from) ? adjList.get(from) : new LinkedList<>();
    while (nbors.size() > 0) {
      String n = nbors.poll();
      helper(n, adjList, res);
    }
    res.add(0, from);
  }

  public static void main(String[] args) {
    List<List<String>> tkts = new ArrayList<>();

//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"JFK", "SFO"})));
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"JFK", "ATL"})));
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"SFO", "ATL"})));
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"ATL", "JFK"})));
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"ATL", "SFO"})));
//
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"JFK", "KUL"})));
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"JFK", "NRT"})));
//    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"NRT", "JFK"})));

    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"EZE", "AXA"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"TIA", "ANU"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"ANU", "JFK"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"JFK", "ANU"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"ANU", "EZE"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"TIA", "ANU"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"AXA", "TIA"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"TIA", "JFK"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"ANU", "TIA"})));
    tkts.add(new ArrayList<>(Arrays.asList(new String[]{"JFK", "TIA"})));

    List<String> res = findItinerary(tkts);
    System.out.println(res);
  }
}
