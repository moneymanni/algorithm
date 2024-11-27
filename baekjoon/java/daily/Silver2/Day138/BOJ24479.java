package Silver2.Day138;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24479 {
    private static int N, M, R;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int order;
    private static int[] ans;

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
        ans = new int[N + 1];

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(A[i]);

        order = 1;
        DFS(R);

        for (int i = 1; i <= N; i++)
            bw.write(ans[i] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;
        ans[v] = order++;

        for (int i : A[v]) {
            if (!visited[i])
                DFS(i);
        }
    }
}
