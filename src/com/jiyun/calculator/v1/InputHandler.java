package com.jiyun.calculator.v1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    private final Calculator calculator;

    public InputHandler(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    public int getPositiveInteger() {
        while (true) {
            try {
                int num = scanner.nextInt();
                if (num < 0) {
                    throw new IllegalArgumentException("0 이상의 정수를 입력해야 합니다.");
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해야 합니다.");
                scanner.next(); // 잘못된 입력값을 버림 (없으면 무한루프)
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public char getOperator() {
        while (true) {
            try {
                char operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    return operator;
                } else {
                    throw new IllegalArgumentException("사칙연산 기호를 입력해야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void exitIfRequested() {
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }

    public void removeResultIfRequested() {
        String input = scanner.nextLine();
        if (input.equals("Y")) {
            calculator.removeFirstResult();
        }
    }

    public void chooseMenu() {
        scanner.nextLine(); // Scanner 버퍼 비우기
        while (true) {
            System.out.println("실행할 항목을 입력하세요. (1=계속 계산, 2=첫번째 결과 지우기, exit=프로그램 종료)");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    return;
                case "2":
                    calculator.removeFirstResult();
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }

}