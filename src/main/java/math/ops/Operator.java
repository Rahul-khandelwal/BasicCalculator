package math.ops;

public enum Operator implements Operation {
    ADD('+', 1) {
        @Override
        public double execute(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACT('-', 1) {
        @Override
        public double execute(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*', 2) {
        @Override
        public double execute(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/', 2) {
        @Override
        public double execute(double num1, double num2) throws IllegalArgumentException {
            if (num2 == 0) {
                throw new IllegalArgumentException("Expression causes divide by zero exception to occur.");
            }

            return num1 / num2;
        }
    };

    private final char sign;
    private final int precedence;

    Operator(char sign, int precedence) {
        this.sign = sign;
        this.precedence = precedence;
    }

    public boolean hasEqualOrHigherPrecedence(Operator op) {
        return this.precedence >= op.precedence;
    }

    public static Operator forSign(char sign) {
        for (Operator op : Operator.values()) {
            if (op.sign == sign) {
                return op;
            }
        }

        throw new UnsupportedOperationException("Operation '" + sign + "' is not yet supported.");
    }
}
