package Silver2.Day137;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1965 {
    private static int[] nums, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        nums = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

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
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
}
