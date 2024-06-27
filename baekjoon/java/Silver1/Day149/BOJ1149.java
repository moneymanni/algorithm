package Silver1.Day149;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1149 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int result = BFS(0, 0);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int cx = info[0];
            int cy = info[1];
            int cnt = info[2];

            if (cx == N - 1 && cy == M - 1)
                return cnt;

            for (int i = 0; i < DX.length; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }

        return -1;
    }
}
