package Day1;

import java.util.Scanner;

public class BOJ1001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();

        Math minusLambda = (num1, num2) -> num1 - num2;
        System.out.println(minusLambda.Calc(A, B));
    }

    @FunctionalInterface
    interface Math {
        int Calc(int num1, int num2);
    }
}
