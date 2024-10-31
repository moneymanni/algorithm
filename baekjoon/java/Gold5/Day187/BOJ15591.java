package Gold5.Day187;

import java.io.*;
import java.util.*;

public class BOJ15591 {
    private static int N, Q;
    private static List<Edge>[] video;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        video = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            video[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            video[p].add(new Edge(q, r));
            video[q].add(new Edge(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];

            int cnt = BFS(v, k);

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int v, int k) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (Edge edge : video[currNode]) {
                if (!visited[edge.targetNode] && edge.USADO >= k) {
                    queue.offer(edge.targetNode);
                    visited[edge.targetNode] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Edge {
        int targetNode;
        int USADO;

        public Edge(int targetNode, int USADO) {
            this.targetNode = targetNode;
            this.USADO = USADO;
        }
    }
}
