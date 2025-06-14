package StepByStep.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {

    private static final int ROOT_NODE = 1;

    private static int n;
    private static int max;
    private static int findNode;
    private static boolean[] visited;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        max = 0;
        findNode = 1;

        DFS(0, ROOT_NODE);

        max = 0;
        Arrays.fill(visited, false);

        DFS(0, findNode);

        bw.write(max + "\n");


        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int sum, int v) {
        visited[v] = true;

        if (sum > max) {
            max = sum;
            findNode = v;
        }

        for (Edge next : graph[v]) {
            if (!visited[next.target]) {
                DFS(sum + next.weight, next.target);
            }
        }
    }

    private static class Edge {

        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

}
