package StepByStep.Advanced1;

import java.util.Scanner;

public class BOJ2444 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.print(printStar(N));
    }

    private static String printStar(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(n - i))
                    .append("*".repeat(i == 1 ? i : 2 * i - 1))
                    .append('\n');
        }

        for (int i = n - 1; i >= 1; i--) {
            sb.append(" ".repeat(n - i))
                    .append("*".repeat(i == 1 ? i : 2 * i - 1))
                    .append('\n');
        }

        return sb.toString();
    }
}
