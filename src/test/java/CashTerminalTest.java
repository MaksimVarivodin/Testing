import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashTerminalTest {
    ///TO_DO Число банкнот під час заповнення банкомату коректне.
    // TO_DO Число банкнот при заповненні банкомату більше максимально допустимого.
    // TO_DO На вхід у поля cartId , pin можуть надходити порожні рядки або значення null . як по одному, так і одночасно в обидва поля.
    // TO_DO У полі pin надійшло число символів, відмінне від 4.
    // TO_DO Кількість грошей не кратна m (перевірити на різних значеннях ).
    /* TO_DO Кількість грошей більша, ніж може видати банкомат. */
    /* TO_DO Кількість грошей є коректною.*/
    CashTerminal terminal;
    @Test
    public void normalAB() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
    }
    @Test
    public void badA(){
        assertThrows(CashTerminal.CASH_TERMINAL_OVERLOADED.getClass(), () -> {
            new CashTerminal(21, 15);
        });
    }
    @Test
    public void badB(){
        assertThrows(CashTerminal.CASH_TERMINAL_OVERLOADED.getClass(), () -> {
            new CashTerminal(15, 21);
        });
    }
    @Test
    public void badAB(){
        assertThrows(CashTerminal.CASH_TERMINAL_OVERLOADED.getClass(), () -> {
            new CashTerminal(21, 21);
        });
    }
    @Test
    public void normalCredentials() throws CredentialsException, CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertTrue(terminal.getMoney(1234, 1234, 1300));
    }
    @Test
    public void badCard() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.CARD_OR_PASSCODE_IS_NULL.getClass(),()->{terminal.getMoney(null, 1234, 1300);});
    }
    @Test
    public void badPassCode() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.CARD_OR_PASSCODE_IS_NULL.getClass(),()->{terminal.getMoney(1234, null, 1300);});
    }
    @Test
    public void badCredentials() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.CARD_OR_PASSCODE_IS_NULL.getClass(),()->{terminal.getMoney(null, null, 1300);});
    }
    @Test
    public void badPassCodeLength() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.PASSCODE_IS_WRONG_LENGTH.getClass(),()->{terminal.getMoney(1234, 123, 1300);});
    }
    @Test
    public void badAmount1301() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.AMOUNT_IS_NOT_DIVISIBLE_BY.getClass(),()->{terminal.getMoney(1234, 1234, 1301);});
    }
    @Test
    public void badAmountMinus1301() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.REQUESTED_MONEY_AMOUNT_TOO_SMALL.getClass(),()->{terminal.getMoney(1234, 1234, -1301);});
    }
    @Test
    public void badAmountZero() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertThrows(CashTerminal.REQUESTED_MONEY_AMOUNT_TOO_SMALL.getClass(),()->{terminal.getMoney(1234, 1234, 0);});
    }


    @Test
    public void tooBigAmount() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(1, 1));
        assertThrows(CashTerminal.NOT_ENOUGH_MONEY_IN_CASH_TERMINAL.getClass(),()->{terminal.getMoney(1234, 1234, 400);});
    }
    @Test
    public void normalAmount() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertTrue(terminal.getMoney(1234, 1234, 1300));
    }


}
