package doIt.day254;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14501 {

    private static int N;
    private static int[] dp;
    private static Counsel[] counsels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 2];
        counsels = new Counsel[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            counsels[i] = new Counsel(T, P);
        }

        for (int i = N; i > 0; i--) {
            if (i + counsels[i].time > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], counsels[i].price + dp[i + counsels[i].time]);
            }
        }

        bw.write(dp[1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Counsel {
        int time;
        int price;

        public Counsel(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }
}
