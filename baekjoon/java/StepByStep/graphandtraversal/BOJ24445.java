package StepByStep.graphandtraversal;

import java.io.*;
import java.util.*;

public class BOJ24445 {

    private static int N, M, R;
    private static int cnt;
    private static int[] arr;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

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
            graph[i].sort(Collections.reverseOrder());
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            arr[currNode] = cnt++;

            for (int nextNode : graph[currNode]) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
