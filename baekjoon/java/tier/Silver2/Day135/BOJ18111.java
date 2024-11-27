package Silver2.Day135;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18111 {
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        dp = new int[21][21][21];

        dynamic();

        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("-1 -1 -1")) {
            st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int result = 0;

            if (a <= 0 || b <= 0 || c <= 0)
                result = 1;
            else if (a > 20 || b > 20 || c > 20)
                result = dp[20][20][20];
            else
                result = dp[a][b][c];

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic() {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                        continue;
                    }

                    if (i < j && j < k)
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] + dp[i][j - 1][k];

                    dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }
    }
}
