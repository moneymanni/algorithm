package StepByStep.treedp;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15647 {

    private static int N;
    private static int[] subtreeSize;
    private static long[] distSum;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        subtreeSize = new int[N + 1];
        distSum = new long[N + 1];

        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, d));
            graph[v].add(new Edge(u, d));
        }

        DFS1(1, 0, 0);
        DFS2(1, 0);

        for (int i = 1; i <= N; i++) {
            bw.write(distSum[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS1(int node, int parent, long accDist) {
        distSum[1] += accDist;
        subtreeSize[node] = 1;

        for (Edge edge : graph[node]) {
            if (edge.target != parent) {
                DFS1(edge.target, node, accDist + edge.dist);
                subtreeSize[node] += subtreeSize[edge.target];
            }
        }
    }

    private static void DFS2(int node, int parent) {
        for (Edge edge : graph[node]) {
            if (edge.target != parent) {
                distSum[edge.target] = distSum[node] + (long) edge.dist
                        * (N - 2L * subtreeSize[edge.target]);
                DFS2(edge.target, node);
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int target;
        int dist;

        public Edge(int target, int dist) {
            this.target = target;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.dist, obj.dist);
        }
    }

}
