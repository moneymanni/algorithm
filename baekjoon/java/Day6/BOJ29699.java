package Day6;

import java.util.Scanner;

public class BOJ29699 {
    public static final String SMUPC = "WelcomeToSMUPC";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        System.out.println(SMUPC.charAt(N%14 == 0 ? 13 : N%14 - 1));
    }
}
