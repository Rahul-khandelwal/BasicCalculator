package math.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldThrowIllegalArgumentForBlankInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.INSTANCE.calculate(" "));
    }

    @Test
    public void shouldThrowIllegalArgumentForInvalidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.INSTANCE.calculate("2 * 3 + a"));
    }

    @Test
    public void shouldThrowIllegalArgumentForUnsupportedOperator() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> Calculator.INSTANCE.calculate("2 * 3 & 1"));
    }

    @Test
    public void shouldReturnCorrectResultForExpr1() {
            assertEquals(0.06, Calculator.INSTANCE.calculate("0.6 * 0.1"));
    }

    @Test
    public void shouldReturnCorrectResultForExpr2() {
        assertEquals(0.6, Calculator.INSTANCE.calculate("0.6 * 1"));
    }

    @Test
    public void shouldReturnCorrectResultForExpr3() {
        assertEquals(7.6, Calculator.INSTANCE.calculate("0.6 * 1 + (2*3)-1+(4/2)"));
    }
}