package StepByStep.dynamicprogramming2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            int[] pages = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                pages[i] = Integer.parseInt(st.nextToken()) + pages[i - 1];
            }

            for (int i = 1; i < K; i++) {
                for (int start = 1; start + i <= K; start++) {
                    int end = i + start;

                    dp[start][end] = Integer.MAX_VALUE;

                    for (int t = start; t < end; t++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][t] + dp[t + 1][end] + pages[end] - pages[start - 1]);
                    }
                }
            }

            bw.write(dp[1][K] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
