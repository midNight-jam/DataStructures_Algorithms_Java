package Atm;

/**
 * Created by Jayam on 3/4/2017.
 */
public class ATM implements AtmState {
  AtmState state;
  AtmState noDebitCardState;
  AtmState hasDebitCardState;

  ATM() {
    noDebitCardState = new NoDebitCardState(this);
    hasDebitCardState = new HasDebitCardState(this);
    state = noDebitCardState;
  }

  @Override
  public void insertDebitCard() {
    state.insertDebitCard();
  }

  @Override
  public void ejectDebitCard() {
    state.ejectDebitCard();
  }

  @Override
  public void enterPrintAndWithDrawMoney() {
    state.enterPrintAndWithDrawMoney();
  }

  public void setState(AtmState state) {
    this.state = state;
  }

  public AtmState getState() {
    return state;
  }

  public AtmState getNoDebitCardState() {
    return noDebitCardState;
  }

  public AtmState getHasDebitCardState() {
    return hasDebitCardState;
  }
}