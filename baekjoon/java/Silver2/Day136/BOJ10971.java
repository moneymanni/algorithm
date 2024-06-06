package Silver2.Day136;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10971 {
    private static int N;
    private static int minCost = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static int[][] W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0, 0);

        bw.write(minCost + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int first, int v, int depth, int cost) {
        if (depth == N && v == first) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[v][i] != 0) {
                visited[i] = true;
                DFS(first, i, depth + 1, cost + W[v][i]);
                visited[i] = false;
            }
        }
    }
}
