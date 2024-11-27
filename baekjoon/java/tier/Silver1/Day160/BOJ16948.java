package Silver1.Day160;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16948 {
    private static final int[] DX = new int[]{-2, -2, 0, 0, 2, 2};
    private static final int[] DY = new int[]{-1, 1, -2, 2, -1, 1};
    private static int N;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        Point start = new Point(r1, c1);
        Point end = new Point(r2, c2);

        int result = BFS(start, end);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(Point start, Point end) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start.x, start.y, 0});
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int x = info[0];
            int y = info[1];
            int cnt = info[2];

            if (x == end.x && y == end.y)
                return cnt;

            for (int i = 0; i < DX.length; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (nx >= 0 && nx <= N && ny >= 0 && ny <= N) {
                    if (!visited[nx][ny]) {
                        queue.add(new int[]{nx, ny, cnt + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
