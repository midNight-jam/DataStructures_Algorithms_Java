package darkRealm;

import java.util.Random;

/**
 * Created by Jayam on 3/3/2017.
 */
public class CardDeck {
  final int capacity = 52;
  Card[] deck;

  CardDeck() {
    deck = new Card[capacity];
    int suiteLen = Suit.values().length;
    int rankLen = Rank.values().length;
    Suit[] allSuits = Suit.values();
    Rank[] allRanks = Rank.values();
    int index = 0;
    for (int i = 0; i < suiteLen; i++) {
      for (int j = 0; j < rankLen; j++) {
        deck[index++] = new Card(allSuits[i], allRanks[j]);
      }
    }
  }

  public void shuffle() {
    Random rand = new Random();
    for (int i = 0; i < capacity; i++) {
//      int ni = (int) (Math.random() * (capacity - i));
      int ni = rand.nextInt(capacity - i) + i;
      Card temp = deck[ni];
      deck[ni] = deck[i];
      deck[i] = temp;
    }
  }

  public void printDeck() {
    for (int i = 0; i < capacity; i++)
      System.out.println(deck[i]);
  }

  public class Card {
    Suit suit;
    Rank rank;

    Card(Suit s, Rank r) {
      suit = s;
      rank = r;
    }

    @Override
    public String toString() {
      return suit.toString() + " - " + rank.toString();
    }
  }

  public enum Suit {
    Clubs,
    Diamonds,
    Spade,
    Hearts
  }

  public enum Rank {
    Ace(1),
    King(13),
    Queen(12),
    Jack(11),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10);
    private int value;

    Rank(int v) {
      value = v;
    }

    public int value() {
      return value;
    }

  }

  public static void main(String[] args) {
    CardDeck cd = new CardDeck();
    cd.printDeck();
    System.out.println("-----------------------------------------------");
    cd.shuffle();
    cd.printDeck();
  }
}