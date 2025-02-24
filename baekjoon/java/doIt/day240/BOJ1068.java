package doIt.day240;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {

    private static int N, excludedNode, root, leafCnt;
    private static boolean[] visited;
    private static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (target == -1) {
                root = i;
            } else {
                tree[target].add(i);
            }
        }

        excludedNode = Integer.parseInt(br.readLine());

        DFS(root);

        bw.write(leafCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;

        if (excludedNode == v) return;

        boolean isLeaf = true;

        for (int node : tree[v]) {
            if (!visited[node] && node != excludedNode) {
                isLeaf = false;
                DFS(node);
            }
        }

        if (isLeaf) {
            leafCnt++;
        }
    }
}
