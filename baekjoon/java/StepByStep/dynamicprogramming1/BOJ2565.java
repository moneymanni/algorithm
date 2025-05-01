package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());

        int[][] powerLine = new int[cnt][2];

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            powerLine[i][0] = Integer.parseInt(st.nextToken());
            powerLine[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[cnt];

        Arrays.sort(powerLine, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (powerLine[i][1] > powerLine[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write((cnt - max) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
