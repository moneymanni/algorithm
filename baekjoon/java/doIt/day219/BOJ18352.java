package doIt.day219;

import java.io.*;
import java.util.*;

public class BOJ18352 {

    private static int N, M, K, X;
    private static ArrayList<Integer> result;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
        }

        BFS();

        if (result.isEmpty()) {
            bw.write("-1\n");
        } else {
            Collections.sort(result);

            for (int i : result) bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{X, 0});
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int node = info[0];
            int dest = info[1];

            if (dest == K) result.add(node);

            for (int nextNode : graph[node]) {
                if (!visited[nextNode]) {
                    queue.add(new int[]{nextNode, dest + 1});
                    visited[nextNode] = true;
                }
            }
        }
    }
}
