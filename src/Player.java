import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Allows creation of Players which contain chips and ability to play games
 * @author Drew Walter
 * @version 1.5
 */
public class Player implements Betting{
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
                joinBlackjackGame();
                break;
            default:
                currentlyPlaying = GameOptions.NOTHING; //invalid should give no game if caught
                throw new IllegalStateException("Unknown game type");
        }

        //start up the game since the scope of this is only 1 player playing
        //this line would be an issue once there is multiple people
        //but the game should be designed to deal with it still, just the entry point is different
        game.play();

        //game done, cleanup
        game.removePlayer(this); //remove the player when done playing
        game = null; //no longer in that game
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
    private void joinBlackjackGame(){
        this.game = CasinoDriver.blackjacks.get(0); //join the first one for now
        game.addPlayer(this); //puts them in line to play
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

        return this.playerID == other.playerID; //id is unique identifier
    }

    ///{@return the hashcode for the player}
    @Override
    public int hashCode(){
        return playerID * 31;
    }
    
    ///{@return details about the player}
    @Override
    public String toString(){
        return (name + " holds " + stack.getNumberOfChips() + " chips");
    }
}
