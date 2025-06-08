package StepByStep.dpandtraceback;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2618 {

    private static final int FIRST_POLICE_CAR = 1;
    private static final int SECOND_POLICE_CAR = 2;

    private static int N, W;
    private static Point[] points;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        points = new Point[W + 1];
        dp = new int[W + 1][W + 1];

        points[0] = new Point(0, 0);

        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        bw.write(DFS(1, 0, 0) + "\n");

        int first = 0;
        int second = 0;

        for (int i = 1; i <= W; i++) {
            int dist = getDistance(FIRST_POLICE_CAR, first, i);

            if (dp[first][second] - dist == dp[i][second]) {
                first = i;
                bw.write(FIRST_POLICE_CAR + "\n");
            } else {
                second = i;
                bw.write(SECOND_POLICE_CAR + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int DFS(int event, int one, int two) {
        if (event > W) return 0;

        if (dp[one][two] != 0) {
            return dp[one][two];
        }

        int first = DFS(event + 1, event, two) + getDistance(FIRST_POLICE_CAR, one, event);
        int second = DFS(event + 1, one, event) + getDistance(SECOND_POLICE_CAR, two, event);

        return dp[one][two] = Math.min(first, second);
    }

    private static int getDistance(int type, int start, int end) {
        Point from = new Point(points[start].x, points[start].y);
        Point to = new Point(points[end].x, points[end].y);

        if (start == 0) {
            if (type == FIRST_POLICE_CAR) {
                from = new Point(1, 1);
            } else if (type == SECOND_POLICE_CAR) {
                from = new Point(N, N);
            }
        }

        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
