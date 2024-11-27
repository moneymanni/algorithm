package Silver1.Day166;

import java.io.*;
import java.util.Arrays;

public class BOJ1660 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        solve(N);

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void solve(int N) {
        int[] tempArr1 = new int[122];
        int[] tempArr2 = new int[122];

        tempArr1[1] = tempArr2[1] = 1;

        for (int i = 2; i < 122; i++) {
            tempArr1[i] = tempArr1[i - 1] + i;
            tempArr2[i] = tempArr1[i] + tempArr2[i - 1];
        }

        dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 122; j++) {
                if (tempArr2[j] > i)
                    break;

                dp[i] = Math.min(dp[i], dp[i - tempArr2[j]] + 1);
            }
        }
    }
}
