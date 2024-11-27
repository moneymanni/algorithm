package Silver1.Day150;

import java.io.*;

public class BOJ2156 {
    private static int[] dp;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(br.readLine());

        drinkWine(N);

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void drinkWine(int N) {
        dp = new int[N + 1];

        dp[1] = A[1];
        if (N > 1) dp[2] = A[1] + A[2];

        for (int i = 3; i <= N; i++)
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i - 1] + A[i]));
    }
}
