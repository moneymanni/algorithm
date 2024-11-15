package Gold4.Day193;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {

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

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parentNode].add(new Edge(childNode, weight));
            graph[childNode].add(new Edge(parentNode, weight));
        }

        max = 0;
        findNode = 1;

        DFS2(0, 1);
        max = 0;
        Arrays.fill(visited, false);
        DFS2(0, findNode);

//        for (int i = 1; i <= n; i++) {
//            Arrays.fill(visited, false);
//            DFS(0, i);
//        }

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int sum, int node) {
        visited[node] = true;

        max = Math.max(max, sum);

        for (Edge edge : graph[node]) {
            if (!visited[edge.targetNode])
                DFS(sum + edge.weight, edge.targetNode);
        }
    }

    private static void DFS2(int sum, int node) {
        visited[node] = true;

        if (sum > max) {
            max = sum;
            findNode = node;
        }

        for (Edge edge : graph[node]) {
            if (!visited[edge.targetNode])
                DFS2(sum + edge.weight, edge.targetNode);
        }
    }

    static class Edge {
        int targetNode;
        int weight;

        public Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }
}
