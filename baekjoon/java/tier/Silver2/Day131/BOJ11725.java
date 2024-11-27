package Silver2.Day131;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    static int N;
    static ArrayList<Integer>[] A;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        DFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++)
            sb.append(parents[i]).append('\n');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int v) {
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                parents[i] = v;
                DFS(i);
            }
        }
    }
}
