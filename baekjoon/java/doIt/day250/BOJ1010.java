package doIt.day250;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M + 1][M + 1];

            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][i] = 1;
                dp[i][1] = i;
            }

            for (int i = 2; i <= M; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }

            bw.write(dp[M][N] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
