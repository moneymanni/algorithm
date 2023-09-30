package Day5;

import java.util.Scanner;

public class BOJ27294 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        int S = scan.nextInt();

        int result = 12 <= T && T <= 16 && S == 0 ? 320 : 280;
        System.out.println(result);
    }
}
