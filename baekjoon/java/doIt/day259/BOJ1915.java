package doIt.day259;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1915 {

    private static int N, M;
    private static long max;
    private static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                dp[i][j] = input.charAt(j) - '0';

                if (dp[i][j] == 1 && j > 0 && i > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + dp[i][j];
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        bw.write((max * max) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
