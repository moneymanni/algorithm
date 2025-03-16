package doIt.day256;

import java.io.*;

public class BOJ10844 {

    private static final int MOD = 1_000_000_000;

    private static int N;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][11];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        long result = 0L;

        for (int i = 0; i < 10; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
