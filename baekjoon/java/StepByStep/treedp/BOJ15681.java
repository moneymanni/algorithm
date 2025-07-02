package StepByStep.treedp;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15681 {

    private static int N, R, Q;
    private static int[] dp;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph[U].add(V);
            graph[V].add(U);
        }

        DFS(R);

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            int query = Integer.parseInt(br.readLine());

            sb.append(dp[query]).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static int DFS(int v) {
        if (dp[v] != 0) {
            return dp[v];
        }

        visited[v] = true;

        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += DFS(next);
            }
        }

        dp[v] = cnt;

        return dp[v];
    }

}
