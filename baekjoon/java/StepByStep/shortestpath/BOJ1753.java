package StepByStep.shortestpath;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

    private static int V, E, K;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Edge>[] graph;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visited = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                bw.write(dist[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start) {
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            int currNode = curr.target;

            if (visited[currNode]) {
                continue;
            }

            visited[currNode] = true;

            for (Edge next : graph[currNode]) {
                int nextNode = next.target;

                if (dist[nextNode] > dist[currNode] + next.cost) {
                    dist[nextNode] = dist[currNode] + next.cost;
                    pq.add(new Edge(nextNode, dist[nextNode]));
                }
            }
        }
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
