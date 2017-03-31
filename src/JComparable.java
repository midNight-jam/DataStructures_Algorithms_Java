import java.util.*;

/**
 * Created by Jayam on 3/30/2017.
 */
public class JComparable implements Comparable {
  int age;
  String name;

  JComparable(int i, String s) {
    age = i;
    name = s;
  }

  @Override
  public int compareTo(Object o) {
    return this.age - ((JComparable) o).age;
  }

  @Override
  public String toString() {
    return String.format("{" + age + "}-{" + name + "}");
  }

  public static void main(String[] args) {
    List<JComparable> list = new ArrayList<>(Arrays.asList(new JComparable[]{
        new JComparable(2, "aa"),
        new JComparable(1, "cc"),
        new JComparable(3, "bb")
    }));

    Collections.sort(list);
    System.out.println(list);
    list.sort(new Comparator<JComparable>() {
      @Override
      public int compare(JComparable o1, JComparable o2) {
        return o2.age - o1.age;
      }
    });
    System.out.println(list);
  }
}