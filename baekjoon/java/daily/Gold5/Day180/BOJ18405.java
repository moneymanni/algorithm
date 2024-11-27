package Gold5.Day180;

import java.io.*;
import java.util.*;

public class BOJ18405 {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, K, S, X, Y;
    private static int[][] testTube;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        testTube = new int[N + 1][N + 1];
        List<Point> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                testTube[i][j] = Integer.parseInt(st.nextToken());

                if (testTube[i][j] != 0)
                    list.add(new Point(i, j, testTube[i][j], 0));
            }
        }

        list.sort(Comparator.comparingInt(p -> p.virusNum));

        queue = new LinkedList<>(list);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        String result = String.valueOf(BFS());

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == X && point.y == Y) {
                if (point.time <= S)
                    return point.virusNum;
                else
                    return 0;
            }

            for (int i = 0; i < DX.length; i++) {
                int nx = point.x + DX[i];
                int ny = point.y + DY[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                    if (testTube[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny, point.virusNum, point.time + 1));
                        testTube[nx][ny] = point.virusNum;
                    }
                }
            }
        }

        return 0;
    }

    static class Point {
        int x;
        int y;
        int virusNum;
        int time;

        public Point(int x, int y, int virusNum, int time) {
            this.x = x;
            this.y = y;
            this.virusNum = virusNum;
            this.time = time;
        }
    }
}
