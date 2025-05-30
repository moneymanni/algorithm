package StepByStep.Loop;

import java.util.Scanner;

public class BOJ10950 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(add(A, B));
        }
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
