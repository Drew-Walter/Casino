/**
 * Allows creation of Players which contain chips and ability to play games
 * @author Drew Walter
 * @version 1.1
 */
public class Player {
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
        this.name = name;
        this.stack = new Stack();
    }

    ///constructor to specify name and number of chips
    public Player(String name, int numberOfChips){
        this.name = name;
        this.stack = new Stack(numberOfChips);
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
                this.game = new Blackjack();
                break;
            default:
                throw new IllegalStateException("Unknown game type");
        }
        game.play(); //start up the game
        currentlyPlaying = GameOptions.NOTHING; //they have left the game and are playing nothing again
    }



    ///{@return details about the player}
    @Override
    public String toString(){
        return (name + " holds " + stack.getNumberOfChips() + " chips");
    }
}
