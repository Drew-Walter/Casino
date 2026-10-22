/**
 * Stores the game of blackjack that can be played by only 1 player
 * @author Drew Walter
 * @version 1.2
 */
public class Blackjack extends Game {
    ///maximum size that a shoe can be
    private static final int MAX_SHOE_SIZE = 8;
    ///minimum size that a shoe can be
    private static final int MIN_SHOE_SIZE = 2;
    ///the number of seats a game has
    private static final int NUMBER_OF_SEATS = 6;
    ///how many decks are being used
    private final int numberOfDecks;
    ///all seats that can have players
    private final BlackjackSeat[] seats;

    /**
     * construct the blackjack object
     * @param numberOfDecks how large the shoe should be for this game
     * @throws IllegalArgumentException for invalid number of decks
     */
    public Blackjack(int numberOfDecks) throws IllegalArgumentException{
        checkValidDecks(numberOfDecks);
        this.numberOfDecks = numberOfDecks;
        seats = new BlackjackSeat[NUMBER_OF_SEATS];
        fillSeats(); //initialize seat values
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
        if(!isRoomAtTable()){
            throw new IllegalStateException("This table is out of room");
        }
        for(int i = 0; i < seats.length; i++){ //find an empty seat
            if(seats[i].isSeatEmpty()){
                seats[i].addPlayerToSeat(player); //add them
            }
        }
    }

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
        //TODO: implement
    }

    ///{@return the current game state}
    @Override
    public String toString(){
        //TODO: implement
        return null;
    }
}
