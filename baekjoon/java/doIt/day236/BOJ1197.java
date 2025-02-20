package doIt.day236;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {

    private static int N, M;
    private static int[] parent;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        pq = new PriorityQueue<Edge>();

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Edge(A, B, C));
        }

        int useEdge = 0;
        int result = 0;

        while (useEdge < N - 1) {
            Edge curr = pq.poll();

            if (find(curr.s) != find(curr.e)) {
                union(curr.s, curr.e);
                result += curr.v;
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
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.v, obj.v);
        }
    }
}
