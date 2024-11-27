package Silver1.Day153;

import java.io.*;

public class BOJ11057 {
    private static final int MOD = 10_007;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dynamicProgramming(N);

        bw.write(dp[N][0] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int N) {
        dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++)
            dp[0][i] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }
    }
}
