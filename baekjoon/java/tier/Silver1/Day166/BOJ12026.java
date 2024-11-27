package Silver1.Day166;

import java.io.*;
import java.util.Arrays;

public class BOJ12026 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] arr = str.toCharArray();

        solve(N, arr);

        bw.write((dp[N - 1] == Integer.MAX_VALUE) ? "-1" : Integer.toString(dp[N - 1]));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void solve(int N, char[] arr) {
        dp = new int[N];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    if (arr[i] == 'O' && arr[j] == 'B')
                        dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                    else if (arr[i] == 'J' && arr[j] == 'O')
                        dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                    else if (arr[i] == 'B' && arr[j] == 'J')
                        dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
            }
        }
    }
}
