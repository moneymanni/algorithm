package Gold5.Day181;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13398 {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        String result = String.valueOf(func(arr));

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static int func(int[] arr) {
        int len = arr.length - 1;

        dp = new int[len + 1][2];

        int maxValue = arr[1];
        dp[1][0] = dp[1][1] = arr[1];

        for (int i = 2; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            maxValue = Math.max(maxValue, Math.max(dp[i][0], dp[i][1]));
        }

        return maxValue;
    }
}
