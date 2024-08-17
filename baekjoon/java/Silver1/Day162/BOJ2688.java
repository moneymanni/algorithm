package Silver1.Day162;

import java.io.*;

public class BOJ2688 {
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        findNonDecreasingNum(64);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long result = 0;

            for (int i = 0; i <= 9; i++)
                result += dp[n][i];

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    private static void findNonDecreasingNum(int digit) {
        dp = new long[digit + 1][10];

        for (int i = 0; i <= 9; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= digit; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
    }
}
