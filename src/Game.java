/**
 * Abstract class to allow for games to have common functionality for polymorphic behavior
 * @author Drew Walter
 * @version 1.0
 */
public abstract class Game implements Playable {
    ///all games should be able to be played
    @Override
    public abstract void play();

    ///all games should be able to add players
    public abstract void addPlayer(Player player);
    ///all games should be able to remove players
    public abstract void removePlayer(Player player);
}
