package math;

import math.api.Calculator;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(Calculator.INSTANCE.calculate("0.6 * 1 + (2*3)-1+(4/2)"));
    }
}
