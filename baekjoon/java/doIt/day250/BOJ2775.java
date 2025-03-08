package doIt.day250;

import java.io.*;

public class BOJ2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            bw.write(dp[k][n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
