package Day7;

import java.util.Scanner;

public class BOJ2440 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = N-i; j >= 1; j--)
                System.out.print("*");
            System.out.println();
        }
    }
}
