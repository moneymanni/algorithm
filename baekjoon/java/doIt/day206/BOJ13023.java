package doIt.day206;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {

    private static final int FRIENDSHIP_CHAIN_NUM = 4;

    private static int N, M;
    private static boolean connected;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        connected = false;
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if (connected) break;
        }

        bw.write(connected ? "1" : "0");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int node, int depth) {
        if (depth == FRIENDSHIP_CHAIN_NUM + 1 || connected) {
            connected = true;
            return;
        }

        visited[node] = true;
        for (int nextNode : graph[node]) {
            if (!visited[nextNode]) {
                DFS(nextNode, depth + 1);
            }
        }
        visited[node] = false;
    }
}
