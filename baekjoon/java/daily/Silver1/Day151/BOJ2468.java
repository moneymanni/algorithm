package Silver1.Day151;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2468 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int total = 0;

        for (int height = 0; height <= maxHeight; height++) {
            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > height && !visited[i][j]) {
                        DFS(i, j, height);
                        cnt++;
                    }
                }
            }

            total = Math.max(total, cnt);
        }

        bw.write(total + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] > height && !visited[nx][ny]) {
                    DFS(nx, ny, height);
                }
            }
        }
    }
}
