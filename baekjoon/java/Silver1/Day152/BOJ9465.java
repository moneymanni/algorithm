package Silver1.Day152;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    private static int[][] dp;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            dp = new int[2][n + 1];
            arr = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= n; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            dynamicProgramming(n);

            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int n) {
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
        }
    }
}
