package StepByStep.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4803 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            int count = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (bfs(i)) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                bw.write(String.format("Case %d: No trees.\n", testCase++));
            } else if (count == 1) {
                bw.write(String.format("Case %d: There is one tree.\n", testCase++));
            } else {
                bw.write(String.format("Case %d: A forest of %d trees.\n", testCase++, count));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        int node = 0, edge = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            node++;
            visited[curr] = true;

            for (int next : graph[curr]) {
                edge++;

                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }

        return 2 * (node - 1) == edge;
    }
}
