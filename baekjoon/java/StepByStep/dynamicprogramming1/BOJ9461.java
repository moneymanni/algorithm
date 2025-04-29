package StepByStep.dynamicprogramming1;

import java.io.*;

public class BOJ9461 {

    private static final int MAX_NUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] P = getP(MAX_NUM);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            bw.write(P[N] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long[] getP(int num) {
        long[] dp = new long[num + 1];

        dp[0] = 0;
        if (num >= 1) dp[1] = 1;
        if (num >= 2) dp[2] = 1;
        if (num >= 3) dp[3] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        return dp;
    }
}
