package Silver2.Day141;

import java.io.*;
import java.util.*;

public class BOJ24445 {
    private static int N, M, R;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 1; i <= N; i++)
            A[i].sort(Collections.reverseOrder());

        BFS(R);

        for (int i = 1; i <= N; i++)
            bw.write(rank[i] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        int idx = 1;

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            rank[node] = idx++;

            for (int i : A[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
