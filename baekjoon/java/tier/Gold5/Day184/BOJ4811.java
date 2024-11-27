package Gold5.Day184;

import java.io.*;

public class BOJ4811 {
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dynamicProgramming(30);

        String input;

        while (!(input = br.readLine()).equals("0")) {
            int num = Integer.parseInt(input);

            bw.write(dp[num] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int num) {
        dp = new long[num + 1];

        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= num; i++) {
            long temp = 0;

            for (int j = 0; j < i; j++)
                temp += dp[j] * dp[i - j - 1];

            dp[i] = temp;
        }
    }
}
