package StepByStep.Loop;

import java.util.Scanner;

public class BOJ25304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;

        while (N-- > 0) {
            int price = sc.nextInt();
            int cnt = sc.nextInt();

            sum += price * cnt;
        }

        System.out.println(X == sum ? "Yes" : "No");
    }
}
