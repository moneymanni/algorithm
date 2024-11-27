package Silver2.Day129;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1912 {
    private static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dynamic(n);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic(int n) {
        dp[0] = arr[0];

        for (int i = 1; i < n; i++)
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
    }
}
