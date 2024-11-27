package Silver3.Day109;

import java.io.*;

public class BOJ1003 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        func();

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N][0]).append(' ').append(dp[N][1]).append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void func() {
        dp = new int[40 + 1][2];
        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
    }
}
