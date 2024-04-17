package Silver3.Day111;

import java.io.*;

public class BOJ11727 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        func(n);

        bw.write(dp[n] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void func(int n) {
        dp = new int[n+1];

        if (n >= 1)
            dp[1] = 1;
        if (n >= 2)
            dp[2] = 3;

        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10_007;
    }
}
