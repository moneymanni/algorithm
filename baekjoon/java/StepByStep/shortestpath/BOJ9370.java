package StepByStep.shortestpath;

import java.io.*;
import java.util.*;

public class BOJ9370 {

    private static final int INF = 10_000_000;

    private static int T;
    private static int n, m, t;
    private static int s, g, h;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Integer> result;
    private static ArrayList<Edge>[] graph;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());  // 교차로
            m = Integer.parseInt(st.nextToken());  // 도로
            t = Integer.parseInt(st.nextToken());  // 목적지 후보의 개수

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());  // 출발지
            g = Integer.parseInt(st.nextToken());  // 지나간 도로
            h = Integer.parseInt(st.nextToken());  // 지나간 도로

            dist = new int[n + 1];
            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];

            Arrays.fill(dist, INF);

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if ((a == g && b == h) || (a == h && b == g)) {
                    graph[a].add(new Edge(b, d * 2 - 1));
                    graph[b].add(new Edge(a, d * 2 - 1));
                } else {
                    graph[a].add(new Edge(b, d * 2));
                    graph[b].add(new Edge(a, d * 2));
                }
            }

            result = new ArrayList<>();

            for (int i = 0; i < t; i++) {
                result.add(Integer.parseInt(br.readLine()));
            }

            dijkstra(s);

            Collections.sort(result);

            for (int num : result) {
                if (dist[num] % 2 == 1) {
                    bw.write(num + " ");
                }
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start) {
        pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (!visited[curr.target]) {
                visited[curr.target] = true;

                for (Edge next : graph[curr.target]) {
                    if (dist[next.target] > dist[curr.target] + next.dist) {
                        dist[next.target] = dist[curr.target] + next.dist;
                        pq.add(new Edge(next.target, dist[next.target]));
                    }
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int target;
        int dist;

        public Edge(int target, int dist) {
            this.target = target;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
