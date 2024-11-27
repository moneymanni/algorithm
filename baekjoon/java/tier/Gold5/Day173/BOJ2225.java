package Gold5.Day173;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2225 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) dp[i][0] = 1;
        for (int i = 1; i <= N; i++) dp[1][i] = 1;

        for (int i = 2; i <= K; i++)
            for (int j = 1; j <= N; j++)
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;

        bw.write(Integer.toString(dp[K][N]));

        br.close();
        bw.flush();
        bw.close();
    }
}
