package StepByStep.dynamicprogramming2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2629 {

    private static final int MAX_NUM = 40_000;

    private static int numWeights, numBeads;
    private static int[] weights, beads;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        numWeights = Integer.parseInt(br.readLine());

        weights = new int[numWeights];
        dp = new boolean[numWeights + 1][MAX_NUM + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numWeights; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        numBeads = Integer.parseInt(br.readLine());

        beads = new int[numBeads];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numBeads; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, 0);

        for (int bead : beads) {
            bw.write(dp[numWeights][bead] ? "Y ": "N ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void recursion(int cnt, int num) {
        if (dp[cnt][num]) {
            return;
        }

        dp[cnt][num] = true;

        if (cnt == numWeights) {
            return;
        }

        recursion(cnt + 1, num + weights[cnt]);
        recursion(cnt + 1, num);
        recursion(cnt + 1, Math.abs(num - weights[cnt]));
    }
}
