/**
 * Allows the creation of a seat at a game that a player will take
 * @author Drew Walter
 * @version 1.0
 */
public abstract class Seat {
    ///holds what player is in the seat
    private Player playerSeated;

    /**
     * constructs a seat with the player already in it
     * @param player the player to be seated there
     */
    public Seat(Player player){
        this.playerSeated = player;
    }

    /**
     * initializes a null player into the seat
     */
    public Seat(){
        //default behavior holds no player
        this.playerSeated = null;
    }

    /**
     * removes the player from current seat
     */
    public void removePlayerFromSeat(){
        this.playerSeated = null;
    }

    /**
     * adds a player to the seat if open
     * @param player the player to put in the seat
     */
    public void addPlayerToSeat(Player player){
        if(isSeatEmpty()){
            playerSeated = player;
        } else{
            throw new IllegalStateException(playerSeated.getName() + " is already seated here");
        }
    }

    /**
     * {@return if the seat is currently empty}
     */
    public boolean isSeatEmpty(){
        return playerSeated == null;
    }
}
