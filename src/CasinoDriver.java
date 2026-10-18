/**
 * Entry point into the casino, holds the main method
 * @author Drew Walter
 * @version 1.0
 */
public class CasinoDriver {
    ///constructor not needed, this is a namespace for the main method
    private CasinoDriver(){}

    /**
     * provides entry point into the program to start playing casino games
     * @param args takes a single argument, the player name
     */
    public static void main(String[] args) {
        Player player = createPlayer(args, 0);
    }

    private static Player createPlayer(String[] names, int indexToUseAsName){
        Player player;
        if(names.length > indexToUseAsName) {
            player = new Player(names[indexToUseAsName]);
        } else{
            player = new Player();
        }
        return player;
    }
}
