package com.jiyun.calculator.v2;

public enum Opeartor {

    // 괄호 안의 값이 생성자로 전달됨
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    public final char symbol; // 연산 기호를 저장하기 위한 필드

    // 생성자
    Opeartor(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // 입력받은 글자가 사칙연산 기호인지 확인
    public static boolean isOperator(char symbol) {
        for (Opeartor opeartor : Opeartor.values()) {
            if (opeartor.getSymbol() == symbol) {
                return true;
            }
        }
        return false;
    }

    // Operator(ex. ADD)를 리턴
    public static Opeartor getOperator(char symbol) {
        for (Opeartor opeartor : Opeartor.values()) {
            if (opeartor.getSymbol() == symbol) {
                return opeartor;
            }
        }
        return null;
    }

}