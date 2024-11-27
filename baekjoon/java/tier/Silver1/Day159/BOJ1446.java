package Silver1.Day159;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1446 {
    private static final int MAX_LENGTH = 10_000;

    private static int N, D;
    private static int[] distance;
    private static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= MAX_LENGTH; i++) graph.add(new ArrayList<>());
        distance = new int[MAX_LENGTH + 1];
        for (int i = 0; i <= MAX_LENGTH; i++) distance[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph.get(startPoint).add(new Node(endPoint, length));
        }

        dijkstra(0);

        bw.write(distance[D] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start) {
        if (start > D) return;

        distance[start + 1] = Math.min(distance[start + 1], distance[start] + 1);

        for (int i = 0; i < graph.get(start).size(); i++) {
            distance[graph.get(start).get(i).nextNode] =
                    Math.min(distance[graph.get(start).get(i).nextNode],
                            distance[start] + graph.get(start).get(i).weight);
        }

        dijkstra(start + 1);
    }

    static class Node {
        int nextNode;
        int weight;

        public Node(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
    }
}
