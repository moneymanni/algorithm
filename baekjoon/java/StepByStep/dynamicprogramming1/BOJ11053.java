package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
