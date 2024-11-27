package Gold4.Day191;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {

    private static int V, E;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }

        int result = prim(1);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int prim(int startNode) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int totalWeight = 0;
        boolean[] visited = new boolean[V + 1];

        pq.offer(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            int node = edge.targetNode;
            int weight = edge.weight;

            if (visited[node])
                continue;

            visited[node] = true;
            totalWeight += weight;

            for (Edge next : graph[node]) {
                if (!visited[next.targetNode])
                    pq.offer(next);
            }
        }

        return totalWeight;
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
            return Integer.compare(this.weight, obj.weight);
        }
    }
}
