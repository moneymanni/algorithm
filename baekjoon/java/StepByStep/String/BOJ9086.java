package StepByStep.String;

import java.util.Scanner;

public class BOJ9086 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String str = sc.next();

            System.out.printf("%s%s\n", str.charAt(0), str.charAt(str.length() - 1));
        }
    }
}
