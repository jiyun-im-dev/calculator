package com.jiyun.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
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
        scanner.nextLine(); // 스캐너를 다음 줄로 이동
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }

}
