/*
 * 계산기 v2
 * 도전 과제
 */

package com.jiyun.calculator.v2;

public class CalculatorV2 {

    public <T extends Number> T calculate(T a, T b, Opeartor operator) {
        try {
            switch (operator) {
                case ADD:
                    return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
                case SUBTRACT:
                    return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
                case MULTIPLY:
                    return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
                case DIVIDE:
                    if (b.equals(0)) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                    return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}