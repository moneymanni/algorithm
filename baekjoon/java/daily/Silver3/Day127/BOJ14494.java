package Silver3.Day127;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14494 {
    private static final int MOD = 1_000_000_007;

    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);

        long result = fibonacci(n, m);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long fibonacci(int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (n == 1 && m == 1)
            return 1;
        if (dp[n][m] != -1)
            return dp[n][m];

        long result = (fibonacci(n, m - 1) + fibonacci(n - 1, m) + fibonacci(n - 1, m - 1)) % MOD;

        dp[n][m] = result;

        return result;
    }
}
