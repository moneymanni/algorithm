package Silver1.Day164;

import java.io.*;
import java.util.*;

public class BOJ15900 {
    private static int N;
    private static int answer;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        DFS(1, 0);

        bw.write((answer % 2 == 0 ? "No" : "Yes"));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int node, int depth) {
        visited[node] = true;

        for (int nextNode : A[node]) {
            if (!visited[nextNode])
                DFS(nextNode, depth + 1);
        }

        if (node != 1 && A[node].size() == 1)
            answer += depth;
    }
}
