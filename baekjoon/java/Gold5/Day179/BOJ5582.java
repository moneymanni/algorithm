package Gold5.Day179;

import java.io.*;

public class BOJ5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        String result = Integer.toString(findLongestCommonSubstring(s, t));

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findLongestCommonSubstring(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        int max = 0;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
