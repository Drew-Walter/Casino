/**
 * Stack is an object to keep track of the chip counts and transactions with chips
 * Only 1 bet can be placed from a stack at a time
 * @author Drew Walter
 * @version 1.0
 */
public class Stack {
    ///default size of a stack
    private static final int DEFAULT_STACK_SIZE = 100;

    ///how many chips are currently held
    private int numberOfChips;
    ///the number of chips being bet currently
    private int betAmount = 0;

    /**
     * default constructor to create a stack with default values
     */
    public Stack(){
        this(DEFAULT_STACK_SIZE);
    }

    /**
     * constructor to create a stack with a specified number of chips
     * @param numberOfChips how many chips are in the stack
     * @throws IllegalArgumentException stack size is not a valid number
     */
    public Stack(int numberOfChips) throws IllegalArgumentException{
        if(isValidChipAmount(numberOfChips)){
            this.numberOfChips = numberOfChips;
        } else{
            throw new IllegalArgumentException(numberOfChips + " is an invalid stack size");
        }
    }

    /**
     * helper method for constructors to ensure stack size is valid
     * @param chipAmount how large of a stack is wanting to be made
     * @return true if the stack size is allowed
     */
    private static boolean isValidChipAmount(int chipAmount){
        return chipAmount >= 0;
    }


    /**
     * Places a bet by modifying the numberOfChips and betAmount values
     * @param betAmount the amount of chips being bet
     * @throws IllegalArgumentException the bet amount is invalid or a second attempt at a bet
     */
    public void bet(int betAmount) throws IllegalArgumentException{
        if(!isValidBet(betAmount)) {
            throw new IllegalArgumentException(betAmount + " is an invalid bet amount");
        }
        if(this.betAmount != 0) {
            throw new IllegalArgumentException("A bet is already placed");
        }
        this.betAmount += betAmount;
        this.numberOfChips -= betAmount;
    }


    /**
     * helper method to ensure that a bet is the valid value
     * @param betAmount the amount wanting to be bet
     * @return true if the bet is allowed
     */
    private boolean isValidBet(int betAmount) {
        return betAmount > 0 && betAmount <= this.numberOfChips;
    }

    /**
     * add a specified number of chips to the Stack
     * @param addAmount the amount of chips that are being added to the stack
     * @throws IllegalArgumentException if the add amount is invalid
     */
    public void add(int addAmount) throws IllegalArgumentException{
        if(!isValidChipAmount(addAmount)){
            throw new IllegalArgumentException(addAmount + " is an invalid amount to add");
        }
        numberOfChips += addAmount;
    }


    /**
     * payout the stack by whatever ratio is provided
     * 1 is a push
     * 0 is a loss
     * 2 is bet in bet out (200 chips wins back the bet and 200 more)
     * 2.2 is a 6:5 payout
     * 2.5 is a 3:2 payout
     * @param payoutRatio the ratio of payout that should be given
     * @throws IllegalArgumentException if payoutRatio is invalid
     */
    public void payout(int payoutRatio) throws IllegalArgumentException{
        if(!isValidPayout(payoutRatio)) {
            throw new IllegalArgumentException(payoutRatio + " is an invalid payoutRatio");
        }
        numberOfChips = betAmount *= payoutRatio;
        betAmount = 0;

    }

    /**
     * ensure that the payout is always positive values or 0 if it's a loss
     * @param payoutRatio number to multiply to the amount of chips bet
     */
    private static boolean isValidPayout(int payoutRatio){
        return payoutRatio >= 0;
    }


    ///{@return the formatted string for the current stack}
    @Override
    public String toString(){
        return ("Stack has: " + numberOfChips + " chips\nCurrent bet is: " + betAmount + " chips");
    }
}
