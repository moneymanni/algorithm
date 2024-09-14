package Gold5.Day169;

import java.io.*;

public class BOJ10026 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N;
    private static char[][] painting;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        painting = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++)
                painting[i][j] = input.charAt(j);
        }

        visited = new boolean[N][N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    countAreas(i, j, painting[i][j]);
                    cnt++;
                }
            }
        }

        visited = new boolean[N][N];
        int cntColorBlind = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    countColorBlindAreas(i, j, painting[i][j]);
                    cntColorBlind++;
                }
            }
        }

        bw.write(String.format("%d %d", cnt, cntColorBlind));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void countAreas(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && painting[nx][ny] == color) {
                    countAreas(nx, ny, color);
                }
            }
        }
    }

    private static void countColorBlindAreas(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny]) {
                    if (painting[nx][ny] == color
                            || (painting[nx][ny] == 'R' && color == 'G')
                            || (painting[nx][ny] == 'G' && color == 'R')) {
                        countColorBlindAreas(nx, ny, color);
                    }
                }
            }
        }
    }
}
