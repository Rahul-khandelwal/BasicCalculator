package math.util;

import java.util.AbstractMap;
import java.util.Map;

public enum StringParser {

    INSTANCE;

    public Map.Entry<Double, Integer> parseNumber(int startIndex, char[] tokens) {
        var num = new StringBuilder();

        while (startIndex < tokens.length &&
                (Character.isDigit(tokens[startIndex]) || tokens[startIndex] == '.')) {
            num.append(tokens[startIndex]);
            startIndex++;
        }

        return new AbstractMap.SimpleImmutableEntry<>(Double.parseDouble(num.toString()), startIndex);
    }
}
