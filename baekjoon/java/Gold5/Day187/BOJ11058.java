package Gold5.Day187;

import java.io.*;

public class BOJ11058 {
    private static int N;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        kriiiBoard();

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void kriiiBoard() {
        dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i > 6) {
                for (int j = 2; j < 5; j++)
                    dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
            }
        }
    }
}
