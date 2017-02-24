package darkRealm.Machine;

/**
 * Created by Jayam on 2/23/2017.
 */
public class VendingMachineFactory {
  public static VendingMachine createVendingMachine() {
    return new VendingMachineImpl();
  }
}