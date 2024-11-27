package Silver1.Day162;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14716 {
    private static final int[] DX = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] DY = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    private static int N, M;
    private static int[][] banner;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        banner = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                banner[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j =0; j < N; j++) {
                if (!visited[i][j] && banner[i][j] == 1) {
                    visited[i][j] = true;
                    DFS(i, j);
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && banner[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    DFS(nx, ny);
                }
            }
        }
    }
}
