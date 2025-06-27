package StepByStep.minimumspanningtree;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ4386 {

    private static int N;
    private static int[] parents;
    private static Star[] milkyWay;
    private static ArrayList<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parents = new int[N];
        milkyWay = new Star[N];
        edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            milkyWay[i] = new Star(i, x, y);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Star.getDist(milkyWay[i], milkyWay[j]);

                edges.add(new Edge(milkyWay[i].idx, milkyWay[j].idx, dist));
            }
        }

        Collections.sort(edges);

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        double result = 0;

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (!same(edge.start, edge.end)) {
                result += edge.dist;
                union(edge.start, edge.end);
            }
        }

        bw.write(result + "\n");

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

    private static class Star {
        int idx;
        double x;
        double y;

        public Star(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public static double getDist(Star s1, Star s2) {
            return Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));
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
