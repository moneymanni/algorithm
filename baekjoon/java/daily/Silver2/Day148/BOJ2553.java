package Silver2.Day148;

import java.io.*;

public class BOJ2553 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dynamicProgramming(N);

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int N) {
        dp = new int[N + 1];

        if (N >= 1) dp[0] = dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        if (N >= 3) dp[3] = 6;
        if (N >= 4) dp[4] = 4;

        for (int i = 5; i <= N; i++) {
            if (i % 5 == 0) {
                int temp = i / 5;
                dp[i] = ((int) Math.pow(2, temp % 4) * dp[temp]) % 10;
            } else {
                int temp = (i / 5) * 5;
                int total = 1;

                for (int j = i; j > temp; j--)
                    total *= (j % 10);

                dp[i] = (total * dp[temp]) % 10;
            }
        }
    }
}
