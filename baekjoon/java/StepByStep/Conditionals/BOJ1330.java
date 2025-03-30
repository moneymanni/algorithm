package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ1330 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        String result = equals(A, B);

        System.out.println(result);
    }

    private static String equals(int a, int b) {
        String str;

        if (a > b) {
            str = ">";
        } else if (a < b) {
            str = "<";
        } else {
            str = "==";
        }

        return str;
    }
}
