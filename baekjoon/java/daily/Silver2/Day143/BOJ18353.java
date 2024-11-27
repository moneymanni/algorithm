package Silver2.Day143;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18353 {
    private static int[] soldiers;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        soldiers = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++)
            soldiers[i] = Integer.parseInt(st.nextToken());

        dynamic(N);

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, dp[i]);

        int answer = N - max;
        bw.write( answer + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic(int N) {
        if (N >= 1)
            dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (soldiers[i] < soldiers[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
}
