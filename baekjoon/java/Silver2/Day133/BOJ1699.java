package Silver2.Day133;

import java.io.*;

public class BOJ1699 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dynamicProgramming(N);

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int N) {
        for (int i = 1; i <= N; i++) {
            dp[i] = i;

            for (int j = 1; j * j <=i; j++) {
                if (dp[i] > dp[i - j * j] + 1)
                    dp[i] = dp[i - j * j] + 1;
            }
        }
    }
}
