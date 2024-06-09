package Silver2.Day138;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567 {
    private static int N, M;
    private static int cnt = 0;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

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

        BFS(1);

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{v, 0});
        visited[v] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int id = info[0];
            int rel = info[1];

            if (rel != 0 && rel < 3)
                cnt++;

            for (int i : A[id]) {
                if (!visited[i]) {
                    queue.add(new int[]{i, rel + 1});
                    visited[i] = true;
                }
            }
        }
    }
}
