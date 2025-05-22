package StepByStep.graphandtraversal;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1012 {

    private static final int EMPTY = 0;
    private static final int CABBAGE = 1;
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int T, M, N, K;
    private static int cnt;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cnt = 0;
            map = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                map[X][Y] = CABBAGE;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == CABBAGE) {
                        cnt++;
                        DFS(i, j);
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < DX.length; k++) {
            int dx = x + DX[k];
            int dy = y + DY[k];

            if (0 <= dx && dx < M && 0 <= dy && dy < N) {
                if (!visited[dx][dy] && map[dx][dy] == CABBAGE) {
                    DFS(dx, dy);
                }
            }
        }
    }
}
