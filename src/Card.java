/**
 * Stores the values associated with a card
 * @author Drew Walter
 * @version 1.2
 */
public class Card implements Comparable<Card> {

    ///store the rank of the card
    private final Rank rank;
    ///store the suit of the card
    private final Suit suit;

    /**
     * construct a card with a given rank and suit
     * @param rank face value of the card
     * @param suit suit of the card
     */
    public Card(Rank rank, Suit suit) throws IllegalArgumentException{
        if (rank == null || suit == null) {
            throw new IllegalArgumentException("Rank and/or suit cannot be null");
        }

        this.rank = rank;
        this.suit = suit;
    }

    ///{@return the rank value}
    public Rank getRank() {
        return rank;
    }

    ///{@return the suit value}
    public Suit getSuit() {
        return suit;
    }


    /**
     * compare two card objects to each other to allow an ordering
     * @param other the object to be compared.
     * @return 0 if this is equal to other, 1 if this is larger, -1 if this is smaller
     */
    @Override
    public int compareTo(Card other) {
        // Compare rank first
        int rankComparison =
                Integer.compare(this.rank.getValue(), other.rank.getValue());

        if (rankComparison != 0) {
            return rankComparison;
        }

        // Same rank, so compare suit
        return Integer.compare(this.suit.getValue(), other.suit.getValue());
    }

    ///{@return formatted string of the card}
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    /**
     * determines if two cards are equal to each other
     * @param obj   the reference object with which to compare.
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Card)) {
            return false;
        }

        Card other = (Card) obj;

        return rank == other.rank && suit == other.suit;
    }

    ///{@return a consistent hashcode value}
    @Override
    public int hashCode() {
        return 31 * rank.hashCode() + suit.hashCode();
    }
}
