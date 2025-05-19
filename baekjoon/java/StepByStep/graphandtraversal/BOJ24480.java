package StepByStep.graphandtraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ24480 {

    private static int N, M, R;
    private static int cnt;
    private static int[] arr;
    private static boolean[] visited;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        cnt = 1;
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new List[N + 1];

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
            graph[i].sort(Collections.reverseOrder());
        }

        DFS(R);

        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;
        arr[v] = cnt++;

        for (int node : graph[v]) {
            if (!visited[node]) {
                DFS(node);
            }
        }
    }
}
