package Gold5.Day173;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int numPowerLines = Integer.parseInt(br.readLine());

        int[][] powerLines = new int[numPowerLines][2];

        for (int i = 0; i < numPowerLines; i++) {
            st = new StringTokenizer(br.readLine());
            powerLines[i][0] = Integer.parseInt(st.nextToken());
            powerLines[i][1] = Integer.parseInt(st.nextToken());
        }

        Integer[] dp = new Integer[numPowerLines];

        Arrays.sort(powerLines, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (powerLines[i][1] > powerLines[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);

        bw.write(String.valueOf(numPowerLines - max));

        br.close();
        bw.flush();
        bw.close();
    }
}
