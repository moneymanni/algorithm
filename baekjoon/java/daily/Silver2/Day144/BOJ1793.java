package Silver2.Day144;

import java.io.*;
import java.math.BigInteger;

public class BOJ1793 {
    private static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tiling(250);

        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);

            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void tiling(int num) {
        dp = new BigInteger[num + 1];

        if (num >= 0)
            dp[0] = BigInteger.ONE;
        if (num >= 1)
            dp[1] = BigInteger.ONE;

        for (int i = 2; i <= num; i++)
            dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
    }
}
