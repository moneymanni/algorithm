package Day1;

import java.util.Scanner;

public class BOJ1008 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double A = scan.nextDouble();
        double B = scan.nextDouble();

        Math divideLambda = (num1, num2) -> num1/num2;
        System.out.println(divideLambda.Calc(A, B));
    }

    @FunctionalInterface
    interface Math {
        double Calc(double num1, double num2);
    }
}
