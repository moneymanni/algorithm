package Silver2.Day137;

import java.io.*;

public class BOJ15988 {
    private static final int MOD = 1_000_000_009;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new long[1_000_001];
        dynamic(1_000_000);

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic(int num) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= num; i++)
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD;
    }
}
