package Serialization;

import java.io.Serializable;

/**
 * Created by Jayam on 4/1/2017.
 */
public class Employee implements Serializable {
  String name;
  transient int age;
  static int employeeCount = 99;

  private static final long serialVersionUID = 123456789l;

  @Override
  public String toString() {
    return " Name : " + name + " age : " + age;
  }
}