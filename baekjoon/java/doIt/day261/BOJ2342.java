package doIt.day261;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2342 {

    private static final int BIG_NUM = 100_000;
    private static final int[][] MP = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };

    private static int[][][] dp = new int[BIG_NUM + 1][5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0;
        int S = 1;

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= BIG_NUM; k++) {
                    dp[k][i][j] = BIG_NUM * 5;
                }
            }
        }

        dp[0][0][0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            for (int i = 0; i <= 4; i++) {
                if (N == i) continue;

                for (int j = 0; j <= 4; j++) {
                    dp[S][i][N] = Math.min(dp[S - 1][i][j] + MP[j][N], dp[S][i][N]);
                }
            }

            for (int j = 0; j <= 4; j++) {
                if (N == j) continue;

                for (int i = 0; i <= 4; i++) {
                    dp[S][N][j] = Math.min(dp[S - 1][i][j] + MP[i][N], dp[S][N][j]);
                }
            }

            S++;
        }
        S--;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                min = Math.min(min, dp[S][i][j]);
            }
        }

        bw.write(min + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
