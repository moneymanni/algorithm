package Gold5.Day183;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5972 {
    private static int N, M;
    private static int[] dist;
    private static ArrayList<Edge>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, 50_000_001);

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[startNode].add(new Edge(endNode, weight));
            list[endNode].add(new Edge(startNode, weight));
        }

        dijkstra();

        bw.write(dist[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge currEdge = pq.poll();

            if (visited[currEdge.targetNode]) continue;

            visited[currEdge.targetNode] = true;

            for (Edge nextEdge : list[currEdge.targetNode]) {
                if (dist[nextEdge.targetNode] > dist[currEdge.targetNode] + nextEdge.weight) {
                    dist[nextEdge.targetNode] = dist[currEdge.targetNode] + nextEdge.weight;
                    pq.offer(new Edge(nextEdge.targetNode, dist[nextEdge.targetNode]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int targetNode;
        int weight;

        public Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge obj) {
            return this.weight - obj.weight;
        }
    }
}
