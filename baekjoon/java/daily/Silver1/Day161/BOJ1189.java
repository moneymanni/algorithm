package Silver1.Day161;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1189 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int R, C, K;
    private static int count;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = 0;
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j);
        }

        Point start = new Point(R - 1, 0);

        visited[R - 1][0] = true;
        BFS(start, 1);

        bw.write(count + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(Point point, int depth) {
         if (depth == K) {
             Point end = new Point(0, C - 1);

             if (point.x == end.x && point.y == end.y)
                 count++;

             return;
         }

         for (int i = 0; i < DX.length; i++) {
             int nx = point.x + DX[i];
             int ny = point.y + DY[i];

             if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                 if (!visited[nx][ny] && map[nx][ny] != 'T') {
                     visited[nx][ny] = true;
                     BFS(new Point(nx, ny), depth + 1);
                     visited[nx][ny] = false;
                 }
             }
         }
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
