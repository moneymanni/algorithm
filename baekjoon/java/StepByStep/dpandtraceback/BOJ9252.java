package StepByStep.dpandtraceback;

import java.io.*;
import java.util.ArrayList;

public class BOJ9252 {

    private static char[] charsA, charsB;
    private static long[][] dp;
    private static ArrayList<Character> path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strA = br.readLine();
        String strB = br.readLine();

        charsA = strA.toCharArray();
        charsB = strB.toCharArray();

        dp = new long[charsA.length + 1][charsB.length + 1];
        path = new ArrayList<>();

        for (int i = 1; i <= charsA.length; i++) {
            for (int j = 1; j <= charsB.length; j++) {
                if (charsA[i - 1] == charsB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        getText(charsA.length, charsB.length);

        bw.write(dp[charsA.length][charsB.length] + "\n");

        for (int i = path.size() - 1; i >= 0; i--) {
            bw.write(path.get(i) + "");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }

    private static void getText(int r, int c) {
        if (r == 0 || c == 0) return;

        if (charsA[r - 1] == charsB[c - 1]) {
            path.add(charsA[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                getText(r - 1, c);
            } else {
                getText(r, c - 1);
            }
        }
    }
}
