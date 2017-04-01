package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Jayam on 3/31/2017.
 */
public class DeSerializeEmployee {
  public static void main(String[] args) {
    try{
      FileInputStream fin = new FileInputStream("employee.ser");
      ObjectInputStream objIn = new ObjectInputStream(fin);
      Employee emp = (Employee) objIn.readObject(); //InvalidClassException if serlizationID doesnt matches
      System.out.println(emp);
      objIn.close();
      fin.close();
    }
    catch (IOException e){
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
