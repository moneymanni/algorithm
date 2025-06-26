package StepByStep.minimumspanningtree;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {

    private static int V, E;
    private static int[] parents;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V + 1];
        pq = new PriorityQueue<>();

        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Edge(A, B, C));
        }

        int useEdge = 0;
        int result = 0;

        while (useEdge < V - 1) {
            Edge curr = pq.poll();

            if (find(curr.start) != find(curr.end)) {
                union(curr.start, curr.end);
                result += curr.cost;
                useEdge++;
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
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
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.cost, obj.cost);
        }
    }
}
