package Gold5.Day182;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1240 {
    private static int N, M;
    private static ArrayList<Edge>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[node1].add(new Edge(node2, weight));
            list[node2].add(new Edge(node1, weight));
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];

            int result = BFS(startNode, endNode);
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int startNode, int endNode) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startNode, 0});
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int node = info[0];
            int dist = info[1];

            if (node == endNode) {
                return dist;
            }

            for (Edge edge : list[node]) {
                if (!visited[edge.targetNode]) {
                    queue.offer(new int[]{edge.targetNode, dist + edge.weight});
                    visited[edge.targetNode] = true;
                }
            }
        }

        return -1;
    }

    static class Edge {
        int targetNode;
        int weight;

        public Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }
}
