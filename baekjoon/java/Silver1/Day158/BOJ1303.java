package Silver1.Day158;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1303 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int cnt, maxCnt;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++)
                map[j][i] = input.charAt(j);
        }

        int whitePower = 0;
        int bluePower = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    char color = map[i][j];
                    maxCnt = 0;
                    cnt = 0;

                    DFS(i, j, color);

                    if (color == 'W')
                        whitePower += maxCnt * maxCnt;
                    else if (color == 'B')
                        bluePower += maxCnt * maxCnt;
                }
            }
        }

        bw.write(String.format("%d %d", whitePower, bluePower));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, char color) {
        visited[x][y] = true;

        cnt++;
        maxCnt = Math.max(maxCnt, cnt);

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == color && !visited[nx][ny]) {
                    DFS(nx, ny, color);
                }
            }
        }
    }
}
