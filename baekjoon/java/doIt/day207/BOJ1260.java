package doit.day207;

import java.io.*;
import java.util.*;

public class BOJ1260 {

    private static int N, M, V;
    private static ArrayList<Integer> dfsList, bfsList;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);

        visited = new boolean[N + 1];
        BFS(V);

        for (int i : dfsList) {
            bw.write(i +  " ");
        }
        bw.write("\n");

        for (int i : bfsList) {
            bw.write(i + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int node) {
        visited[node] = true;
        dfsList.add(node);

        for (int nextNode : graph[node]) {
            if (!visited[nextNode]) {
                DFS(nextNode);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            bfsList.add(currNode);

            for (int nextNode : graph[currNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
