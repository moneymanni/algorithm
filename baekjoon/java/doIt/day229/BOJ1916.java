package doIt.day229;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {

    private static int N, M;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(startCity, 0));
        dist[startCity] = 0;

        while (!pq.isEmpty()) {
            Edge currEdge = pq.poll();
            int curr = currEdge.target;

            if (!visited[curr]) {
                visited[curr] = true;

                for (Edge edge : graph[curr]) {
                    int next = edge.target;
                    int cost = edge.cost;

                    if (!visited[next] && dist[next] > dist[curr] + cost) {
                        dist[next] = dist[curr] + cost;
                        pq.add(new Edge(next, dist[next]));
                    }
                }
            }
        }

        bw.write(dist[endCity] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Edge implements Comparable<Edge> {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.cost, obj.cost);
        }
    }
}
