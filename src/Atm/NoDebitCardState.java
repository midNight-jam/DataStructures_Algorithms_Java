package Atm;

/**
 * Created by Jayam on 3/4/2017.
 */
public class NoDebitCardState implements AtmState {
  private ATM machine;

  NoDebitCardState(ATM mac) {
    this.machine = mac;
  }

  @Override
  public void insertDebitCard() {
    System.out.println("debit card inserted succesfully");
    machine.setState(machine.getHasDebitCardState());
  }

  @Override
  public void ejectDebitCard() {
    System.out.println("Cannot eject, no debit card");
  }

  @Override
  public void enterPrintAndWithDrawMoney() {
    System.out.println("Cannot Enter pin, no debit card");
  }
}