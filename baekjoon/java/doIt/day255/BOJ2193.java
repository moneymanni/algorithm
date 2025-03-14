package doIt.day255;

import java.io.*;

public class BOJ2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
            dp[i][1] = dp[i - 1][0];
        }

        long result = dp[N][0] + dp[N][1];

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
