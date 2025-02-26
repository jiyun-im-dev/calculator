package com.jiyun.calculator.v1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("첫번째 양의 정수를 입력하세요: ");
            int a = inputHandler.getPositiveInteger();
            System.out.print("두번째 양의 정수를 입력하세요: ");
            int b = inputHandler.getPositiveInteger();

            System.out.print("사칙기호 연산자 중 하나를 입력하세요: ");
            char operator = inputHandler.getOperator();

            double result = calculator.calculate(a, b, operator);
            if (result != Calculator.getFlag()) {
                System.out.println("결과는 " + result + "입니다.");
            }

            System.out.println("프로그램을 계속 실행할까요? (exit 입력 시 종료)");
            inputHandler.exitIfRequested();
        }

    }
}