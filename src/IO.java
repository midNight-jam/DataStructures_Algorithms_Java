import java.io.*;

/**
 * Created by Jayam on 3/30/2017.
 */
public class IO {

  public static void main(String[] args) {
    String name = "D:\\_Darkspace\\GIT\\hyperLC\\src\\some.txt";
    String nameCopy = "D:\\_Darkspace\\GIT\\hyperLC\\src\\someCopy.txt";
    BufferedReader input = null;
    BufferedWriter output = null;
    try {
      input = new BufferedReader(new FileReader(name));
      output = new BufferedWriter(new FileWriter(nameCopy));

      String line;
      line = input.readLine();
      while (line != null) {
        System.out.println(line);
        output.write(line);
        output.newLine();
        line = input.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (input != null) input.close();
        if (output != null) output.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Done...");
  }
}