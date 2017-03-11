package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jayam on 3/9/2017.
 */
public class InsiderTrader {
  private static class Person {
    int day;
    String name;
    String operation;
    int quantity;

    Person(int d, String n, String ope, int amt) {
      day = d;
      name = n;
      operation = ope;
      quantity = amt;
    }

    @Override
    public String toString() {
      return day + " " + name + " " + operation + " " + quantity;
    }
  }

  public static void insiderTrader(List<String> arr) {
    String[] line;
    List<Person> persons = new ArrayList<>();
    List<Person> fraudPersons = new ArrayList<>();
    int prevamount;
    int day, amount;
    prevamount = amount = day = 0;
    for (String s : arr) {
      line = s.split("\\|");

      if (line.length == 2) {
        prevamount = amount;
        day = Integer.parseInt(line[0]);
        amount = Integer.parseInt(line[1]);
        int diff = amount - prevamount;
        while (persons.size() > 0) {
          Person pers = persons.remove(0);
          if (pers.day - day <= 3) {
            int absAmount = pers.quantity * diff;
            if (pers.operation.length() == 4) // SELL operation
              absAmount = Math.abs(absAmount);
            if (absAmount >= 500000)
              fraudPersons.add(pers);

          }
        }
        System.out.println("This is just quantity " + Arrays.toString(line));
      } else {
        int d = Integer.parseInt(line[0]);
        String name = line[1];
        String operation = line[2];
        int peramount = Integer.parseInt(line[3]);
        Person p = new Person(d, name, operation, peramount);
        persons.add(p);
        System.out.println("This is data " + Arrays.toString(line) + " : " + line.length);
      }
    }
    for (Person fp : fraudPersons)
      System.out.println(fp.day + "|" + fp.name);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> all = new ArrayList<>();
    int len = Integer.parseInt(sc.next());
    while (len-- >= 0)
      all.add(sc.nextLine());

    all.remove(0);
    System.out.println(all);
    insiderTrader(all);
  }
}