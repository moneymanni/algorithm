package Gold4.Day189;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

    private static final int INF = 100_000_000;

    private static int V, E, K;
    private static int[] dist;
    private static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        graph = new ArrayList[V + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                sb.append("INF");
            else
                sb.append(dist[i]);
            sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];

        pq.offer(new Node(startNode, 0));
        dist[startNode] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();

            if (visited[currNode.targetNode])
                continue;

            visited[currNode.targetNode] = true;

            for (Node nextNode : graph[currNode.targetNode]) {
                if (dist[nextNode.targetNode] > dist[currNode.targetNode] + nextNode.weight) {
                    dist[nextNode.targetNode] = dist[currNode.targetNode] + nextNode.weight;
                    pq.offer(new Node(nextNode.targetNode, dist[nextNode.targetNode]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int targetNode;
        int weight;

        public Node(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node obj) {
            return Integer.compare(this.weight, obj.weight);
        }
    }
}
