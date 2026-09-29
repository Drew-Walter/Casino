/**
 * stores all game options that the player has to play
 * @author Drew Walter
 * @version 1.0
 */
public enum GameOptions {
    NOTHING("Nothing"),
    BLACKJACK("Blackjack");

    ///the String version of the game being played
    private String currentlyPlaying;

    /**
     * constructs and stores the value for the enum
     * @param gamePlaying the String version of the current game
     */
    private GameOptions(String gamePlaying){
        currentlyPlaying = gamePlaying;
    }

    ///{@return the game currently being played}
    @Override
    public String toString(){
        return currentlyPlaying;
    }
}
