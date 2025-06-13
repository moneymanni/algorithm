package StepByStep.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {

    private static final int ROOT = 1;

    private static int N;
    private static int[] parent;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        DFS(ROOT);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;

        for (int node : graph[v]) {
            if (!visited[node]) {
                parent[node] = v;
                DFS(node);
            }
        }
    }
}
