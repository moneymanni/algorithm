package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    private static int N;
    private static int[][] rpg, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        rpg = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                rpg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][RED] = rpg[0][RED];
        dp[0][GREEN] = rpg[0][GREEN];
        dp[0][BLUE] = rpg[0][BLUE];

        for (int i = 1; i < N; i++) {
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + rpg[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + rpg[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][GREEN], dp[i - 1][RED]) + rpg[i][BLUE];
        }

        int minCost = Math.min(dp[N - 1][RED], Math.min(dp[N - 1][BLUE], dp[N - 1][GREEN]));

        bw.write(minCost + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
