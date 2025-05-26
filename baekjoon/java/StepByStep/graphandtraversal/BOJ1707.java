package StepByStep.graphandtraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {

    private static int K, V, E;
    private static int[] colors;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            colors = new int[V + 1];
            graph = new ArrayList[V + 1];

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean check = false;

            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    check = BFS(i, 1);
                }
                if (!check) {
                    break;
                }
            }

            bw.write(check ? "YES\n" : "NO\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean BFS(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        colors[start] = color;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph[curr]) {
                if (colors[curr] == colors[next]) {
                    return false;
                }

                if (colors[next] == 0) {
                    colors[next] = colors[curr] * -1;
                    queue.add(next);
                }
            }
        }

        return true;
    }
}
