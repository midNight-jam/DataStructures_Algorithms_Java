import java.util.*;

/**
 * Created by Jayam on 3/30/2017.
 */
public class Iterator {

  public static void main(String[] args) {
    List<String> phones = new ArrayList<String>(Arrays.asList(new String[]{"moto", "nokia", "lg", "mi", "apple"}));
    System.out.println("Phones : " + phones);
    for (String ph : phones)
      if (ph.startsWith("ap")) ;
    //phones.remove(ph);  // will throw a ConcurrentModificationException

    for (java.util.Iterator<String> itr = phones.listIterator(); itr.hasNext(); ) {
      String phone = itr.next();
      if (phone.startsWith("ap"))
        itr.remove();
    }
    System.out.println("Phones : " + phones);

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.add(3);
    minHeap.add(1);
    minHeap.add(4);
    minHeap.add(2);
    minHeap.add(5);
    System.out.println(minHeap.poll());
    System.out.println(minHeap);

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    maxHeap.add(3);
    maxHeap.add(1);
    maxHeap.add(4);
    maxHeap.add(2);
    maxHeap.add(5);
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap);

  }
}