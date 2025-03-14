package doIt.day255;

import java.io.*;

public class BOJ11726 {

    private static final int MOD = 10_007;

    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
