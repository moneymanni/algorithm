package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12865 {

    private static int N, K;
    private static int[][] backpack, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        backpack = new int[N + 1][2];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            backpack[i][0] = Integer.parseInt(st.nextToken());
            backpack[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (backpack[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - backpack[i][0]] + backpack[i][1]);
                }
            }
        }

        bw.write(dp[N][K] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
