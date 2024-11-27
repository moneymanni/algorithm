package Silver2.Day147;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14430 {
    private static final int[] DX = new int[]{-1, 0};
    private static final int[] DY = new int[]{0, -1};

    private static int N, M;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        mineResources();

        bw.write(dp[N][M] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mineResources() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = map[i][j];

                for (int k = 0; k < DX.length; k++) {
                    int x = i + DX[k];
                    int y = j + DY[k];

                    if (x >= 1 && y >= 1 && x <= N && y <= M)
                        dp[i][j] = Math.max(dp[i][j], dp[x][y] + map[i][j]);
                }
            }
        }
    }
}
