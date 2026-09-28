/**
 * used to easily store rank value of a card and value for ordering
 * @author Drew Walter
 * @version 1.0
 */
public enum Rank {

    /** Two, the lowest-valued rank. */
    TWO(2),

    /** Three. */
    THREE(3),

    /** Four. */
    FOUR(4),

    /** Five. */
    FIVE(5),

    /** Six. */
    SIX(6),

    /** Seven. */
    SEVEN(7),

    /** Eight. */
    EIGHT(8),

    /** Nine. */
    NINE(9),

    /** Ten. */
    TEN(10),

    /** Jack. */
    JACK(11),

    /** Queen. */
    QUEEN(12),

    /** King. */
    KING(13),

    /** Ace, the highest-valued rank. */
    ACE(14);

    /** The comparison value of this rank. */
    private final int value;

    /**
     * Creates a rank with the specified comparison value.
     *
     * @param value the value used when comparing ranks
     */
    private Rank(int value) {
        this.value = value;
    }

    ///{@return the rank's comparison value}
    public int getValue() {
        return value;
    }
}