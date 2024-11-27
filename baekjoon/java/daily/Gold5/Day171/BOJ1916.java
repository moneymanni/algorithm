package Gold5.Day171;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {
    private static int N, M;
    private static ArrayList<Node>[] list;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        int result = dijkstra(startPoint, endPoint);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.remove();
            int currPoint = currNode.end;

            if (!visited[currPoint]) {
                visited[currPoint] = true;

                for (Node node : list[currPoint]) {
                    if (!visited[node.end] && dist[node.end] > dist[currPoint] + node.weight) {
                        dist[node.end] = dist[currPoint] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node obj) {
            return this.weight - obj.weight;
        }
    }
}
