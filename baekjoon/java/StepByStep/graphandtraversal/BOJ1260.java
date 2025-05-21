package StepByStep.graphandtraversal;

import java.io.*;
import java.util.*;

public class BOJ1260 {

    private static int N, M, V;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        DFS(V);
        System.out.println();
        BFS(V);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next : graph[v]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            System.out.print(currNode + " ");

            for (int nextNode : graph[currNode]) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
