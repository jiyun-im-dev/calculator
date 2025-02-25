package com.jiyun.calculator;

public class Calculator {

    private double flag = Double.MIN_VALUE;

    public double getFlag() {
        return flag;
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
        return flag;
    }

}
