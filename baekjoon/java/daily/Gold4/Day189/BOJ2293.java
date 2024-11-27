package Gold4.Day189;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2293 {

    private static int n, k;
    private static int[] coin;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n + 1];

        for (int i = 1; i <= n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        bw.write(dynamic() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int dynamic() {
        dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = coin[i]; j <= k; j++)
                dp[j] += dp[j - coin[i]];

        return dp[k];
    }
}
