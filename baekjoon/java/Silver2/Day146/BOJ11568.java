package Silver2.Day146;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11568 {
    private static int[] cards, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        cards = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        countMaxIncrease(N);

        int max = dp[0];

        for (int i = 1; i < N; i++)
            max = Math.max(max, dp[i]);

        bw.write(Integer.toString(max));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void countMaxIncrease(int N) {
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (cards[j] < cards[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
}
