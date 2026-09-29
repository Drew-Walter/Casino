/**
 * allows for the creation of a deck of cards of various sizing, useful for games played with multiple decks shuffled
 * a deck object should never be returned from a function
 * @author Drew Walter
 * @version 1.1
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ///stores the decks
    private ArrayList<Card> deck;
    ///stores how many decks are being used
    private final int numberOfDecks;
    ///default number of decks to generate
    private static final int DEFAULT_NUMBER_OF_DECKS = 1;

    /**
     * default constructor to create default number of decks
     */
    public Deck(){
        this(DEFAULT_NUMBER_OF_DECKS);
    }

    /**
     * constructor to generate specified number of decks
     * @param numberOfDecks how many decks should be stored
     */
    public Deck(int numberOfDecks) throws IllegalArgumentException {
        if (numberOfDecks <= 0) { //invalid value
            throw new IllegalArgumentException(
                    "Number of decks must be greater than zero");
        }

        this.deck = generateDeck(numberOfDecks); //store the value
        this.numberOfDecks = numberOfDecks;
    }

    /**
     * helper method to generate and hand back a newly generated and shuffled deck
     * @param numberOfDecks how many decks to store in the deck
     * @return the generated ArrayList of cards representing the deck
     */
    private static ArrayList<Card> generateDeck(int numberOfDecks){
        ArrayList<Card> generatedDeck = new ArrayList<>(numberOfDecks * 52); //create enough capacity

        for (int deck = 0; deck < numberOfDecks; deck++) { //for each deck needed
            for (Suit suit : Suit.values()) { //go through all suits
                for (Rank rank : Rank.values()) { //go through all values
                    generatedDeck.add(new Card(rank, suit));
                }
            }
        }

        Collections.shuffle(generatedDeck); //shuffle it
        return generatedDeck;
    }

    ///{@return the number of cards in the deck}
    public int size() {
        return deck.size();
    }

    ///{@return the number of decks being used}
    public int getNumberOfDecks(){
        return this.numberOfDecks;
    }

    /**
     * fully reshuffle the deck by generating an entire new deck
     */
    public void reShuffle() {
        deck = generateDeck(numberOfDecks);
    }

    /**
     * draw a card from the deck
     * @return the Card object drawn
     * @throws IllegalStateException from drawing from an empty deck
     */
    public Card draw() throws IllegalStateException {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Cannot draw from an empty deck");
        }

        return deck.removeLast(); //take the last element in the deck, simplifies logic to treat the end as the top of the deck
    }

    /**
     * modifies the deck by sorting it based on the cards
     */
    public void sort(){
        Collections.sort(deck);
    }

    ///{@return the number of cards remaining in the deck}
    @Override
    public String toString(){
        return ("There are " + size() + " cards remaining in the deck");
    }
}