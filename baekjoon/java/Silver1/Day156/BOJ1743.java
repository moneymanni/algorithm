package Silver1.Day156;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1743 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M, K;
    private static int cnt;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i<= N; i++)
            Arrays.fill(map[i], '.');

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = '#';
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == '#' && !visited[i][j]) {
                    cnt = 0;
                    DFS(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                if (map[nx][ny] == '#' && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
