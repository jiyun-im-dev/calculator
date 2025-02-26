package com.jiyun.calculator.v2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandlerV2 {

    private final Scanner scanner;

    public InputHandlerV2(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T extends Number> T getNumber() {
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    return (T) Integer.valueOf(scanner.nextInt());
                } else if (scanner.hasNextDouble()) {
                    return (T) Double.valueOf(scanner.nextDouble());
                } else {
                    System.out.println("입력값이 잘못되었습니다. 다시 입력해 주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("입력값이 잘못되었습니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력값을 버림 (없으면 무한루프)
            }
        }
    }

    public Opeartor getOperator() {
        while (true) {
            try {
                char input = scanner.next().charAt(0);
                if (Opeartor.isOperator(input)) {
                    return Opeartor.getOperator(input);
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
