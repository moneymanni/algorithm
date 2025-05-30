package StepByStep.shortestpath;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549 {

    private static final int MAX_RANGE = 100_000;
    private static final int INF = 1_000_000_000;

    private static int N, K;
    private static int min;
    private static boolean[] visited;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        visited = new boolean[MAX_RANGE + 1];

        dijkstra(N, K);

        bw.write(min + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start, int end) {
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.target;
            int time = curr.cost;

            visited[x] = true;

            if (x == end) {
                min = Math.min(min, time);
            }

            if (x + 1 <= MAX_RANGE && !visited[x + 1]) {
                pq.add(new Node(x + 1, time + 1));
            }
            if (0 <= x - 1 && !visited[x - 1]) {
                pq.add(new Node(x - 1, time + 1));
            }
            if (x * 2 <= MAX_RANGE && !visited[x * 2]) {
                pq.add(new Node(x * 2, time));
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int target;
        int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
