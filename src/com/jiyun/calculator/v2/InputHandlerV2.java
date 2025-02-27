package com.jiyun.calculator.v2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandlerV2 {

    private final Scanner scanner;

    private final CalculatorV2 calculator;

    public InputHandlerV2(Scanner scanner, CalculatorV2 calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
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
                    scanner.next(); // 잘못된 입력값을 버림 (없으면 무한루프)
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

    public void chooseMenu() {
        scanner.nextLine(); // Scanner 버퍼 비우기
        while (true) {
            System.out.println("실행할 항목을 입력하세요. " +
                    "(1=계속 계산, 2=첫번째 결과 지우기, 3=입력값보다 큰 결과값 리스트 출력, exit=프로그램 종료)");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    return;
                case "2":
                    calculator.removeFirstResult();
                    System.out.print("첫번째 결과를 지웠습니다. 현재 결과 리스트: ");
                    calculator.printResults();
                    break;
                case "3":
                    System.out.print("비교할 값을 입력하세요: ");
                    printBiggerThanInput();
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
            }
        }
    }

    private void printBiggerThanInput() {
        double value = scanner.nextDouble();
        scanner.nextLine(); // Scanner 버퍼 비우기
        calculator.getResults().stream()
                .filter(result -> result.doubleValue() > value)
                .map(CalculatorV2::formatResult)
                .forEach(result -> System.out.print(result + " "));
        System.out.println();
    }

}