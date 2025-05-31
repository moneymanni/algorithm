package StepByStep.shortestpath;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {

    private static final long INF = Long.MAX_VALUE;

    private static int N, M;
    private static long[] dist;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        edges = new Edge[M + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(A, B, C);
        }

        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if (dist[edge.start] != INF
                        && dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;
                }
            }
        }

        boolean check = isCycle();

        if (!check) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i] + "\n");
                }
            }
        } else {
            bw.write("-1\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isCycle() {
        boolean isCycle = false;

        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];

            if (dist[edge.start] != INF
                    && dist[edge.end] > dist[edge.start] + edge.cost) {
                isCycle = true;
            }
        }
        return isCycle;
    }

    private static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
