package Atm;

/**
 * Created by Jayam on 3/4/2017.
 */
public class HasDebitCardState implements AtmState {
  private ATM machine;

  HasDebitCardState(ATM mac) {
    this.machine = mac;
  }

  @Override
  public void insertDebitCard() {
    System.out.println("Card already inserted, cannot insert again");
  }

  @Override
  public void ejectDebitCard() {
    System.out.println("Card ejected");
    machine.setState(machine.getNoDebitCardState());
  }

  @Override
  public void enterPrintAndWithDrawMoney() {
    System.out.println("Pin number is correct, dispensing money");
  }
}