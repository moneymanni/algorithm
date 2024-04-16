package Silver3.Day110;

import java.io.*;

public class BOJ9461 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        func(100);

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void func(int num) {
        dp = new long[num+1];

        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= num; i++)
            dp[i] = dp[i-2] + dp[i-3];
    }
}
