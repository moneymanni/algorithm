package doIt.day263;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2098 {

    private static final int INF = 1_000_000 * 16 + 1;

    private static int N;
    private static int[][] W, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[16][16];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[16][1 << 16];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(tsp(0, 1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int tsp(int c, int v) {
        if (v == (1 << N) - 1) {
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (dp[c][v] != -1) {
            return dp[c][v];
        }

        dp[c][v] = INF;

        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {
                dp[c][v] = Math.min(dp[c][v], tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }

        return dp[c][v];
    }
}
