/**
 * provides a common naming for what betting should be able to do
 * @author Drew Walter
 * @version 1.0
 */
public interface Betting {
    ///placing the bet
    void bet(int betAmount);
    ///payout the bet
    void payout(int payoutRatio);
}
