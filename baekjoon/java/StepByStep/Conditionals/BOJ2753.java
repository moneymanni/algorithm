package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ2753 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        boolean result = isLeapYear(year);

        System.out.println(result ? "1" : "0");
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
