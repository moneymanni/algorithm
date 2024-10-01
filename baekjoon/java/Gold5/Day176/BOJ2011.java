package Gold5.Day176;

import java.io.*;

public class BOJ2011 {
    private static final int MOD = 1_000_000;
    private static final int ALPHABET_NUM = 26;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        dp = new int[input.length() + 1];

        dp[0] = 1;

        for (int i = 1; i <= input.length(); i++) {
            int curr = input.charAt(i - 1) - '0';

            if (curr >= 1 && curr <= ALPHABET_NUM)
                dp[i] = (dp[i] + dp[i - 1]) % MOD;

            if (i == 1) continue;

            int prev = input.charAt(i - 2) - '0';

            if (prev == 0) continue;

            int temp = prev * 10 + curr;

            if (temp >= 1 && temp <= ALPHABET_NUM)
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
        }

        bw.write(String.valueOf(dp[input.length()]));

        br.close();
        bw.flush();
        bw.close();
    }
}
