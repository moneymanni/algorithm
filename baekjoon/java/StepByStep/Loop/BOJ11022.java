package StepByStep.Loop;

import java.util.Scanner;

public class BOJ11022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.printf("Case #%d: %d + %d = %d\n", i, A, B, add(A, B));
        }
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
