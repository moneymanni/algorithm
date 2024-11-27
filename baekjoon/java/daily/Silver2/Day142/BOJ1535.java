package Silver2.Day142;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = 99;

        Thank[] thanks = new Thank[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            thanks[i] = new Thank(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (thanks[i].damage <= j)
                    dp[i][j] = Math.max(dp[i - 1][j - thanks[i].damage] + thanks[i].pleasure, dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        bw.write(dp[N][K] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Thank {
        int damage;
        int pleasure;

        public Thank(int damage, int pleasure) {
            this.damage = damage;
            this.pleasure = pleasure;
        }
    }
}
