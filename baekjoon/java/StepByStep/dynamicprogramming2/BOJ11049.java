package StepByStep.dynamicprogramming2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11049 {

    private static final int INF = Integer.MAX_VALUE;

    private static int N;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = r;
            arr[i + 1] = c;
        }

        for (int gap = 2; gap <= N; gap++) {
            for (int start = 0; start <= N - gap; start++) {
                dp[start][start + gap - 1] = INF;

                for (int mid = start; mid < start + gap - 1; mid++) {
                    dp[start][start + gap - 1] = Math.min(
                            dp[start][start + gap - 1],
                            dp[start][mid] + dp[mid + 1][start + gap - 1] + (arr[start] * arr[mid + 1] * arr[start + gap])
                    );
                }
            }
        }

        bw.write(dp[0][N - 1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
