package com.jiyun.calculator.v1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final double FLAG = Double.MIN_VALUE;

    private final List<Double> results = new ArrayList<>();

    public static double getFlag() {
        return FLAG;
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(int index, double value) {
        results.set(index, value);
    }

    public void addResult(double value) {
        results.add(value);
    }

    public void removeFirstResult() {
        try {
            results.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 항목이 없습니다.");
        }
    }

    public void printResults() {
        for (Double v : results) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public double calculate(int a, int b, char operator) {
        try {
            switch (operator) {
                case '+':
                    return (long) a + b; // 오버플로우 방지 및 정밀도 유지를 위한 long 타입 변환
                case '-':
                    return a - b;
                case '*':
                    return (double) a * b; // int 형에서 발생할 수 있는 오버플로우 방지
                case '/':
                    if (b == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                    return a * 1.0 / b;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return FLAG;
    }

}