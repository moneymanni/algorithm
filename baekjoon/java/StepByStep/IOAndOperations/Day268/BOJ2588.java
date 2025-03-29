package StepByStep.IOAndOperations.Day268;

import java.util.Scanner;

public class BOJ2588 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int first = A * (B % 10);
        int second = A * ((B % 100) / 10);
        int third = A * (B / 100);
        int result = A * B;

        System.out.println(String.format("%d\n%d\n%d\n%d\n", first, second, third, result));
    }
}
