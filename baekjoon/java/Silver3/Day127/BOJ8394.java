package Silver3.Day127;

import java.io.*;

public class BOJ8394 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dynamic(n);

        bw.write(dp[n] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic (int n) {
        dp = new int[n + 1];

        if (n >= 0) dp[0] = 1;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 10;
    }
}
