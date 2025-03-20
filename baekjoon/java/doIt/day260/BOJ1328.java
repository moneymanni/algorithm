package doIt.day260;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1328 {

    private static final long MOD = 1_000_000_007L;

    private static int N, L, R;
    private static long[][][] dp = new long[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dp[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    dp[i][j][k] = (dp[i - 1][j][k] * (i - 2) + (dp[i - 1][j] [k - 1] + dp[i - 1][j - 1][k])) % MOD;
                }
            }
        }

        bw.write(dp[N][L][R] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
