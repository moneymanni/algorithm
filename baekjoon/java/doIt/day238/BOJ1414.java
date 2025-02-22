package doIt.day238;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1414 {

    private static int N, sum;
    private static int[] parent;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] chars = input.toCharArray();

            for (int j = 0; j < N; j++) {
                int temp = 0;

                if (chars[j] >= 'a' && chars[j] <= 'z') {
                    temp = chars[j] - 'a' + 1;
                } else if (chars[j] >= 'A' && chars[j] <= 'Z') {
                    temp = chars[j] - 'A' + 27;
                }

                sum += temp;

                if (i != j && temp != 0) {
                    pq.add(new Edge(i, j, temp));
                }
            }
        }

        parent = new int[N];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int useEdge = 0;
        int result = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (find(curr.s) != find(curr.e)) {
                union(curr.s, curr.e);
                result += curr.v;
                useEdge++;
            }
        }

        if (useEdge == N - 1) {
            bw.write((sum - result) + "\n");
        } else {
            bw.write("-1\n");
        }

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
