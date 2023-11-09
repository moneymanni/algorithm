package Day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++)
                sb.append("*");
            for (int j = (N - i) * 2; j >= 1; j--)
                sb.append(" ");
            for (int j = 1; j <= i; j++)
                sb.append("*");
            sb.append("\n");
        }
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i; j >= 1; j--)
                sb.append("*");
            for (int j = 1; j <= (N - i) * 2; j++)
                sb.append(" ");
            for (int j = i; j >= 1; j--)
                sb.append("*");
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
