package Gold5.Day175;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9205 {
    private static final int MAX_DIST = 1_000;

    private static int n;
    private static Point startPoint, endPoint;
    private static Point[] points;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            points = new Point[n];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            startPoint = new Point(x, y);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            endPoint = new Point(x, y);

            boolean canArrive = BFS();

            bw.write(canArrive ? "happy\n" : "sad\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean BFS() {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(startPoint.x, startPoint.y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (Math.abs(point.x - endPoint.x) + Math.abs(point.y - endPoint.y) <= MAX_DIST) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                int gap = Math.abs(point.x - points[i].x) + Math.abs(point.y - points[i].y);

                if (!visited[i] && gap <= MAX_DIST) {
                    queue.offer(new Point(points[i].x, points[i].y));
                    visited[i] = true;
                }
            }
        }

        return false;
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
