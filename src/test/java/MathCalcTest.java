
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MathCalcTest {
    @Test
    public void addTest(){
        MathCalc mathCalc = new MathCalc(0);
        MathCalc mathCalc2 = new MathCalc(1);
        MathCalc mathCalc3 = mathCalc.add(mathCalc2);
        assertEquals(1.0d, mathCalc3.getNumber());
    }
    @Test
    public void subtractTest(){
        MathCalc mathCalc = new MathCalc(0);
        MathCalc mathCalc2 = new MathCalc(1);
        MathCalc mathCalc3 = mathCalc.subtract(mathCalc2);
        assertEquals(-1.0d, mathCalc3.getNumber());
    }
    @Test
    public void multiplyTest(){
        MathCalc mathCalc = new MathCalc(0);
        MathCalc mathCalc2 = new MathCalc(1);
        MathCalc mathCalc3 = mathCalc.multiply(mathCalc2);
        assertEquals(0.0d, mathCalc3.getNumber());
    }
    @Test
    public void divideTest() throws ArithmeticException{
        MathCalc mathCalc = new MathCalc(1);
        MathCalc mathCalc2 = new MathCalc(0);
        assertThrows(ArithmeticException.class, () -> mathCalc.divide(mathCalc2));
    }

}
