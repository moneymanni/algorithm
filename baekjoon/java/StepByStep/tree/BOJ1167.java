package StepByStep.tree;

import java.io.*;
import java.util.*;

public class BOJ1167 {

    private static int V;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visited = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            int target, dist;
            
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            while ((target = Integer.parseInt(st.nextToken())) != -1) {
                dist = Integer.parseInt(st.nextToken());

                graph[idx].add(new Edge(target, dist));
            }
        }
        
        BFS(1);

        int maxIdx = 1;

        for (int i = 1; i <= V; i++) {
            if (dist[maxIdx] < dist[i]) {
                maxIdx = i;
            }
        }

        dist = new int[V + 1];
        visited = new boolean[V + 1];

        BFS(maxIdx);

        Arrays.sort(dist);

        bw.write(dist[V] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Edge next : graph[curr]) {
                if (!visited[next.target]) {
                    queue.add(next.target);
                    visited[next.target] = true;

                    dist[next.target] = dist[curr] + next.dist;
                }
            }
        }
    }

    private static class Edge {
        int target;
        int dist;

        public Edge(int target, int dist) {
            this.target = target;
            this.dist = dist;
        }
    }
}
