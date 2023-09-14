package main.java;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MathCalc {
    private double number;
    /**
     * Adds the given MathCalc object to this MathCalc object and returns a new MathCalc object with the result.
     *
     * @param  mathCalc  the MathCalc object to be added
     * @return           a new MathCalc object with the sum of the two MathCalc objects
     */
    public MathCalc add(MathCalc mathCalc){
        return new MathCalc(this.number + mathCalc.number);
    }
    /**
     * Subtract a MathCalc object from the current MathCalc object.
     *
     * @param  mathCalc  The MathCalc object to subtract.
     * @return           A new MathCalc object with the result of the subtraction.
     */
    public MathCalc subtract(MathCalc mathCalc){
        return new MathCalc(this.number - mathCalc.number);
    }
    /**
     * Divides this MathCalc object by another MathCalc object.
     *
     * @param  mathCalc  the MathCalc object to divide by
     * @return           a new MathCalc object with the result of the division
     * @throws ArithmeticException if the divisor is zero
     */
    public MathCalc multiply(MathCalc mathCalc){
        return new MathCalc(this.number * mathCalc.number);
    }
    /**
     * Divides this MathCalc object by another MathCalc object.
     *
     * @param  mathCalc  the MathCalc object to divide by
     * @return           a new MathCalc object with the result of the division
     * @throws ArithmeticException if the divisor is zero
     */
    public MathCalc divide(MathCalc mathCalc){
        if (mathCalc.number == 0){
            throw new ArithmeticException("Division by zero");
        }else {
            return new MathCalc(this.number / mathCalc.number);
        }
    }
}
