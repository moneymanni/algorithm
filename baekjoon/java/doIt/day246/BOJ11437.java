package doIt.day246;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11437 {

    private static int N;
    private static ArrayList<Integer>[] tree;
    private static int[] depth, parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
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

        BFS(1);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int LCA = excuteLCA(a, b);
            bw.write(LCA + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int excuteLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (depth[a] != depth[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
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
                    queue.add(next);
                    visited[next] = true;

                    parent[next] = currNode;
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
