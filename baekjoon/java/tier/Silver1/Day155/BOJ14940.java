package Silver1.Day155;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;
    private static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];

        int[] startPoint = new int[]{-1, -1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    startPoint = new int[]{i, j};
            }
        }

        BFS(startPoint[0], startPoint[1]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0 && map[i][j] == 1)
                    sb.append(-1).append(' ');
                else
                    sb.append(copyMap[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y, 0});
        copyMap[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int cx = info[0];
            int cy = info[1];
            int cnt = info[2];

            for (int i = 0; i < DX.length; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && copyMap[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny, cnt + 1});
                        copyMap[nx][ny] = cnt + 1;
                    }
                }
            }
        }
    }
}
