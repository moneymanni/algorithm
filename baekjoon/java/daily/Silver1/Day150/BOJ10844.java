package Silver1.Day150;

import java.io.*;

public class BOJ10844 {
    private static final int MOD = 1_000_000_000;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dynamicProgramming(N);

        long result = 0;

        for (int i = 0; i < 10; i++)
            result += dp[N][i];

        bw.write((result % MOD) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int N) {
        dp = new long[N + 1][10];

        for(int i = 1; i < 10; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0)
                    dp[i][0] = dp[i - 1][1];
                else if (j == 9)
                    dp[i][9] = dp[i - 1][8];
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }
    }
}
