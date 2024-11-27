package Silver1.Day163;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3187 {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};
    private static int R, C;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j);
        }

        int wolf = 0;
        int sheep = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    int[] info = BFS(i, j);
                    int localWolf = info[0];
                    int localSheep = info[1];

                    if (localSheep > localWolf)
                        sheep += localSheep;
                    else
                        wolf += localWolf;
                }
            }
        }

        bw.write(String.format("%d %d", sheep, wolf));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int[] BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        int wolf = 0;
        int sheep = 0;

        if (map[x][y] == 'v') wolf++;
        if (map[x][y] == 'k') sheep++;

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int cx = info[0];
            int cy = info[1];

            for (int i = 0; i < DX.length; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] != '#' && !visited[nx][ny]) {
                        if (map[nx][ny] == 'v') wolf++;
                        if (map[nx][ny] == 'k') sheep++;

                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return new int[]{wolf, sheep};
    }
}
