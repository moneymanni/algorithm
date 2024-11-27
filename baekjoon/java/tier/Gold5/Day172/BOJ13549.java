package Gold5.Day172;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    private static final int MAX_VALUE = 100_000;
    private static int N, K;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        BFS();

        bw.write(String.valueOf(min));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_VALUE + 1];

        queue.add(new Point(N, 0));

        while (!queue.isEmpty()) {
            Point point = queue.remove();
            visited[point.x] = true;

            if (point.x == K)
                min = Math.min(min, point.time);

            if (point.x * 2 <= MAX_VALUE && !visited[point.x * 2])
                queue.add(new Point(point.x * 2, point.time));
            if (point.x + 1 <= MAX_VALUE && !visited[point.x + 1])
                queue.add(new Point(point.x + 1, point.time + 1));
            if (point.x - 1 >= 0 && !visited[point.x - 1])
                queue.add(new Point(point.x - 1, point.time + 1));
        }

    }
}

class Point {
    int x;
    int time;

    public Point(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
