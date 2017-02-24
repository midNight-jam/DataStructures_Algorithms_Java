package darkRealm.Machine;

import java.util.List;

/**
 * Created by Jayam on 2/23/2017.
 */
public interface VendingMachine {
  public long selectItemAndGetPrice(Item item);
  public void insertCoin(Coin coin);
  public List<Coin> refund();
  public Bucket<Item, List<Coin>> collectItemAndChange();
  public void reset();
}
