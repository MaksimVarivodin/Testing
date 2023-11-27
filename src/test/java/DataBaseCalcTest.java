import org.junit.jupiter.api.Test;

import static java.lang.Double.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataBaseCalcTest {
    @Test
    public void addTestNoneNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertEquals(1.0d, mathCalc.add(valueOf(0), valueOf(1)));
    }
    @Test
    public void addTestFirstNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.add(null, valueOf(1)));
    }
    @Test
    public void addTestSecondNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.add(valueOf(1), null));
    }
    @Test
    public void addTestBothNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.add(null, null));
    }
    @Test
    public void subtractTest(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertEquals(-1.0d, mathCalc.subtract(valueOf(0), valueOf(1)));
    }
    @Test
    public void subtractTestFirstNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.subtract(null, valueOf(1)));
    }
    @Test
    public void subtractTestSecondNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.subtract(valueOf(1), null));
    }
    @Test
    public void subtractTestBothNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.subtract(null, null));
    }
    @Test
    public void multiplyTest(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertEquals(0.0d, mathCalc.multiply(valueOf(0), valueOf(1)));
    }
    @Test
    public void multiplyTestFirstNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.multiply(null, valueOf(1)));
    }
    @Test
    public void multiplyTestSecondNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.multiply(valueOf(1), null));
    }
    @Test
    public void multiplyTestBothNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.multiply(null, null));
    }
    @Test
    public void divideTest(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertEquals(1.0d, mathCalc.divide(valueOf(1), valueOf(1)));
    }
    @Test
    public void divideTestFirstNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.divide(null, valueOf(1)));
    }
    @Test
    public void divideTestSecondNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.divide(valueOf(1), null));
    }
    @Test
    public void divideTestBothNull(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(NullPointerException.class, () -> mathCalc.divide(null, null));
    }
    @Test
    public void divideTestZero(){
        DataBaseCalc mathCalc = new DataBaseCalc();
        assertThrows(ArithmeticException.class, () -> mathCalc.divide(valueOf(1), valueOf(0)));
    }
}
