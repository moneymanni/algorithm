package Silver1.Day157;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16194 {
    private static int[] P;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        P = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        buyCardPacks(N);

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void buyCardPacks(int num) {
        dp = new int[num + 1];

        for (int i = 1; i <= num; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i - j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
            }
        }
    }
}
