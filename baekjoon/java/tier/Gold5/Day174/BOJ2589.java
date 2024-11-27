package Gold5.Day174;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int width, height;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new char[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String input = br.readLine();

            for (int j = 0; j < width; j++)
                map[i][j] = input.charAt(j);  // L: 육지, W: 바다
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[height][width];

                    int value = BFS(i, j);

                    maxValue = Math.max(maxValue, value);
                }
            }
        }

        bw.write(Integer.toString(maxValue));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        Point maxPoint = new Point(x, y, 0);
        
        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (maxPoint.time < point.time)
                maxPoint = new Point(point.x, point.y, point.time);

            for (int i = 0; i < DX.length; i++) {
                int nx = point.x + DX[i];
                int ny = point.y + DY[i];

                if (nx >= 0 && nx < height && ny >= 0 && ny < width) {
                    if (!visited[nx][ny] && map[nx][ny] == 'L') {
                        queue.offer(new Point(nx, ny, point.time + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return maxPoint.time;
    }


    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
