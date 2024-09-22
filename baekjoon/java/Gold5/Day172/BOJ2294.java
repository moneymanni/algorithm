package Gold5.Day172;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2294 {
    private static final int MAX_VALUE = 10_001;
    private static int n, k;
    private static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n + 1];
        dp = new int[k + 1];

        for (int i = 1; i <= n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++)
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
        }

        bw.write(dp[k] == MAX_VALUE ? "-1" : Integer.toString(dp[k]));

        br.close();
        bw.flush();
        bw.close();
    }
}
