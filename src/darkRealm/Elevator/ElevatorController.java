package darkRealm.Elevator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jayam on 3/3/2017.
 */
public class ElevatorController {
  /* Responsibility of controller to load, unload people into elevator  and to move elevator to specific floor*/
  private static final int floors = 5;
  private static final int capacity = 8;
  private static final int delay = 500;

  private int elevatorFloor;
  private int clockTicks;
  private ArrayList<ArrayList<Integer>> waitingPeoples;
  private ElevatorAlgorithm ealg;

  ElevatorController(ElevatorAlgorithm ea) {
    elevatorFloor = 0;
    clockTicks = 0;
    waitingPeoples = new ArrayList<>();
    for (int i = 0; i < floors; i++)
      waitingPeoples.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
    ealg = ea;
    ea.setController(this);
  }

  public void run() {
    while (getTotalWaitingPeople() > 0)
      ealg.move();
  }

  public void moveToFloor(int f) {
    if (f > floors) f = floors;
    if (f < 0) f = 0;

    int direction = f > elevatorFloor ? 1 : -1;
    while (elevatorFloor != f) {
      elevatorFloor += direction;
      incrementClock();
      addDelay(delay);
      System.out.println(" elevetor moving ... " + elevatorFloor);
    }
  }

  private void addDelay(int n) {
    try {
      Thread.sleep(n);
    } catch (InterruptedException e) {
      System.out.println("Some thing wrong with Elevator");
    }
  }

  private void incrementClock() {
    clockTicks++;
  }

  public ArrayList<ArrayList<Integer>> getAllPeoples() {
    return waitingPeoples;
  }

  public int getTotalWaitingPeople() {
    int total = 0;
    for (int i = 0; i < waitingPeoples.size(); i++)
      total += waitingPeoples.get(i).size();
    return total;
  }

  public int getPeopleAtFloor(int i) {
    return waitingPeoples.get(i).size();
  }

  public int getMinFloor() {
    return 0;
  }

  public int getMaxFloor() {
    return floors;
  }

  public int getCurrentFloor() {
    return elevatorFloor;
  }
}