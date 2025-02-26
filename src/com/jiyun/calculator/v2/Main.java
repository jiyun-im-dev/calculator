package com.jiyun.calculator.v2;

import com.jiyun.calculator.v1.Calculator;
import com.jiyun.calculator.v1.InputHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputHandlerV2 inputHandler = new InputHandlerV2(scanner);
        CalculatorV2 calculator = new CalculatorV2();

        while (true) {
            System.out.print("첫번째 수를 입력하세요: ");
            Number a = inputHandler.getNumber();
            System.out.print("두번째 수를 입력하세요: ");
            Number b = inputHandler.getNumber();

            System.out.print("사칙기호 연산자 중 하나를 입력하세요: ");
            Opeartor operator = inputHandler.getOperator();

            Number result = calculator.calculate(a, b, operator);
            if (result != null) {
                System.out.println("결과는 " + result + "입니다.");
            } else {
                System.out.println("시스템 에러가 발생했습니다.");
            }

            System.out.println("프로그램을 계속 실행할까요? (exit 입력 시 종료)");
            inputHandler.exitIfRequested();
        }

    }
}