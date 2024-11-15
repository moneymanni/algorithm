package Gold4.Day193;

import java.io.*;
import java.util.*;

public class BOJ1922 {

    private static int N, M;
    private static int[] parents;
    private static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        edgeList = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            parents[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a, b, c));
        }

        Collections.sort(edgeList);

        int result = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.startNode) != find(edge.endNode)) {
                result += edge.cost;
                union(edge.startNode, edge.endNode);
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (parents[x] == x)
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
    }

    static class Edge implements Comparable<Edge> {
        int startNode;
        int endNode;
        int cost;

        public Edge(int startNode, int endNode, int cost) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.cost, obj.cost);
        }
    }
}
