package Gold4.Day192;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707 {

    private static int V, E;
    private static ArrayList<Integer>[] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            visited = new int[V + 1];

            for (int i = 1; i <= V; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean check = true;

            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    if (!DFS(i, 1)) {
                        check = false;
                        break;
                    }
                }
            }

            bw.write(check ? "YES\n" : "NO\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean DFS(int node, int group) {
        visited[node] = group;

        for (int nextNode : graph[node]) {
            if (visited[nextNode] == 0) {
                if (!DFS(nextNode, -group))
                    return false;
            } else if (visited[node] == visited[nextNode]) {
                return false;
            }
        }

        return true;
    }
}
