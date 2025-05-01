package StepByStep.dynamicprogramming1;

import java.io.*;

public class BOJ9251 {

    private static String str1, str2;
    private static char[] chars1, chars2;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine();
        str2 = br.readLine();

        chars1 = str1.toCharArray();
        chars2 = str2.toCharArray();

        dp = new Integer[chars1.length][chars2.length];

        int result = LCS(chars1.length - 1, chars2.length - 1);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (chars1[x] == chars2[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }

        return dp[x][y];
    }
}
