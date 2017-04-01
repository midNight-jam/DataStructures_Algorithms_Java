package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Jayam on 4/1/2017.
 */
public class SerializeEmployee {
  public static void main(String[] args) {
    Employee emp = new Employee();
    emp.age = 23;
    emp.name = "Nobby";
    try {
      FileOutputStream fout = new FileOutputStream("employee.ser");
      ObjectOutputStream objOut = new ObjectOutputStream(fout);
      objOut.writeObject(emp);
      objOut.close();
      System.out.println("Serialized in ");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
