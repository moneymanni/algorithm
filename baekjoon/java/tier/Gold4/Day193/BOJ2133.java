package Gold4.Day193;

import java.io.*;

public class BOJ2133 {

    private static int N;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        fillTiles();

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void fillTiles() {
        dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 0;

        if (N >= 2) dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * dp[2];

            for (int j = i - 4; j >= 0; j -= 2)
                dp[i] = dp[i] + (dp[j] * 2);
        }
    }
}
