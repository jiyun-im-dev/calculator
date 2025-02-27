/*
 * 계산기 v2
 * 도전 기능
 */

package com.jiyun.calculator.v2;

import java.util.ArrayList;
import java.util.List;

public class CalculatorV2 {

    private static final List<Number> results = new ArrayList<>();

    public List<Number> getResults() {
        return results;
    }

    public void setResults(int index, Number value) {
        results.set(index, value);
    }

    public void addResult(Number value) {
        results.add(value);
    }

    // 결괏값 리스트에서 첫 번째 항목을 삭제한다.
    public void removeFirstResult() {
        try {
            results.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 항목이 없습니다.");
        }
    }

    public void printResults() {
        for (Number v : results) {
            System.out.print(formatResult(v) + " ");
        }
        System.out.println();
    }

    // 소수점 아래가 없는 경우 정수 형태로 바꿔서 반환한다.
    public static Number formatResult(Number num) {
        if (num.doubleValue() == num.longValue()) {
            return num.longValue();
        } else {
            return num.doubleValue();
        }
    }

    // Operator enum 타입을 이용하여 계산을 수행한다
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