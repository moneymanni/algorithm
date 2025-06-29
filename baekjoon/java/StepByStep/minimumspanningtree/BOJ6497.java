package StepByStep.minimumspanningtree;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6497 {

    private static int n, m;
    private static int[] parents;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;

        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parents = new int[n + 1];
            pq = new PriorityQueue<>();

            for (int i = 0; i <= n; i++) {
                parents[i] = i;
            }

            int totalCost = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                pq.add(new Edge(x, y, z));
                totalCost += z;
            }

            int minCost = 0;

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();

                if (!same(edge.start, edge.end)) {
                    minCost += edge.dist;
                    union(edge.start, edge.end);
                }
            }

            bw.write(String.format("%d\n", totalCost - minCost));
        }

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

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.dist, obj.dist);
        }
    }
}
