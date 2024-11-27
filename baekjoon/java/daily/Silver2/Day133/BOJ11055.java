package Silver2.Day133;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11055 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        dp = new int[N];

        dynamic(A, N);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            max = Math.max(max, dp[i]);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic(int[] arr, int N) {
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
            }
        }
    }
}
