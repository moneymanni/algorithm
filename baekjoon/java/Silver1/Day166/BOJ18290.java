package Silver1.Day166;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18290 {
    private static final int[] DX = new int[]{-1, 1, 0, 0};
    private static final int[] DY = new int[]{0, 0, -1, 1};

    private static int N, M, K;
    private static int result;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0, 0);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean check(int x, int y) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (visited[nx][ny]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private static void DFS(int x, int y, int num, int depth) {
        if (depth == K) {
            result = Math.max(result, num);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = y; j < M; j++) {
                if (!visited[i][j]) {
                    if (check(i, j)) {
                        visited[i][j] = true;
                        DFS(x, y, num + map[i][j], depth + 1);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }
}
