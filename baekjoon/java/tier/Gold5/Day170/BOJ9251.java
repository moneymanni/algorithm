package Gold5.Day170;

import java.io.*;

public class BOJ9251 {
    private static char[] str1, str2;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = br.readLine();
        String input2 = br.readLine();

        str1 = input1.toCharArray();
        str2 = input2.toCharArray();

        dp = new Integer[str1.length][str2.length];

        int result = LCS(str1.length - 1, str2.length - 1);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int LCS(int x, int y) {
        if (x == -1 || y == -1)
            return 0;

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (str1[x] == str2[y])
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            else
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
        }

        return dp[x][y];
    }
}
