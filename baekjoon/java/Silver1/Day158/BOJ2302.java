package Silver1.Day158;

import java.io.*;

public class BOJ2302 {
    private static final int MAX = 40;

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dynamic(MAX);

        int result = 1;
        int prev = 0;

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            result *= dp[num - prev - 1];
            prev = num;
        }
        result *= dp[N - prev];

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic(int N) {
        dp = new int[N + 1];

        if (N >= 1)
            dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
    }
}
