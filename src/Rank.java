/**
 * used to easily store rank value of a card and value for ordering
 * values are not directly tied to any game value and may need to be checked per game still
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

    ///{@return the string representation of the values}
    @Override
    public String toString(){
        switch(value){
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return ""; //should be unreachable
        }
    }
}