package StepByStep.IOAndOperations.Day268;

import java.util.Scanner;

public class BOJ10998 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int result = multiply(A, B);

        System.out.println(result);
    }

    private static int multiply(int a, int b) {
        return a * b;
    }
}
