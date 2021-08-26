package math.ops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    public void shouldAddNumberFromAddSign() {
        Operator op = Operator.forSign('+');
        Assertions.assertEquals(10.0, op.execute(6, 4));
    }

    @Test
    public void shouldAddNumberFromMinusSign() {
        Operator op = Operator.forSign('-');
        Assertions.assertEquals(2.0, op.execute(6, 4));
    }

    @Test
    public void shouldAddNumberFromMultiplySign() {
        Operator op = Operator.forSign('*');
        Assertions.assertEquals(24.0, op.execute(6, 4));
    }

    @Test
    public void shouldAddNumberFromDivideSign() {
        Operator op = Operator.forSign('/');
        Assertions.assertEquals(1.5, op.execute(6, 4));
    }

    @Test
    public void shouldThrowIllegalArgumentForDivideByZero() {
        Operator op = Operator.forSign('/');
        Assertions.assertThrows(IllegalArgumentException.class, () -> op.execute(6, 0));
    }

    @Test
    public void shouldThrowIllegalArgumentForUnsupportedSign() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> Operator.forSign('&'));
    }
}