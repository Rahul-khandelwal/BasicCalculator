package math.api;

import math.ops.Operator;
import math.util.StringParser;

import java.util.Stack;

public enum Calculator {

    INSTANCE;

    public double calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Provide non empty expression as input.");
        }

        var values = new Stack<Double>();
        var operators = new Stack<Character>();
        var tokens = expression.trim().toCharArray();

        for (int i = 0 ; i < tokens.length ; i++) {
            char c = tokens[i];

            if (c == ' ') {
                continue;
            }

            if (Character.isLetter(c)) {
                throw new IllegalArgumentException("Expression should only contain digits and supported operators.");
            }

            if (Character.isDigit(c) || c == '.') {
                var numAndNextIndex = StringParser.INSTANCE.parseNumber(i, tokens);
                values.push(numAndNextIndex.getKey());
                i = numAndNextIndex.getValue() - 1; // Skip the parsed umber and counter for loop's increment
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    double num2 = values.pop();
                    double num1 = values.pop();
                    values.push(Operator.forSign(operators.pop()).execute(num1, num2));
                }
                operators.pop();
            } else {
                Operator op = Operator.forSign(c);

                // Process all the operators with higher precedence
                while (!operators.isEmpty() &&
                        operators.peek() != '(' && operators.peek() != ')') {
                    if (!Operator.forSign(operators.peek()).hasEqualOrHigherPrecedence(op)) {
                        break;
                    }
                    double num2 = values.pop();
                    double num1 = values.pop();
                    values.push(Operator.forSign(operators.pop()).execute(num1, num2));
                }

                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double num2 = values.pop();
            double num1 = values.pop();
            values.push(Operator.forSign(operators.pop()).execute(num1, num2));
        }

        return values.pop();
    }
}
