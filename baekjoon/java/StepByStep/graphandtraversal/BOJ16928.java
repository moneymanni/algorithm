package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {

    private static final int SIZE = 100;

    private static int N, M;
    private static int minCnt;
    private static int[] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minCnt = -1;
        map = new int[SIZE + 1];
        visited = new boolean[SIZE + 1];

        for (int i = 1; i <= SIZE; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        BFS(1);

        bw.write(minCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(v, 0));
        visited[v] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.idx == SIZE) {
                minCnt = point.cnt;
                return;
            }

            for (int i = 6; i >= 1; i--) {
                int nextIdx = point.idx + i;

                if (nextIdx <= SIZE && !visited[map[nextIdx]]) {
                    queue.add(new Point(map[nextIdx], point.cnt + 1));
                    visited[map[nextIdx]] = true;
                }
            }
        }
    }

    private static class Point {
        int idx;
        int cnt;

        public Point(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
