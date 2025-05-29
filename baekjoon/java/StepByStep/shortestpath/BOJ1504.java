package StepByStep.shortestpath;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {

    private static final int INF = 200_000_000;

    private static int N, E;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Edge>[] graph;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0, res2 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int minLen = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        bw.write(minLen + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            for (Edge next : graph[curr.target]) {
                if (dist[next.target] > dist[curr.target] + next.cost) {
                    dist[next.target] = dist[curr.target] + next.cost;
                    pq.offer(new Edge(next.target, dist[next.target]));
                }
            }
        }

        return dist[end];
    }

    private static class Edge implements Comparable<Edge> {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
