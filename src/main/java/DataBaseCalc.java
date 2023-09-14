package main.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@NoArgsConstructor
public class DataBaseCalc {
    /**
     * Adds two nullable Double numbers and returns the sum.
     *
     * @param firstArgument  the first Double number to be added
     * @param secondArgument the second Double number to be added
     * @return the sum of the two numbers
     * @throws NullPointerException if either firstArgument or secondArgument is null
     */
    public Double add(@Nullable Double firstArgument, @Nullable Double secondArgument) {
        return Optional.ofNullable(firstArgument)
                .orElseThrow(() -> new NullPointerException("first argument is null"))
                +
                Optional.ofNullable(secondArgument)
                        .orElseThrow(() -> new NullPointerException("second argument is null"));
    }
    /**
     * Subtract two Double values.
     *
     * @param firstArgument  the first Double value to subtract
     * @param secondArgument the second Double value to subtract
     * @return the result of subtracting the two Double values
     * @throws NullPointerException if either firstArgument or secondArgument is null
     */
    public Double subtract(@Nullable Double firstArgument, @Nullable Double secondArgument) {
        return Optional.ofNullable(firstArgument)
                .orElseThrow(() -> new NullPointerException("first argument is null"))
                -
                Optional.ofNullable(secondArgument)
                        .orElseThrow(() -> new NullPointerException("second argument is null"));
    }
    /**
     * Multiplies two nullable Double arguments and returns the result.
     *
     * @param firstArgument  the first Double argument to be multiplied
     * @param secondArgument the second Double argument to be multiplied
     * @return               the result of multiplying the two arguments
     * @throws NullPointerException if either of the arguments is null
     */
    public Double multiply(@Nullable Double firstArgument, @Nullable Double secondArgument) {
        // Throw NullPointerException if either argument is null
        return Optional.ofNullable(firstArgument)
                .orElseThrow(() -> new NullPointerException("first argument is null"))
                * Optional.ofNullable(secondArgument)
                .orElseThrow(() -> new NullPointerException("second argument is null"));
    }
    /**
     * Divides the first argument by the second argument.
     *
     * @param firstArgument the first argument to be divided
     * @param secondArgument the second argument to divide the first argument by
     * @return the result of dividing the first argument by the second argument
     * @throws NullPointerException if either the first argument or the second argument is null
     * @throws ArithmeticException if the second argument is zero
     */
    public Double divide(@Nullable Double firstArgument, @Nullable Double secondArgument) {

        // Check if the second argument is null
        Double num2 = Optional.ofNullable(secondArgument).orElseThrow(
                () -> new NullPointerException("second argument is null"));

        // Check if the second argument is zero
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        } else {
            // Divide the first argument by the second argument
            return Optional.ofNullable(firstArgument).orElseThrow(
                    () -> new NullPointerException("first argument is null"))
                    / num2;
        }
    }}
