package math.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    @Test
    public void shouldThrowNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> StringParser.INSTANCE.parseNumber(0, new char[]{'0','.', '1', '.', '1', '*', '1'}));
    }

    @Test
    public void shouldReturnCorrectNumberAndNextIndex() {
        var numAndIdx = StringParser.INSTANCE.parseNumber(0, new char[]{'0','.', '1', '*', '1'});
        assertEquals(0.1, numAndIdx.getKey());
        assertEquals(3, numAndIdx.getValue());
    }

}