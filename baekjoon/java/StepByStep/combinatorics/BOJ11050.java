package StepByStep.combinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11050 {

    private static int N, K;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i<= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        bw.write(dp[N][K] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int comb(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private static int factorial(int num) {
        int result = 1;

        for (int i = 2; i <= num; i++) {
            result *= i;
        }

        return result;
    }
}
