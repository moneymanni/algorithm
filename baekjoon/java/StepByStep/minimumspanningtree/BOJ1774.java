package StepByStep.minimumspanningtree;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1774 {

    private static int N, M;
    private static int[] parents;
    private static CosmicGod[] gods;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        gods = new CosmicGod[N + 1];
        pq = new PriorityQueue<>();

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            gods[i] = new CosmicGod(i, x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start, end);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = CosmicGod.getDist(gods[i], gods[j]);

                pq.add(new Edge(gods[i].idx, gods[j].idx, dist));
            }
        }

        double result = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!same(edge.start, edge.end)) {
                result += edge.dist;
                union(edge.start, edge.end);
            }
        }

        bw.write(String.format("%.2f\n", result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static class CosmicGod {
        int idx;
        int x;
        int y;

        public CosmicGod(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public static double getDist(CosmicGod g1, CosmicGod g2) {
            return Math.sqrt(Math.pow(g1.x - g2.x, 2) + Math.pow(g1.y - g2.y, 2));
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double dist;

        public Edge(int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge obj) {
            return Double.compare(this.dist, obj.dist);
        }
    }
}
