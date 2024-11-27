package Silver3.Day109;

import java.io.*;

public class BOJ9095 {
    static int dp[] = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i <= 10; i++)
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];  // 점화식

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
