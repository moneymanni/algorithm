package StepByStep.dynamicprogramming2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ7579 {

    private static final int MAX_NUM = 10_000;

    private static int N, M;
    private static int[] m, c;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        m = new int[N];
        c = new int[N];
        dp = new int[N][MAX_NUM + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= MAX_NUM; j++) {
                if (i == 0) {
                    if (j >= c[i]) {
                        dp[i][j] = m[i];
                    }
                } else {
                    if (j >= c[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if (dp[i][j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
