package StepByStep.dpandtraceback;

import java.io.*;

public class BOJ12852 {

    private static int N;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            arr[i] = i - 1;
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                arr[i] = i / 3;
                dp[i] = dp[i / 3] + 1;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                arr[i] = i / 2;
                dp[i] = dp[i / 2] + 1;
            }
        }

        bw.write(dp[N] + "\n");

        while (N > 0) {
            bw.write(N + " ");
            N = arr[N];
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
