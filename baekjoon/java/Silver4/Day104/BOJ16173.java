package Silver4.Day104;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16173 {
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static final int[] DX = {0, 1};
    public static final int[] DY = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        if (bfs())
            bw.write("HaruHaru");
        else
            bw.write("Hing");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == N - 1 && y == N - 1)
                return true;

            int jump = map[x][y];
            for (int i = 0; i < 2; i++) {
                int nx = x + DX[i] * jump;
                int ny = y + DY[i] * jump;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
