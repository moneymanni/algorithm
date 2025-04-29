package StepByStep.dynamicprogramming1;

import java.io.*;

public class BOJ1904 {

    private static final int MOD = 15_746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[1] = 1;
        if (N >= 2) dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
