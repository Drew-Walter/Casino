/**
 * Allows the creation of a seat at a game that a player will take
 * each game should have a specialized version of this class for any non-generic behavior
 * @author Drew Walter
 * @version 1.1
 */
public abstract class Seat implements Betting{
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
     * places a bet for the player seated
     * @param betAmount the amount to bet
     */
    public void bet(int betAmount){
        playerSeated.bet(betAmount);
    }

    /**
     * pays out the bet for the specified amount
     * @param payoutRatio the ratio to payout, see Stack for details
     */
    public void payout(int payoutRatio){
        playerSeated.payout(payoutRatio);
    }

    /**
     * {@return the seated player}
     */
    public Player getPlayer(){
        return playerSeated;
    }

    /**
     * {@return if the seat is currently empty}
     */
    public boolean isSeatEmpty(){
        return playerSeated == null;
    }
}
