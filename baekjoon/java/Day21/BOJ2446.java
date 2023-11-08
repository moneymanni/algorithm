package Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i > 0; i--) {
            for (int j = 0; j < N - i; j++)
                System.out.print(" ");
            for (int j = 0; j < i + (i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 2; i <= N; i++) {
            for (int j = N; j > i; j--)
                System.out.print(" ");
            for (int j = 0; j < i + (i - 1); j++)
                System.out.print("*");
            System.out.println();
        }

        br.close();
    }
}
