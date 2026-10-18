/**
 * Stores the game of blackjack that can be played by only 1 player
 * @author Drew Walter
 * @version 1.1
 */
public class Blackjack extends Game {
    ///maximum size that a shoe can be
    private final int MAX_SHOE_SIZE = 8;
    ///minimum size that a shoe can be
    private final int MIN_SHOE_SIZE = 2;
    ///how many decks are being used
    private final int numberOfDecks;

    /**
     * construct the blackjack object
     * @param numberOfDecks how large the shoe should be for this game
     * @throws IllegalArgumentException for invalid number of decks
     */
    public Blackjack(int numberOfDecks) throws IllegalArgumentException{
        checkValidDecks(numberOfDecks);
        this.numberOfDecks = numberOfDecks;
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

    ///play functionality
    @Override
    public void play() {
        //TODO: implement
    }
}
