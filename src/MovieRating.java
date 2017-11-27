import java.util.*;

public class MovieRating {

  double rating;
  List<MovieRating> connections;
  int id;
  double dist;

  MovieRating(int i, double r) {
    id = i;
    rating = r;
    connections = new ArrayList<>();
  }


  public List<MovieRating> getClosest(MovieRating root, int k) {
    Set<Integer> visited = new HashSet<>();
    Queue<MovieRating> maxHeap = new PriorityQueue<>(new Comparator<MovieRating>() {
      @Override
      public int compare(MovieRating o1, MovieRating o2) {
        double dist1 = Math.abs(o1.rating - root.rating);
        double dist2 = Math.abs(o2.rating - root.rating);
        return Double.compare(dist2, dist1);
      }
    });

    Queue<MovieRating> queue = new LinkedList<>();
    queue.offer(this);
    while (!queue.isEmpty()) {
      MovieRating trav = queue.poll();
      if (visited.contains(trav.id)) continue;
      visited.add(trav.id);
      maxHeap.offer(trav);
      // as we want to get closest distance, rather than creating min heap, we do the opposite, we create a max heap
      // & whenever the maxheap size exceeds K, we are sure that the node at the root of the heap is definitely not going
      // to be in the nearest, bcoz this is a max heap and by definition this root node is at the farthest, thus drop
      while (maxHeap.size() > k + 1)  // k + 1 bcoz query movie is also in heap with dist 0.0
        maxHeap.poll();

      for (MovieRating m : trav.connections)
        queue.offer(m);
    }
    List<MovieRating> res = new ArrayList<>();
    while (maxHeap.size() > 0)
      res.add(maxHeap.poll());
    res.remove(res.size() - 1); // drop self
    // reverse the list as we did max heap
    Collections.reverse(res);
    return res;
  }


  public static void main(String[] args) {
    MovieRating root = new MovieRating(0, 3);

    MovieRating one = new MovieRating(1, 3.1);
    MovieRating two = new MovieRating(2, 3.5);
    MovieRating three = new MovieRating(3, 2.9);
    MovieRating four = new MovieRating(4, 3.6);

    root.connections.add(one);
    root.connections.add(two);

    one.connections.add(two);
    one.connections.add(three);
    one.connections.add(root);

    two.connections.add(root);
    two.connections.add(one);

    three.connections.add(one);
    three.connections.add(four);

    four.connections.add(three);

    List<MovieRating> res = root.getClosest(root, 3);
    for (MovieRating m : res)
      System.out.println(m.id + " - " + m.rating);
  }
}
