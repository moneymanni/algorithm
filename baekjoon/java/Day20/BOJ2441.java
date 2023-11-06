package Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i >= 1; i--) {
            StringBuilder line = new StringBuilder();
            for (int j = i; j >= 1; j--)
                line.append("*");
            System.out.printf("%" + N + "s\n", line);
        }

        br.close();
    }
}
