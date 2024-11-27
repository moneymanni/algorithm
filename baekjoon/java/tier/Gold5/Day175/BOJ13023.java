package Gold5.Day175;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {
    private static int N, M;
    private static int result = 0;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 0);

            if (result == 1)
                break;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == 5 || result == 1) {
            result = 1;
            return;
        }

        for (int i : graph[v]) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
