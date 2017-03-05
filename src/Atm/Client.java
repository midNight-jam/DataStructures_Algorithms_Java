package Atm;

/**
 * Created by Jayam on 3/4/2017.
 */
public class Client {
  public static void main(String[] args) {
    ATM atm = new ATM();
    atm.ejectDebitCard();
    atm.enterPrintAndWithDrawMoney();
    atm.insertDebitCard();
//    atm.ejectDebitCard();
    atm.enterPrintAndWithDrawMoney();
    atm.enterPrintAndWithDrawMoney();
  }
}
