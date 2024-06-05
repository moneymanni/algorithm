package Silver2.Day135;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11048 {
    private static int N, M;
    private static int[][] map, dp;
    private static int[] dx = new int[]{0, -1, -1};
    private static int[] dy = new int[]{-1, 0, -1};

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

        dynamic();

        bw.write(dp[N][M] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamic() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = map[i][j];

                for (int k = 0; k < 3; k++) {
                    int currX = j + dx[k];
                    int currY = i + dy[k];

                    if (currX > 0 && currY > 0 && currX <= M && currY <= N)
                        dp[i][j] = Math.max(dp[i][j], dp[currY][currX] + map[i][j]);
                }
            }
        }
    }
}
