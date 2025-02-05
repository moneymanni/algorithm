package doIt.day227;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1948 {

    private static int N, M;
    private static int[] inDegree, result;
    private static boolean[] visited;
    private static ArrayList<Edge>[] graph, reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        inDegree = new int[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, time));
            inDegree[end]++;

            reverseGraph[end].add(new Edge(start, time));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        int loadCnt = topologicalSort(startCity, endCity);

        bw.write(String.format("%d\n%d\n", result[endCity], loadCnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int topologicalSort(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Edge next : graph[curr]) {
                inDegree[next.target]--;

                result[next.target] = Math.max(
                        result[next.target], result[curr] + next.cost
                );

                if (inDegree[next.target] == 0) {
                    queue.add(next.target);
                }
            }
        }

        int loadCnt = 0;

        queue = new LinkedList<>();

        queue.add(end);
        visited[end] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Edge next : reverseGraph[curr]) {
                if (result[next.target] + next.cost == result[curr]) {
                    loadCnt++;

                    if (!visited[next.target]) {
                        visited[next.target] = true;
                        queue.add(next.target);
                    }
                }
            }
        }

        return loadCnt;
    }

    private static class Edge {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}
