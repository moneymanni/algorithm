package Silver4.Day100;

import java.io.*;

public class BOJ9507 {
    public static long[] dp = new long[68];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        koong();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void koong() {
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 67; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
    }
}
