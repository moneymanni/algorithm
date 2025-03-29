package StepByStep.IOAndOperations.Day268;

import java.util.Scanner;

public class BOJ1008 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        double result = divide(A, B);

        System.out.println(result);
    }

    private static double divide(int a, int b) {
        return (double) a / b;
    }
}
