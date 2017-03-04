package darkRealm.Elevator;

import java.util.ArrayList;

/**
 * Created by Jayam on 3/4/2017.
 */
public class MaxWaitingFirst implements ElevatorAlgorithm {
  /*Has the responsibility of moving the elevator up & down for transporting the people*/
  ElevatorController elevCtrl;

  @Override
  public void setController(ElevatorController ec) {
    elevCtrl = ec;
  }

  @Override
  public void move() {
    ArrayList<ArrayList<Integer>> waitingPeoples = elevCtrl.getAllPeoples();
    int maxFloor = 0;
    int maxPeople = 0;
    for (int i = elevCtrl.getMinFloor(); i < elevCtrl.getMaxFloor(); i++)
      if (elevCtrl.getPeopleAtFloor(i) > maxPeople) {
        maxPeople = elevCtrl.getPeopleAtFloor(i);
        maxFloor = i;
      }

    elevCtrl.moveToFloor(maxFloor);
    int served = waitingPeoples.get(maxFloor).remove(0); // drops the person at that floor
    System.out.println(" Served " + maxFloor + " people : " + served);
  }
}