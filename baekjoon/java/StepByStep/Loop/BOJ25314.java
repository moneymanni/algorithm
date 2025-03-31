package StepByStep.Loop;

import java.util.Scanner;

public class BOJ25314 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int longCnt = N % 4 == 0 ? N / 4 : N / 4 + 1;

        String result = "long ".repeat(longCnt) + "int";

        System.out.println(result);
    }
}
