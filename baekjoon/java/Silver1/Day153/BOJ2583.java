package Silver1.Day153;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int cnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Integer> areas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        areas = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++)
                for (int x = x1; x < x2; x++)
                    map[y][x] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    cnt = 0;
                    DFS(i, j);
                    areas.add(cnt);
                }
            }
        }

        Collections.sort(areas);

        StringBuilder sb = new StringBuilder();

        sb.append(areas.size()).append('\n');
        for (int i : areas)
            sb.append(i).append(' ');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for (int k = 0; k < DX.length; k++) {
            int nx = x + DX[k];
            int ny = y + DY[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
