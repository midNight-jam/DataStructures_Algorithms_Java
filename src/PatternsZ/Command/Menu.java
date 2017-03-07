package PatternsZ.Command;

import java.util.HashMap;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Menu {
  HashMap<String, MenuItem> map;
  public Menu(){
    map = new HashMap<>();
  }

  public void addMenuItem(String key, MenuItem mi) {
    map.put(key, mi);
  }

  public void selectMenuItem(String key) {
    if (map.containsKey(key)){
      MenuItem cmd = map.get(key);
      cmd.invoke();
    }
    else
      System.out.println("No Such Menu");
  }

  public void runSetup() {
    ConcreteCommand sayHello = new ConcreteCommand();
    sayHello.setReceiver(new Receiver() {
      @Override
      public void doAction() {
        System.out.println("Hello!!!");
      }
    });
    ConcreteCommand sayGoodBye = new ConcreteCommand();
    sayGoodBye.setReceiver(new Receiver() {
      @Override
      public void doAction() {
        System.out.println("GoodBye!!!");
      }
    });
    MenuItem hello = new MenuItem();
    hello.setCommand(sayHello);

    MenuItem goodBye = new MenuItem();
    hello.setCommand(sayGoodBye);
    addMenuItem("Hello", hello);
    addMenuItem("GoodBye", goodBye);
  }
}
