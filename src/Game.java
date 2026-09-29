/**
 * Abstract class to allow for games to have common functionality for polymorphic behavior
 * @author Drew Walter
 * @version 1.0
 */
public abstract class Game implements Playable {
    @Override
    public abstract void play();
}
