package Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            sb.setLength(0);
            for (int j = N; j > i; j--)
                sb.append(" ");
            for (int j = 1; j <= i + (i - 1); j++)
                sb.append("*");
            System.out.println(sb);
        }
        for (int i = N-1; i > 0; i--) {
            sb.setLength(0);
            for (int j = 1; j <= N - i; j++)
                sb.append(" ");
            for (int j = i + (i - 1); j > 0; j--)
                sb.append("*");
            System.out.println(sb);
        }

        br.close();
    }
}
