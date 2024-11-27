package Silver1.Day154;

import java.io.*;

public class BOJ1309 {
    private static final int MOD = 9_901;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        placeLionInCage(N);

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void placeLionInCage(int N) {
        dp = new int[N + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
    }
}
