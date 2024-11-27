package Silver4.Day103;

import java.io.*;

public class BOJ15624 {
    public static long[] dp;
    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            bw.write("0");
        } else if (n <= 2) {
            bw.write("1");
        } else {
            fibonacci(n);
            bw.write(dp[n] + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void fibonacci(int n) {
        dp = new long[n+1];

        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
    }
}
