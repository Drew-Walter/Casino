import java.util.ArrayList;
import java.util.List;

/**
 * A seat specifically for the Blackjack game
 * @author Drew Walter
 * @version 1.0
 */
public class BlackjackSeat extends Seat{
    ///cards held by the seat
    private List<Card> cardsHeld;

    /**
     * these seats are constructed before players arrive
     */
    public BlackjackSeat(){
        this(null);
    }

    /**
     * these seats are constructed with a player
     * @param player the player to put in the seat
     */
    public BlackjackSeat(Player player){
        super(player);
        cardsHeld = new ArrayList<>();
    }

    /**
     * adds a card to the seats cards
     * @param card the card being added
     */
    public void addCard(Card card){
        cardsHeld.add(card);
    }

    /**
     * removes all cards from the seat
     */
    public void removeAllCards(){
        cardsHeld.clear();
    }
}
