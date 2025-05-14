package StepByStep.dynamicprogramming2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1520 {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int M, N;
    private static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= M; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(DFS(1, 1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int DFS(int x, int y) {
        if (x == M && y == N) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int k = 0; k < 4; k++) {
            int dx = x + DX[k];
            int dy = y + DY[k];

            if (1 <= dx && dx <= M && 1 <= dy && dy <= N) {
                if (map[x][y] > map[dx][dy]) {
                    dp[x][y] += DFS(dx, dy);
                }
            }
        }

        return dp[x][y];
    }
}
