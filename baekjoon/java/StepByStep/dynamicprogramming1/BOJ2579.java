package StepByStep.dynamicprogramming1;

import java.io.*;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int stairCount = Integer.parseInt(br.readLine());

        int[] stair = new int[stairCount + 1];
        int[] dp = new int[stairCount + 1];

        for (int i = 1; i <= stairCount; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (stairCount >= 1) dp[1] = stair[1];
        if (stairCount >= 2) dp[2] = stair[1] + stair[2];
        if (stairCount >= 3) dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= stairCount; i++) {
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
        }

        bw.write(dp[stairCount] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
