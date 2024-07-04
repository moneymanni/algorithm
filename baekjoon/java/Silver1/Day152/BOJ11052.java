package Silver1.Day152;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11052 {
    private static int N;
    private static int[] dp;
    private static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        P = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        buyCardPack();

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void buyCardPack() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }
    }
}
