package StepByStep.IOAndOperations.Day268;

import java.util.Scanner;

public class BOJ18108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int buddhistEra = sc.nextInt();

        int result = convertSolar(buddhistEra);

        System.out.println(result);
    }

    private static int convertSolar(int year) {
        return year - 543;
    }
}
