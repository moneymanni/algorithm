package Silver2.Day130;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int v) {
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i])
                DFS(i);
        }
    }
}
