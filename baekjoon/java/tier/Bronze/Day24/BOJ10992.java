package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1 ~ (N-1) 줄까지
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++)
                System.out.print(" ");
            System.out.print("*");
            if (i != 1) {
                for (int j = 1; j <= 2 * i - 3; j++)
                    System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
        // N 줄
        for (int i = 1; i <= N + (N-1); i++)
            System.out.print("*");

        br.close();
    }
}
