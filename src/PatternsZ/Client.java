package PatternsZ;

import PatternsZ.Adapter.Adapter;
import PatternsZ.Adapter.Target;
import PatternsZ.ChainOfResponsibility.ConcreteHandler1;
import PatternsZ.ChainOfResponsibility.ConcreteHandler2;
import PatternsZ.ChainOfResponsibility.Handler;
import PatternsZ.Command.Menu;
import PatternsZ.Composite.Composite;
import PatternsZ.Composite.Leaf;
import PatternsZ.Decorator.Component;
import PatternsZ.Decorator.ConcreteComponent;
import PatternsZ.Decorator.DecoratorA;
import PatternsZ.Decorator.DecoratorB;
import PatternsZ.Factory.HyundaiFactory;
import PatternsZ.Factory.TeslaFactory;
import PatternsZ.Factory.VolvoFactory;
import PatternsZ.Iterator.ConcreteAggregate;
import PatternsZ.Iterator.Iterator;
import PatternsZ.Observer.*;
import PatternsZ.Proxy.AccessProxy;
import PatternsZ.Proxy.CachingProxy;
import PatternsZ.Proxy.SubjectProxy;
import PatternsZ.Singleton.Singleton;
import PatternsZ.Startegy.DataSet;
import PatternsZ.Startegy.StrategyA;
import PatternsZ.Startegy.StrategyB;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Client {

  public void testIterator() {
    ConcreteAggregate cag = new ConcreteAggregate();
    cag.fetchData();
    Iterator it = cag.createIterator();
    while (!it.isDone()) {
      System.out.println(" D : " + it.currentItem());
      it.next();
    }
  }

  public void testProxy() {
    SubjectProxy accessProx = new AccessProxy();
    SubjectProxy cacheProx = new CachingProxy();
    accessProx.writeData("9876", "some data");
    System.out.println(cacheProx.readData("9876"));

    cacheProx.writeData("12345", "more data");
    System.out.println(cacheProx.readData("9876"));
  }

  public void testCommand() {
    Menu menu = new Menu();
    menu.runSetup();
    menu.selectMenuItem("GoodBye");
    menu.selectMenuItem("Hello");
  }

  public void testStrategy() {
    DataSet ds = new DataSet(new int[]{9, 7, 2, 8, 1, 7});
    ds.showData();
    ds.doOperation();
    ds.changeStrategy(new StrategyA());
    ds.doOperation();
    ds.showData();

    ds.changeStrategy(new StrategyB());
    ds.doOperation();
    ds.showData();

  }

  public void testObserver() {
    ConcreteSubject subj = new TheEconomy();
    ConcreteObserver ob1 = new Optimist(subj);
    ConcreteObserver ob2 = new Pessimist(subj);

    subj.attach(ob1);
    subj.attach(ob2);
    subj.setState("Price of gas 50$/gallon");
    ob1.showState();
    ob2.showState();


    subj.setState("Ipad is out");
    ob1.showState();
    ob2.showState();

    subj.setState("Nothing");
    ob1.showState();
    ob2.showState();

  }

  public void testFactory() {
    TeslaFactory tf = new TeslaFactory();
    tf.buildOrder();
    HyundaiFactory hf = new HyundaiFactory();
    hf.buildOrder();
    VolvoFactory vf = new VolvoFactory();
    vf.buildOrder();
  }

  public void testChainOfResponsibility() {
    Handler h1 = new ConcreteHandler1();
    Handler h2 = new ConcreteHandler2();
    h1.setSuccessor(h2);
    h1.handleRequest("CH2");
    h1.handleRequest("CH1");
  }

  public void testAdapterPattern() {
    Target target = new Adapter();
    target.sayHello();
  }

  public void testSingletonPattern() {
    Singleton inst = Singleton.getInstance();
    System.out.println(inst);
  }

  public void testDecoratorPattern() {
    Component comp = new DecoratorB(new DecoratorA(new ConcreteComponent()));
    System.out.println(comp.operation());
  }

  public void testCompositePattern() {
    PatternsZ.Composite.Component comp = new Composite("Root");
    PatternsZ.Composite.Component l1 = new Leaf("Leaf1");
    PatternsZ.Composite.Component l2 = new Leaf("Leaf2");
    comp.addChild(l1);
    comp.addChild(l2);
    PatternsZ.Composite.Component comp2 = new Composite("Root2");
    PatternsZ.Composite.Component l3 = new Leaf("Leaf3");
    comp2.addChild(l3);
    comp2.addChild(comp);
    comp2.operation();
  }

  public static void main(String[] args) {
    Client client = new Client();
//    client.testAdapterPattern();
//    client.testSingletonPattern();
//    client.testDecoratorPattern();
//    client.testCompositePattern();
//    client.testChainOfResponsibility();
//    client.testFactory();
//    client.testObserver();
//    client.testStrategy();
//    client.testCommand();
//    client.testProxy();
    client.testIterator();
  }
}