package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ2480 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int score = getScore(A, B, C);

        System.out.println(score);
    }

    private static int getScore(int a, int b, int c) {
        int score = 0;

        if (a == b && b == c) {
            score = 10_000 + a * 1_000;
        } else if (a == b || a == c) {
            score = 1_000 + a * 100;
        } else if (b == c) {
            score = 1_000 + b * 100;
        } else {
            int max = Math.max(a, Math.max(b, c));
            score = max * 100;
        }

        return score;
    }
}
