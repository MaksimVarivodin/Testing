import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CashTerminalTest {
    ///TO_DO Число банкнот під час заповнення банкомату коректне.
    // TO_DO Число банкнот при заповненні банкомату більше максимально допустимого.
    // TO_DO На вхід у поля cartId , pin можуть надходити порожні рядки або значення null . як по одному, так і одночасно в обидва поля.
    // TO_DO У полі pin надійшло число символів, відмінне від 4.
    // TO_DO Кількість грошей не кратна m (перевірити на різних значеннях ).
    /* TO_DO Кількість грошей більша, ніж може видати банкомат. */
    /* TO_DO Кількість грошей є коректною.*/
    CashTerminal terminal;
    @Test()
    public void normalAB() throws CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
    }
    @Test(expected = CashTerminalException.class)
    public void badA() throws CashTerminalException{
        terminal =  new CashTerminal(21, 15);
    }
    @Test(expected = CashTerminalException.class)
    public void badB() throws CashTerminalException{
        terminal =
            new CashTerminal(15, 21);

    }
    @Test(expected = CashTerminalException.class)
    public void badAB()  throws CashTerminalException{
        terminal =  new CashTerminal(21, 21);
    }
    @Test
    public void normalCredentials() throws CredentialsException, CashTerminalException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertTrue(terminal.getMoney(1234, 1234, 1300));
    }
    @Test(expected = CredentialsException.class)
    public void badCard() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        terminal.getMoney(null, 1234, 1300);
    }
    @Test( expected = CredentialsException.class)
    public void badPassCode() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        terminal.getMoney(1234, null, 1300);
    }
    @Test(expected = CredentialsException.class)
    public void badCredentials() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        terminal.getMoney(null, null, 1300);
    }
    @Test( expected = CredentialsException.class)
    public void badPassCodeLength() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));


            terminal.getMoney(1234, 123, 1300);
    }
    @Test(  expected = CredentialsException.class)
    public void badAmount1301() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
     terminal.getMoney(1234, 1234, 1301);
    }

    @Test(  expected = CashTerminalException.class)
    public void badAmountMinus1300() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));

            terminal.getMoney(1234, 1234, -1300);

    }
    @Test(  expected = CashTerminalException.class)
    public void badAmountZero() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));

            terminal.getMoney(1234, 1234, 0);

    }


    @Test(  expected = CashTerminalException.class)
    public void tooBigAmount() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(1, 1));
        terminal.getMoney(1234, 1234, 400);

    }
    @Test
    public void normalAmount() throws CashTerminalException, CredentialsException {
        terminal = new CashTerminal();
        assertTrue(terminal.putMoney(15, 15));
        assertTrue(terminal.getMoney(1234, 1234, 1300));
    }


}
