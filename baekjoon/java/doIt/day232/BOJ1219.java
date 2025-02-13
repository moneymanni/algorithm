package doIt.day232;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1219 {

    private static int N, M, startCity, endCity;
    private static long[] dist, money;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        dist = new long[N];
        money = new long[N];

        Arrays.fill(dist, Long.MIN_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, cost);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Long.parseLong(st.nextToken());
        }

        dist[startCity] = money[startCity];

        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int cost = edges[j].cost;

                if (dist[start] == Long.MIN_VALUE) {
                    continue;
                } else if (dist[start] == Long.MAX_VALUE) {
                    dist[end] = Long.MAX_VALUE;
                } else if (dist[end] < dist[start] + money[end] - cost) {
                    dist[end] = dist[start] + money[end] - cost;

                    if (i >= N - 1) {
                        dist[end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (dist[endCity] == Long.MIN_VALUE) {
            bw.write("gg\n");
        } else if (dist[endCity] == Long.MAX_VALUE) {
            bw.write("Gee\n");
        } else {
            bw.write(dist[endCity] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
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
