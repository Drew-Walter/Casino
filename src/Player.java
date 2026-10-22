import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Allows creation of Players which contain chips and ability to play games
 * @author Drew Walter
 * @version 1.4
 */
public class Player {
    ///used to give player id
    private static int playersCreated = 0;
    ///used to identify a player
    private final int playerID;
    ///the name of the player
    private String name;
    ///the stack that the player holds
    private Stack stack;
    ///stores the game that they are playing
    private GameOptions currentlyPlaying = GameOptions.NOTHING;
    ///stores the object that is running the game
    private Game game = null;


    ///default constructor to have a super default player
    public Player(){
        this("default player");
    }

    ///constructor to have default number of chips
    public Player(String name){
        this(name, Stack.DEFAULT_STACK_SIZE);
    }

    ///constructor to specify name and number of chips
    public Player(String name, int numberOfChips){
        this.name = name;
        this.stack = new Stack(numberOfChips);
        this.playerID = playersCreated++;
        System.out.println("Welcome to the casino " + this.name + "!");
    }

    ///{@return the current game being played}
    public String getCurrentGame(){
        return currentlyPlaying.toString();
    }

    /**
     * sets the game that is being played and launches that game
     * @param gameToPlay the game that wants to be played
     */
    public void play(GameOptions gameToPlay){
        currentlyPlaying = gameToPlay; //they are playing the game
        //determine which game is going to be getting played
        switch (currentlyPlaying){
            case BLACKJACK:
                createBlackjackGame();
                break;
            default:
                throw new IllegalStateException("Unknown game type");
        }
        game.play(); //start up the game
        game.removePlayer(this); //remove the player when done playing
        currentlyPlaying = GameOptions.NOTHING; //they have left the game and are playing nothing again
    }

    /**
     * places a bet of the specified amount
     * @param betAmount the amount to bet
     */
    public void bet(int betAmount){
        stack.bet(betAmount);
    }

    /**
     * pays out the bet for the specified amount
     * @param payoutRatio the ratio to payout, see Stack for details
     */
    public void payout(int payoutRatio){
        stack.payout(payoutRatio);
    }


    /**
     * creates the game of blackjack
     */
    private void createBlackjackGame(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {
            System.out.println("How many decks? ");
            try {
                this.game = new Blackjack(scanner.nextInt()); //this will throw exceptions
                this.game.addPlayer(this); //add player to game
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.\nTry again.");
            } catch (IllegalArgumentException e){
                System.out.println("Number of decks chosen is invalid.\nTry again.");
            }
        }
    }

    /**
     * {@return the name of the player}
     */
    public String getName(){
        return name;
    }

    /**
     * {@return the playerID of the player}
     */
    public int getPlayerID(){
        return playerID;
    }

    /**
     * determines if two objects are equal
     * @param obj   the reference object with which to compare.
     * @return true if they share id numbers, false if they don't
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Player other = (Player) obj;

        return this.playerID == other.playerID;
    }
    ///{@return details about the player}
    @Override
    public String toString(){
        return (name + " holds " + stack.getNumberOfChips() + " chips");
    }
}
