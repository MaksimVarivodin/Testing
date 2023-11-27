import lombok.*;

@ToString
public class CashTerminal {
    private static final Integer A = 100;
    private static final Integer  B = 200;
    private static final  Integer  N = 20;
    public static final CredentialsException CARD_OR_PASSCODE_IS_NULL = new CredentialsException("Card or passcode is null.");
    public static final CredentialsException PASSCODE_IS_WRONG_LENGTH = new CredentialsException("Passcode is wrong length.");
    public static final CredentialsException AMOUNT_IS_NOT_DIVISIBLE_BY = new CredentialsException("Amount is not divisible by " + Math.min(A, B));
    public static final CashTerminalException REQUESTED_MONEY_AMOUNT_LESS_THAN_ZERO = new CashTerminalException("Money amount less than zero.");
    public static final CashTerminalException NOT_ENOUGH_MONEY_IN_CASH_TERMINAL = new CashTerminalException("Not enough money in cash terminal.");
    public static final CashTerminalException CASH_TERMINAL_OVERLOADED = new CashTerminalException("Not enough space in cash terminal.");

    private Integer amountOfA;
    private Integer amountOfB;

    public CashTerminal(Integer amountOfA, Integer amountOfB) throws CashTerminalException{
        if (amountOfA > N || amountOfA< 0)
            throw CASH_TERMINAL_OVERLOADED;
        if (amountOfB > N || amountOfB < 0)
            throw CASH_TERMINAL_OVERLOADED;
        this.amountOfA = amountOfA;
        this.amountOfB = amountOfB;
    }

    public CashTerminal() {
        this.amountOfA = 0;
        this.amountOfB = 0;
    }

    public boolean getMoney(Integer cardId, Integer passCode, Integer amount) throws CredentialsException, CashTerminalException {
        if (cardId == null || passCode == null){
            throw CARD_OR_PASSCODE_IS_NULL;
        }
        if(passCode.toString().length()!= 4){
            throw PASSCODE_IS_WRONG_LENGTH;
        }
        if (amount % Math.min(A, B) != 0){
            throw AMOUNT_IS_NOT_DIVISIBLE_BY;
        }
        if (amountOfA * A + amountOfB * B < amount){
            throw NOT_ENOUGH_MONEY_IN_CASH_TERMINAL;
        }
        if (amount < 0){
            throw REQUESTED_MONEY_AMOUNT_LESS_THAN_ZERO;
        }
        Integer resultB = amount /  B;
        Integer resultA = (amount - resultB*B )/  A;

        System.out.println("Terminal has banknotes of "+ A + "$ and " + B + "$.\n"+
                " You get "  + resultA  + " of " + A + "$ and " + resultB + " of " + B + "$.\n"+
                "In sum: " + amount + "$.\n"
        );
        amountOfA -= resultA;
        amountOfB -= resultB;
        return true;
    }
    public boolean putMoney(Integer amountOfA, Integer amountOfB) throws CashTerminalException {
        if (this.amountOfA+ amountOfA > N)
            throw CASH_TERMINAL_OVERLOADED;
        if (this.amountOfB + amountOfB > N)
            throw CASH_TERMINAL_OVERLOADED;
        this.amountOfA += amountOfA;
        this.amountOfB += amountOfB;
        return true;
    }
}
