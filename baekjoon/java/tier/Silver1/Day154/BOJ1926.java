package Silver1.Day154;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1926 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int area;
    private static int[][] painting;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        painting = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                painting[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (painting[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    area = 1;
                    DFS(i, j);
                    max = Math.max(max, area);
                }
            }
        }

        bw.write(String.format("%d\n%d", cnt, max));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (painting[nx][ny] == 1 && !visited[nx][ny]) {
                    area++;
                    DFS(nx, ny);
                }
            }
        }
    }
}
