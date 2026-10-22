import java.util.ArrayList;
import java.util.List;

/**
 * Entry point into the casino, holds the main method
 * @author Drew Walter
 * @version 1.1
 */
public class CasinoDriver {
    ///stores all blackjack games being held
    public static List<Blackjack> blackjacks = new ArrayList<>();
    ///constructor not needed, this is a namespace for the main method
    private CasinoDriver(){}

    /**
     * provides entry point into the program to start playing casino games
     * @param args takes a single argument, the player name
     */
    public static void main(String[] args) {
        populateGames();
        Player player = createPlayer(args, 0);
        player.play(GameOptions.BLACKJACK);
    }

    /**
     * creates a Player object from command line arguments
     * @param names the command line arguments containing names for players
     * @param indexToUseAsName the index in names being used
     * @return a Player with the specified name, if index unavailable the Player has default name
     */
    private static Player createPlayer(String[] names, int indexToUseAsName){
        Player player;
        if(names.length > indexToUseAsName) {
            player = new Player(names[indexToUseAsName]);
        } else{
            player = new Player();
        }
        return player;
    }

    /**
     * populate all static variables storing games
     */
    private static void populateGames(){
        populateBlackjack();
    }

    /**
     * create the blackjack game objects
     */
    private static void populateBlackjack(){
        blackjacks.add(new Blackjack(8));
    }
}
