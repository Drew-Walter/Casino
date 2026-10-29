import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Stores the game of blackjack that can be played by only 1 player
 * @author Drew Walter
 * @version 1.4
 */
public class Blackjack extends Game {
    ///maximum size that a shoe can be
    private static final int MAX_SHOE_SIZE = 8;
    ///minimum size that a shoe can be
    private static final int MIN_SHOE_SIZE = 2;
    ///the number of seats a game has
    private static final int NUMBER_OF_SEATS = 6;
    ///payout ratio for blackjack
    private static final double BLACKJACK_PAYOUT_RATIO = 2.5;
    ///payout for push ratio when a tie happens
    private static final int PUSH_PAYOUT_RATIO = 1;
    ///normal payout ratio
    private static final int NORMAL_PAYOUT_RATIO = 2;
    ///number of cards remaining to dictate a shuffle is needed
    private static final int CARDS_TO_DICTATE_SHUFFLE = 30;
    ///the shoe that all the cards are stored in
    private Deck shoe;
    ///all seats that can have players
    private final BlackjackSeat[] seats;
    ///players waiting to join blackjack, players can't leave the queue
    private final Queue<Player> playersWaitingForSeats;


    /**
     * construct the blackjack object
     * @param numberOfDecks how large the shoe should be for this game
     * @throws IllegalArgumentException for invalid number of decks
     */
    public Blackjack(int numberOfDecks) throws IllegalArgumentException{
        //create the deck
        checkValidDecks(numberOfDecks);
        this.shoe = new Deck(numberOfDecks);

        //create seating
        seats = new BlackjackSeat[NUMBER_OF_SEATS];
        fillSeats(); //initialize seat values
        playersWaitingForSeats = new ArrayDeque<>();
    }

    /**
     * checks if the number of decks is a valid value
     * @param numberOfDecks quantity of decks to check
     * @throws IllegalArgumentException if invalid number of decks
     */
    private void checkValidDecks(int numberOfDecks) throws IllegalArgumentException{
        if(numberOfDecks <= MIN_SHOE_SIZE || numberOfDecks > MAX_SHOE_SIZE){
            throw new IllegalArgumentException(numberOfDecks + " is an invalid shoe size");
        }
    }

    /**
     * fills all the seats with default seats
     */
    private void fillSeats(){
        for(int i = 0; i < seats.length; i++){
            seats[i] = new BlackjackSeat(); //all seats are initially empty
        }
    }

    /**
     * determines if there is an empty seat at the table
     * @return true if there is an empty seat, false otherwise
     */
    public boolean isRoomAtTable(){
        for(BlackjackSeat seat : seats){
            if(seat.isSeatEmpty()){ //empty seat found
                return true;
            }
        }
        return false;
    }

    /**
     * adds a player to the blackjack game
     * needs an empty seat to do so
     * @param player the player to add
     */
    @Override
    public void addPlayer(Player player){
        playersWaitingForSeats.add(player);
    }

    /**
     * takes people from the queue and adds them to any open seats
     */
    private void fillSeatsFromQueue(){
        for (BlackjackSeat seat : seats) { //find an empty seat
            if (seat.isSeatEmpty() && !playersWaitingForSeats.isEmpty()) { //empty spot and someone wants to take it
                seat.addPlayerToSeat(playersWaitingForSeats.poll()); //add them
            }
        }
    }

    /**
     * removes the specified player from seats
     * @param player the player to remove
     */
    @Override
    public void removePlayer(Player player){
        //find the seat that has the player we are using
        for(int i = 0; i < seats.length; i++){
            //comparing reference should also work, but this is stronger
            if(seats[i].getPlayer().equals(player)){
                seats[i].removePlayerFromSeat(); //remove the player, not the seat
            }
        }
    }

    ///play functionality
    @Override
    public void play() {
        fillSeatsFromQueue(); //fill seats when play is first called
        //TODO: implement
    }

    /**
     * {@return true if there are too few cards remaining and a shuffle is required}
     */
    private boolean isShuffleNeeded(){
        return shoe.size() < CARDS_TO_DICTATE_SHUFFLE;
    }

    ///{@return the current game state}
    @Override
    public String toString(){
        //TODO: implement
        return null;
    }
}
