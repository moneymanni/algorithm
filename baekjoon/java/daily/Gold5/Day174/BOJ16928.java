package Gold5.Day174;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {
    private static final int SIZE = 100;
    private static int N, M;
    private static int[] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[SIZE + 1];
        visited = new boolean[SIZE + 1];

        for (int i = 1; i <= SIZE; i++)
            map[i] = i;

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        int result = BFS(1);

        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int v) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(v, 0));
        visited[v] = true;

        while (!queue.isEmpty()) {
            Point point = queue.remove();

            if (point.index == SIZE)
                return point.count;

            for (int i = 6; i >= 1; i--) {
                int nextPoint = point.index + i;

                if (nextPoint <= SIZE && !visited[map[nextPoint]]) {
                    queue.add(new Point(map[nextPoint], point.count + 1));
                    visited[map[nextPoint]] = true;
                }
            }
        }

        return -1;
    }

    static class Point {
        int index;
        int count;

        public Point(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
