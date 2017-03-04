package darkRealm.Elevator;

/**
 * Created by Jayam on 3/4/2017.
 */
public class TestElevator {

  public static void main(String[] args) {
    MaxWaitingFirst mwf = new MaxWaitingFirst();
    ElevatorController ectrl = new ElevatorController(mwf);
    ectrl.run();
  }
}
