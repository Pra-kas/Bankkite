package com.example;

import java.util.Scanner;

public class InputHandler {
    private static Scanner inpScanner = new Scanner(System.in);

    public static int inputInt() {
        int result = inpScanner.nextInt();
        inpScanner.nextLine();
        return result;
    }

    public static double inputDouble() {
        double result = inpScanner.nextDouble();
        inpScanner.nextLine();
        return result;
    }

    public static String inputString() {
        return inpScanner.nextLine();
    }
}
