package doit.day207;

import java.io.*;
import java.util.*;

public class BOJ1167 {

    private static int N;
    private static ArrayList<Edge>[] graph;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());

            int u;

            while ((u = Integer.parseInt(st.nextToken())) != -1) {
                int dest = Integer.parseInt(st.nextToken());

                graph[v].add(new Edge(u, dest));
            }
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1);

        int maxIdx = 1;

        for (int i = 2; i <= N; i++) {
            if (dist[maxIdx] < dist[i]) maxIdx = i;
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(maxIdx);

        Arrays.sort(dist);

        bw.write(dist[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Edge edge : graph[node]) {
                if (!visited[edge.target]) {
                    visited[edge.target] = true;
                    queue.add(edge.target);

                    dist[edge.target] = dist[node] + edge.weight;
                }
            }
        }
    }

    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
