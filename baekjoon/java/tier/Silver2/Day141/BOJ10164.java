package Silver2.Day141;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10164 {
    private static final int[] DX = new int[]{0, 1};
    private static final int[] DY = new int[]{1, 0};
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;

        if (K == 0) {
            ans = getRoute(N - 1, M - 1);
        } else {
            int x = (K - 1) / M;
            int y = (K - 1) % M;

            int firstRoute = getRoute(x, y);
            int secondRoute = getRoute(N - x - 1, M - y - 1);

            ans = firstRoute * secondRoute;
        }

        bw.write(ans + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getRoute(int x, int y) {
        dp = new int[++x][++y];

        dp[0][0] = 1;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < 2; k++) {
                    int currX = i + DX[k];
                    int currY = j + DY[k];

                    if (currX >= x || currY >= y)
                        continue;

                    dp[currX][currY] += dp[i][j];
                }
            }
        }

        return dp[x - 1][y - 1];
    }
}
