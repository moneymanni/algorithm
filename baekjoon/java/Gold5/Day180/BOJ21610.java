package Gold5.Day180;

import java.io.*;
import java.util.*;

public class BOJ21610 {
    private static final int[] DX = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1};

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Point> cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        cloud = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        cloud.offer(new Point(N - 1, 0));
        cloud.offer(new Point(N - 1, 1));
        cloud.offer(new Point(N - 2, 0));
        cloud.offer(new Point(N - 2, 1));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            rain(d, s);
            useWaterCopyBugMagic();
            useRainDanceMagic();
        }

        String result = String.valueOf(sumWaterInBaskets());

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void rain(int dir, int dist) {
        for (Point point : cloud) {
            point.x = (N + point.x + DX[dir] * (dist % N)) % N;
            point.y = (N + point.y + DY[dir] * (dist % N)) % N;
            map[point.x][point.y]++;
        }
    }

    private static void useWaterCopyBugMagic() {
        while (!cloud.isEmpty()) {
            Point point = cloud.poll();
            int cnt = 0;

            visited[point.x][point.y] = true;

            for (int i = 1; i < DX.length; i += 2) {
                int nx = point.x + DX[i];
                int ny = point.y + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N)
                    if (map[nx][ny] >= 1) cnt++;
            }

            map[point.x][point.y] += cnt;
        }
    }

    private static void useRainDanceMagic() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    cloud.offer(new Point(i, j));
                }
            }
        }

        visited = new boolean[N][N];
    }

    private static int sumWaterInBaskets() {
        int sum = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sum += map[i][j];

        return sum;
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
