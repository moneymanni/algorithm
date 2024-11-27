package Gold5.Day185;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {
    private static final int EMPTY_SPACE = 0;
    private static final int WALL = 1;
    private static final int SWORD_GRAM = 2;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, M, T;
    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];  // 0: no Gram, 1: has Gram

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int minTime = BFS(0, 0, N - 1, M - 1);

        if (minTime >= 0 && minTime <= T)
            bw.write(minTime + "\n");
        else
            bw.write("Fail\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int startX, int startY, int endX, int endY) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(startX, startY, 0, false));
        visited[startX][startY][0] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if(curr.time > T) break;
            if (curr.x == endX && curr.y == endY) return curr.time;

            for (int i = 0; i < DX.length; i++) {
                int nx = curr.x + DX[i];
                int ny = curr.y + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (curr.hasGram) {
                        if (!visited[nx][ny][1]) {
                            queue.offer(new Point(nx, ny, curr.time + 1, curr.hasGram));
                            visited[nx][ny][1] = true;
                        }
                    } else {
                        if (!visited[nx][ny][0] && map[nx][ny] == EMPTY_SPACE) {
                            queue.offer(new Point(nx, ny, curr.time + 1, curr.hasGram));
                            visited[nx][ny][0] = true;
                        } else if (!visited[nx][ny][0] && map[nx][ny] == SWORD_GRAM) {
                            queue.offer(new Point(nx, ny, curr.time + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int x;
        int y;
        int time;
        boolean hasGram;

        public Point(int x, int y, int time, boolean hasGram) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.hasGram = hasGram;
        }
    }
}
