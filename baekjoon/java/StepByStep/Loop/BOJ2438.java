package StepByStep.Loop;

import java.util.Scanner;

public class BOJ2438 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(drawStars(N));
    }

    private static String drawStars(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i)).append('\n');
        }

        return sb.toString().trim();
    }
}
