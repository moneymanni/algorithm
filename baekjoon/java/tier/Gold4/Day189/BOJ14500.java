package Gold4.Day189;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14500 {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, M;
    private static int maxValue;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        bw.write(maxValue + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, int sum, int depth) {
        if (depth == 4) {
            maxValue = Math.max(maxValue, sum);

            return;
        }

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny]) {
                    if (depth == 2) {
                        visited[nx][ny] = true;
                        DFS(x, y, sum + map[nx][ny], depth + 1);
                        visited[nx][ny] = false;
                    }

                    visited[nx][ny] = true;
                    DFS(nx, ny, sum + map[nx][ny], depth + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
