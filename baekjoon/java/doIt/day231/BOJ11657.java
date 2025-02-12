package doIt.day231;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {

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

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, time);
        }

        // 벨만-포트 알고리즘
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if (dist[edge.start] != Integer.MAX_VALUE
                        && dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                }
            }
        }

        boolean isCycle = false;

        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (dist[edge.start] != Integer.MAX_VALUE
                    && dist[edge.end] > dist[edge.start] + edge.time) {
                isCycle = true;
            }
        }

        if (!isCycle) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
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

    private static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
