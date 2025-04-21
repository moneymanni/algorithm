package StepByStep.combinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1010 {

    private static final int MAX_NUM = 30;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        dp = new int[MAX_NUM + 1][MAX_NUM + 1];

        for (int i = 0; i <= MAX_NUM; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= MAX_NUM; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int max = Math.max(N, M);
            int min = Math.min(N, M);

            bw.write(dp[max][min] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
