/**
 * used to allow for easier understand of suit values
 * @author Drew Walter
 * @version 1.0
 */
public enum Suit {

    /** Clubs, the lowest-valued suit. */
    CLUBS(1),

    /** Diamonds, the second-lowest-valued suit. */
    DIAMONDS(2),

    /** Hearts, the second-highest-valued suit. */
    HEARTS(3),

    /** Spades, the highest-valued suit. */
    SPADES(4);

    /** The comparison value of this suit. */
    private final int value;

    ///{@param value the value used when comparing suits}
    private Suit(int value) {
        this.value = value;
    }

    ///{@return the suit's comparison value}
    public int getValue() {
        return value;
    }
}