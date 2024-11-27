package Day5;

import java.util.Scanner;

public class BOJ24736 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] teams = new int[2];
        for (int i = 0; i < 2; i++) {
            int T = scan.nextInt();
            int F = scan.nextInt();
            int S = scan.nextInt();
            int P = scan.nextInt();
            int C = scan.nextInt();
            teams[i] = T*6 + F*3 + S*2 + P + C*2;
        }
        for (int team: teams)
            System.out.printf("%d ", team);
    }
}
