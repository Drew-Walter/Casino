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
    private int stackSize;
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
     * @param stackSize how many chips are in the stack
     * @throws IllegalArgumentException stack size is not a valid number
     */
    public Stack(int stackSize) throws IllegalArgumentException{
        if(isValidStackSize(stackSize)){
            this.stackSize = stackSize;
        } else{
            throw new IllegalArgumentException(stackSize + " is an invalid stack size");
        }
    }

    ///helper method for constructors to ensure stack size is valid
    private static boolean isValidStackSize(int stackSize){
        return stackSize >= 0;
    }
}
