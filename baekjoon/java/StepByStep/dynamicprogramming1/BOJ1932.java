package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = 1;
            while (st.hasMoreTokens()) {
                dp[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] += Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        bw.write(dp[1][1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
