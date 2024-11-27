package Gold5.Day171;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2293 {
    private static int[] coin;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coin = new int[n + 1];
        dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());

            for (int j = coin[i]; j <= k; j++)
                dp[j] += dp[j - coin[i]];
        }

        bw.write(dp[k] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
