package StepByStep.Loop;

import java.util.Scanner;

public class BOJ8393 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = n;

        while (n-- > 0) {
            sum += n;
        }

        System.out.println(sum);
    }
}
