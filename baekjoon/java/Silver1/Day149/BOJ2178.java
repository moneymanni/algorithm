package Silver1.Day149;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2178 {
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    private static int[][] cost;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        int minCost = Math.min(paint(N - 1, RED), Math.min(paint(N - 1, GREEN), paint(N - 1, BLUE)));

        bw.write(minCost + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int paint(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == RED)
                dp[N][RED] = Math.min(paint(N - 1, GREEN), paint(N - 1, BLUE)) + cost[N][RED];
            else if (color == GREEN)
                dp[N][GREEN] = Math.min(paint(N - 1, RED), paint(N - 1, BLUE)) + cost[N][GREEN];
            else
                dp[N][BLUE] = Math.min(paint(N - 1, RED), paint(N - 1, GREEN)) + cost[N][BLUE];
        }

        return dp[N][color];
    }
}
