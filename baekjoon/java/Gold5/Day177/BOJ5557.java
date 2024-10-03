package Gold5.Day177;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5557 {
    private static int N;
    private static int[] nums;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        dp = new long[N][21];

        dp[0][nums[0]] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] == 0) continue;

                int plus = j + nums[i];
                int minus = j - nums[i];

                if (plus >= 0 && plus <= 20)
                    dp[i][plus] += dp[i - 1][j];

                if (minus >= 0 && minus <= 20)
                    dp[i][minus] += dp[i - 1][j];
            }
        }

        bw.write(String.valueOf(dp[N - 2][nums[N - 1]]));

        br.close();
        bw.flush();
        bw.close();
    }
}
