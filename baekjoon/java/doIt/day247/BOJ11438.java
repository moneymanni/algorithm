package doIt.day247;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11438 {

    private static int N, M, max;
    private static ArrayList<Integer>[] tree;
    private static int[] depth;
    private static int[][] parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        int temp = 1;
        max = 0;

        while (temp <= N) {
            temp <<= 1;
            max++;
        }

        parent = new int[max + 1][N + 1];

        BFS(1);

        for (int k = 1; k <= max; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = executeLCA(a, b);
            bw.write(LCA + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int executeLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k = max; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        for (int k = max; k >= 0 && a != b; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }

        return LCA;
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;

        int level = 1, currSize = 1, cnt = 0;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (int next : tree[currNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);

                    parent[0][next] = currNode;
                    depth[next] = level;
                }
            }

            cnt++;

            if (cnt == currSize) {
                cnt = 0;
                currSize = queue.size();
                level++;
            }
        }
    }
}
