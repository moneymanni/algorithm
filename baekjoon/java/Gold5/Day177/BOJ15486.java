package Gold5.Day177;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Counseling[] counselings = new Counseling[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            counselings[i] = new Counseling(T, P);
        }

        counselings[N + 1] = new Counseling(0, 0);

        int result = func(counselings);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int func(Counseling[] counselings) {
        int len = counselings.length - 2;
        int[] dp = new int[len + 2];

        int max = -1;

        for (int i = 1; i <= len + 1; i++) {
            max = Math.max(max, dp[i]);

            int next = i + counselings[i].duration;

            if (next <= len + 1)
                dp[next] = Math.max(dp[next], max + counselings[i].payment);
        }

        return dp[len + 1];
    }

    static class Counseling {
        int duration;
        int payment;

        public Counseling(int duration, int payment) {
            this.duration = duration;
            this.payment = payment;
        }
    }
}
